pipeline{
    agent any
    stages{
        stage('Build'){
            steps{
            sh 'mvn clean install'
            }
        }

        stage('TEST'){
            steps{
                sh 'mvn test'
            }
        }
         stage('Deploy'){
            steps{
                when { 
                    branch 'master'
                    }
                sh'mvn deploy'
            }
        }

        }
    post{
        always{
            echo 'pipeline execution completed'
        }
        success{
            echo 'deployment succeeded'
        }
        failure{
            echo 'deployment failed'
        }
    
    }
}