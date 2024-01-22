@Library('library-demo')
pipeline {
    agent { label 'slave2' }
    stages {
        stage('checkout') {
            steps {
                sh 'rm -rf bus_booking1'
                sh 'git clone https://github.com/gshashi1408/bus_booking1.git'
            }
        }

        stage('Build') {
            steps {
                script {
                    build 'install'
                }
            }
        }
	}
}
