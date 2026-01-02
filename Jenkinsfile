pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        success {
            emailext(
                subject: "BUILD SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                <html>
                <body>
                <h2 style="color:green;">Build Successful</h2>
                <p><b>Job:</b> ${env.JOB_NAME}</p>
                <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>
                <p><b>Build URL:</b>
                <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                </body>
                </html>
                """,
                to: "thippesh.kumar@gmail.com",
                mimeType: 'text/html'
            )
        }

        failure {
            emailext(
                subject: "BUILD FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                <html>
                <body>
                <h2 style="color:red;">Build Failed</h2>
                <p><b>Job:</b> ${env.JOB_NAME}</p>
                <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>
                <p><b>Build URL:</b>
                <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                <p>Please find the failure screenshots attached.</p>
                </body>
                </html>
                """,
                to: "thippesh.kumar@gmail.com",
                attachmentsPattern: 'target/screenshots/*.png',
                mimeType: 'text/html'
            )
        }

        always {
            publishHTML(target: [
                reportDir: 'target',
                reportFiles: 'cucumber-report.html',
                reportName: 'Cucumber Test Report'
            ])
        }
    }
}
