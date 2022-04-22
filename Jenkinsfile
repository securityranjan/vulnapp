pipeline {
  agent any 
  tools {
    maven 'Maven'
  }
  stages {
    stage ('Initialize') {
      steps {
        sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
            ''' 
      }
    }
    
  stage ('Check-Git-Secret') {
      steps {
        sh 'rm trufflehog || true'
        sh 'docker run gesellix/trufflehog --json https://github.com/singhkranjan/webapp.git > trufflehog'
        sh 'cat trufflehog'
      }
    } 
  
      stage ('SAST') {
      steps {
        withSonarQubeEnv('sonar') {
          sh 'mvn sonar:sonar'
          sh 'cat target/sonar/report-task.txt'
        }
      }
    }
    
    
  stage ('Build') {
      steps {
      sh 'mvn clean package'
       }
    }
    
    stage('DAST/Qualys'){
        steps{
            getImageVulnsFromQualys imageIds: 'e0421a24221d', useGlobalConfig: true
        }
    }
    
    
    stage ('Deploy-To-Tomcat') {
            steps {
           sshagent(['tomcat']) {
                sh 'scp -o StrictHostKeyChecking=no target/*.war ubuntu@3.110.179.103:/prod/apache-tomcat-9.0.60/webapps/webapp.war'
              }      
           }       
        }
    
   
    
    }
}
