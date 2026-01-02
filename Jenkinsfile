pipeline {
    agent any
    stages {
        stage('Mail Test') {
            steps {
                mail(
                    to: 'thippeshdevops26@gmail.com',
                    subject: 'JENKINS MAIL TEST',
                    body: 'If you receive this mail, SMTP is working.'
                )
            }
        }
    }
}
