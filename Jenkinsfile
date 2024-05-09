pipeline {
    agent any
    stages {
        stage('Compile') {
            steps {
                script {
                    // Compile the Spring Boot application with Maven
                    sh 'mvn compile'
                }
            }
        }
        stage('Unit Test') {
            steps {
                script {
                    // Run unit tests with Maven
                    sh 'mvn test'
                }
            }
        }
        }
    }
}
