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
    
    
 
   
    
    }
}
