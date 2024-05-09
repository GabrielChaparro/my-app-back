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
        stage('SonarQube Analysis') {
            steps {
                script {
                    // Run SonarQube analysis
                    sh 'mvn sonar:sonar'
                }
            }
        }
        stage('OWASP Dependency Check') {
            steps {
                script {
                    // Run OWASP Dependency Check
                    sh 'mvn org.owasp:dependency-check-maven:check'
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    // Build the Spring Boot application with Maven
                    sh 'mvn clean package'
                }
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    // Build Docker image
                    docker.build('spring-boot-app')
                }
            }
        }
        stage('Security Scan with Trivy') {
            steps {
                script {
                    // Run security scan with Trivy
                    sh 'trivy --exit-code 0 --severity HIGH --no-progress spring-boot-app:latest'
                }
            }
        }
        stage('Container Registry') {
            steps {
                script {
                    // Push Docker image to Container Registry
                    docker.withRegistry('https://your-container-registry-url', 'container-registry-credentials-id') {
                        docker.image('spring-boot-app').push('latest')
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // SSH into deployment server and deploy the Docker image
                    sshagent(['your-ssh-credentials-id']) {
                        sh 'ssh user@your-server "docker pull your-container-registry-url/spring-boot-app:latest && docker-compose up -d"'
                    }
                }
            }
        }
    }
    
    post {
        failure {
            script {
                // Send notification to Teams in case of failure
                teamNotify(
                    status: "FAILURE",
                    color: "#FF0000",  // Red color for failure
                    message: "Jenkins Pipeline failed for ${currentBuild.fullDisplayName}"
                )
            }
        }
    }
}
