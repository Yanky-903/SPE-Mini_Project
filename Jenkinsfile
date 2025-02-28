pipeline {
    agent any
    tools {
        maven 'Maven3'
    }
    environment {
        DOCKER_IMAGE = 'yashraj-singh-chauhan/scientific-calculator:latest'
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
                sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                sh 'docker tag yashraj-singh-chauhan/scientific-calculator:latest $DOCKER_USER/scientific-calculator:latest'
                sh 'docker push $DOCKER_USER/scientific-calculator:latest'
            }
        }
    }


        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i inventory deploy-docker.yml'
            }
        }

    }
}
