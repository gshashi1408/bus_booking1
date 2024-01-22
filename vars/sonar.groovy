def call() {
       // Your SonarQube scan steps go here
       sh 'mvn sonar:sonar -Dsonar.projectKey=sonar -Dsonar.host.url=http://18.170.23.153:9000 -Dsonar.java.binaries=target/classes'
   }
return this
