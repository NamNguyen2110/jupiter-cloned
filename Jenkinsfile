pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME   = '528573161741.dkr.ecr.ap-southeast-1.amazonaws.com/opp-service'
        OLD_IMAGE_TAG       = 'v1.0.0'
        IMAGE_TAG           = 'v1.0.0'
        CONTAINER_NAME      = 'opp-service'

        AWS_PRIVATE_IP      = credentials('awsPrivateIP')
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
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'gitlab-credential', url: 'https://gitlab.com/project-jup/backend/opp-service']]])
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
        stage('Clean old images from ECR and Push new image to ECR') {
            steps{
                script {
                    sh 'aws ecr batch-delete-image --repository-name ${CONTAINER_NAME} --image-ids imageTag=${OLD_IMAGE_TAG}'
                    sh "docker-compose push ${CONTAINER_NAME}"
                }
            }
        }
        stage('Remove old images on current EC2 instance') {
            steps {
                script {
                    sh 'docker rmi -f ${DOCKER_IMAGE_NAME}:${IMAGE_TAG}'
                }
            }
        }
        stage('Service Deployment on Service EC2 Instance') {
            steps {
                sshagent(['bdb-jup-ssh-cred']) {
                    // Connect to service aws ec2 instance
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@${AWS_PRIVATE_IP} aws ecr get-login-password --region ${AWS_DEFAULT_REGION} | ssh -o StrictHostKeyChecking=no ubuntu@${AWS_PRIVATE_IP} docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com'

                    // Pull latest image
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@${AWS_PRIVATE_IP} docker pull ${DOCKER_IMAGE_NAME}:${IMAGE_TAG}'

                    // Transfer docker-compose config file into local instance from new container
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@${AWS_PRIVATE_IP} docker create ${DOCKER_IMAGE_NAME}:${IMAGE_TAG}'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@${AWS_PRIVATE_IP} sudo mkdir -p /opt/dconfig/${CONTAINER_NAME}'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@${AWS_PRIVATE_IP} sudo docker cp $(ssh -o StrictHostKeyChecking=no ubuntu@${AWS_PRIVATE_IP} docker ps -ql):/opt/app/docker-compose.yml /opt/dconfig/${CONTAINER_NAME}'

                    // Remove newly created container and run the service with docker compose
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@${AWS_PRIVATE_IP} docker rm -v $(ssh -o StrictHostKeyChecking=no ubuntu@${AWS_PRIVATE_IP} docker ps -ql)'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@${AWS_PRIVATE_IP} docker stop ${CONTAINER_NAME}'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@${AWS_PRIVATE_IP} docker-compose --file /opt/dconfig/${CONTAINER_NAME}/docker-compose.yml up -d ${CONTAINER_NAME}'

                    // Clean old image and container
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@${AWS_PRIVATE_IP} docker container prune -f'
                    sh 'ssh -o StrictHostKeyChecking=no ubuntu@${AWS_PRIVATE_IP} docker image prune -f'
                }
            }
        }
    }
}