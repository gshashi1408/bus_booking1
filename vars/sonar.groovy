
def call(String name = 'value'){
    echo "Building java project & ${name}"
    withSonarQubeEnv('sonar') {
    sh '''
       mvn clean package sonar:sonar
    '''
}
}
