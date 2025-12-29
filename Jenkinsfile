pipeline {
    agent any

    tools {
        maven 'Maven'   // make sure Maven is configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-creds',
                    url: 'https://github.com/<your-username>/APIAutomationCucumber.git',
                    branch: 'main'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            publishHTML(target: [
                reportDir: 'target',
                reportFiles: 'cucumber-report.html',
                reportName: 'Cucumber Test Report'
            ])
        }
    }
}
