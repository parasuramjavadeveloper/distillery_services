pipeline {

    agent any
    
    stages {
    
        stage ('Build Stage') {
               
               steps {
                   withMaven(maven : 'MAVEN-3.6.0') {
                         sh 'mvn clean compile'
                   
                   }
               
               }
        }
        
        stage('Test cases Compile') {
                
               steps {
                  withMaven(maven : 'MAVEN-3.6.0') {
                         sh 'mvn test'
                   } 
              }
          }
		  
		stage('Deployement') {
            steps {
                 sh 'mvn --version'
            }
        }  
          
          }
}