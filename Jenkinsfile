pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/DivsRepo/HelloWebService.git'
            }
        }

        stage('Build') {
            steps {
                sh './mvnw -B clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t divyajdocker/hellowebservice:latest .'
            }
        }

        stage('Docker Hub Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '''
                        echo "$DOCKER_PASS" | docker login \
                            -u "$DOCKER_USER" --password-stdin
                        docker push divyajdocker/hellowebservice:latest
                        docker logout
                    '''
                }
            }
        }
    }
}
