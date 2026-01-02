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
            mail(
                to: 'thippeshdevops26@gmail.com',
                subject: "BUILD SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
					BUILD SUCCESS

					Job Name   : ${env.JOB_NAME}
					Build No   : ${env.BUILD_NUMBER}
					Build URL  : ${env.BUILD_URL}
					"""
								)
        }

        failure {
            mail(
                to: 'thippeshdevops26@gmail.com',
                subject: "BUILD FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
					BUILD FAILED

					Job Name   : ${env.JOB_NAME}
					Build No   : ${env.BUILD_NUMBER}
					Build URL  : ${env.BUILD_URL}

					Please check Jenkins console output and reports.
					"""
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
