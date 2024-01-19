pipeline {
    agent { label 'slave2' }
    stages {
        stage('checkout') {
            steps {
                sh 'rm -rf bus_booking1'
                sh 'git clone https://github.com/gshashi1408/bus_booking1.git'
            }
        }

        stage('build') {
            steps {
                script {
                    sh "mvn clean install"
                }
            }
        }
		stage('Deploy to JFrog Artifactory') {
            steps {
               // Remember this is the step which I followed for free style project.
                script {
                    rtServer(
                        id: "Artifact",
                        url: "http://43.205.243.10:8081/",
                        username: "test1",
                        password: "Welcome@123"
                    )
                }
            }
        }

        stage('Upload') {
            steps {
                script {
		// For my  undertanding rtUpload is a part of jFrog Artifactory plugin to upload artifacts to artifacts repo
                    rtUpload (
                        serverId: 'Artifact',
                        spec: '''{
                            "files": [
                                {
                                    "pattern": "target/*.jar",
                                    "target": "libs-release-local/"
                                }
                            ]
                        }'''
                    )
                }
            }
        }

        stage('Publish build info') {
            steps {
                script {
		    // For my understanding to publish build info
                    rtPublishBuildInfo serverId: "Artifact"
                }
            }
        }
    }
}
