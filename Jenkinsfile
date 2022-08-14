pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME   = '528573161741.dkr.ecr.ap-southeast-1.amazonaws.com/opp-service'
        OLD_IMAGE_TAG       = 'v1.0.0'
        IMAGE_TAG           = 'v1.0.0'
        CONTAINER_NAME      = 'opp-service'

        AWS_ACCOUNT_ID      = "528573161741"
        AWS_DEFAULT_REGION  = "ap-southeast-1"
        IMAGE_REPO_NAME     = "opp-service"
        REPOSITORY_URI      = "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}"
    }
    tools {
        maven 'Maven'
    }
    stages {
        stage('Checkout Gitlab') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/devops-opp-service-test']], extensions: [], userRemoteConfigs: [[credentialsId: 'gitlab-credential', url: 'https://gitlab.com/project-jup/backend/opp-service']]])
            }
        }
        stage('Build Maven') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Login To Docker') {
            steps {
                withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u phnam3 -p ${dockerhubpwd}'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker-compose build ${CONTAINER_NAME}'
                }
            }
        }
        stage('Login to AWS ECR') {
            steps {
                script {
                    sh "aws ecr get-login-password --region ${AWS_DEFAULT_REGION} | docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com"
                }
            }
        }
        stage('Clean old image and Push to ECR') {
            steps{
                script {
                    sh 'aws ecr batch-delete-image --repository-name ${CONTAINER_NAME} --image-ids imageTag=${OLD_IMAGE_TAG}'
                    sh "docker-compose push ${CONTAINER_NAME}"
                }
            }
        }
        stage('Remove current images') {
            steps {
                script {
                    sh 'docker rmi -f ${DOCKER_IMAGE_NAME}:${IMAGE_TAG}'
                    sh 'docker rmi -f ${REPOSITORY_URI}:${IMAGE_TAG}'
                }
            }
        }
        stage('Connect to EC2 Instance') {
            steps {
                sshagent(['bdb-jup-ssh-cred']) {
                    // Connect to main aws ec2 instance
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@172.31.19.133 aws ecr get-login-password --region ${AWS_DEFAULT_REGION} | ssh -o StrictHostKeyChecking=no ubuntu@172.31.19.133 docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com'

                    // Clean old image and container
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@172.31.19.133 docker rm -f ${CONTAINER_NAME}'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@172.31.19.133 docker rmi -f ${DOCKER_IMAGE_NAME}:${IMAGE_TAG}'

                    // Pull latest image
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@172.31.19.133 docker pull ${DOCKER_IMAGE_NAME}:${IMAGE_TAG}'

                    // Transfer docker-compose config file into local instance from new container
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@172.31.19.133 docker create ${DOCKER_IMAGE_NAME}:${IMAGE_TAG}'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@172.31.19.133 sudo mkdir -p /etc/docker/${CONTAINER_NAME}'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@172.31.19.133 sudo docker cp $(ssh -o StrictHostKeyChecking=no ubuntu@172.31.19.133 docker ps -ql):/opt/app/docker-compose.yml /etc/docker/${CONTAINER_NAME}'

                    // Remove newly created container and run the service with docker compose
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@172.31.19.133 docker rm -v $(ssh -o StrictHostKeyChecking=no ubuntu@172.31.19.133 docker ps -ql)'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@172.31.19.133 docker-compose --file /etc/docker/${CONTAINER_NAME}/docker-compose.yml up -d ${CONTAINER_NAME}'
                }
            }
        }
    }
}