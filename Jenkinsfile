pipeline {
    agent any
    tools {
        maven 'Maven3'
    }
    environment {
        DOCKER_IMAGE = 'yashraj-singh-chauhan/scientific-calculator:latest'  // Your Docker Hub repo
    }
    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/Yanky-903/SPE-Mini_Project'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }
stage('Push to Docker Hub') {
    steps {
        withCredentials([usernamePassword(credentialsId: 'DockerHubCred', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
            sh 'docker login -u $DOCKER_USER -p $DOCKER_PASS'
            sh 'docker tag yashraj-singh-chauhan/scientific-calculator:latest $DOCKER_USER/scientific-calculator:latest'
            sh 'docker push $DOCKER_USER/scientific-calculator:latest'
        }
    }
}

    }
}
