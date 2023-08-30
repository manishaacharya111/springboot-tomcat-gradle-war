pipeline {
    environment {
registry = "merry211/mycoolapp"
registryCredential = '3d6bd144-f532-468f-91c1-f26b23061be9'
dockerImage = ''
}
    agent any
    tools {
        gradle 'Gradle 7.4.2'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/manishaacharya111/springboot-tomcat-gradle-war.git'
            }
        }
    stage('Build') {
            steps {
                sh 'gradle clean build'
            }
        }    
    stage("build & SonarQube analysis") {
            steps {
              withSonarQubeEnv(installationName: 'sonar 9', credentialsId: 'jenkins-sonarkey') {
                sh 'gradle sonarqube'
              }
            }
          }
    stage("Quality Gate") {
            steps {
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
            }
        }
    stage('Building our image') {
    steps{
      script {
       dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
    }     
}
