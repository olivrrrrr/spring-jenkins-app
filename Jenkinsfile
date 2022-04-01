pipeline {

        environment {
            registry = "oliverxekwalla/java-app"
            registryCredential = "DOCKERHUB_CREDENTIALS"
            dockerImage = ''
            }

       agent any

       stages {
               stage('Cloning our Git') {
                   steps {
                   git branch: 'main', credentialsId:'GITHUB_CREDENTIALS', url:"https://github.com/olivrrrrr/jenkins_docker_test"
                   }
               }

            stage('Build JAR') {
                docker.image('maven:3.8.4-openjdk-17').inside('-v /root/.m2:/root/.m2') {
                    sh 'mvn -B clean package'
                    stash includes: '**/target/*.jar', name: 'jar'
                }
            }

            stage('Build Image') {
                unstash 'jar'
                app = docker.build image
            }

              stage('Deploying Docker Image to Dockerhub') {
                         steps {
                               script {
                                   docker.withRegistry('', registryCredential) {
                                  dockerImage.push()
                                   }
                              }
                           }
                       }
}
