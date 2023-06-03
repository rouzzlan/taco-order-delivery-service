pipeline {
    agent any
    tools {
        jdk 'graalvm-ee-java17-22.3.1'
    }
    environment {
        DOCKER_TAG = 'harbour.739.net/taco-cloud/delivery-management-service:0.0.3-1'
    }
    stages {
        stage('Setup') {
            steps {
                sh '''
                    ./mvnw clean install
                '''
            }
        }
        stage('Build') {
            steps {
                sh '''
                    ./mvnw package -Pnative -Dquarkus.native.container-build=true
                '''
            }
            post {
                always {
                    archiveArtifacts 'target/*'
                }
            }

        }
        stage('Docker Build') {
            when {
            expression {
                env.BRANCH_NAME == 'master'
              }
            }
            steps {
                sh '''
                    docker build -f src/main/docker/Dockerfile.native -t ${DOCKER_TAG} .
                    docker login harbour.739.net -u="rouslan" -p="50m9FiD3"
                    docker push ${DOCKER_TAG}
                '''
            }
        }
    }
}