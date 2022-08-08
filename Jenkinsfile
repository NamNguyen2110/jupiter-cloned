pipeline {
    agent any
    environment {
          DOCKER_IMAGE_NAME  = 'phnam3/opp-service'
          IMAGE_TAG          = 'v1.0.0'
          CONTAINER_NAME     = 'opp-service'
    }
    tools {
        maven 'Maven'
    }
    stages {
        stage('Checkout Gitlab') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/devops-opp-service-test']], extensions: [], userRemoteConfigs: [[credentialsId: 'gitlab-username-pwd', url: 'https://gitlab.com/project-jup/backend/opp-service']]])
            }
        }
        stage('Build Maven') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Login To Docker and Clean Docker Old Images') {
            steps {
                sh 'docker rm -f $CONTAINER_NAME'
                sh 'docker rmi -f $DOCKER_IMAGE_NAME:$IMAGE_TAG'
                withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd2')]) {
                    sh 'docker login -u phnam3 -p ${dockerhubpwd2}'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker-compose build $CONTAINER_NAME'
                }
            }
        }
        // stage('Push to Docker Hub') {
        //     steps {
        //         script {
        //             sh 'docker-compose push $CONTAINER_NAME'
        //         }
        //     }
        // }
        stage('Run Docker Image') {
            steps{
                script {
                    sh "docker-compose up -d $CONTAINER_NAME"
                }
            }
        }
    }
}