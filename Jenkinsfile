#!groovy
@Library('so-jenkins-shared') _

pipeline {
    agent any

    triggers {
        cron('H 0 * * *')
    }
    options {
        timeout( time: 10, unit: 'MINUTES' )
        buildDiscarder(logRotator(numToKeepStr: '30'))
        disableConcurrentBuilds()
    }
    environment{
        BUILD_TIMESTAMP = new Date().format('yyyyMMddHHmmss')
    }
    stages {
        stage('Preparation') {
            steps {
                script {
                    env.BUILD_PROJECT = env.JOB_NAME.split("/")[0]
                    env.BLUE_OCEAN_URL = "${env.JENKINS_URL}blue/organizations/jenkins/${BUILD_PROJECT}/detail/${BRANCH_NAME}/${BUILD_NUMBER}/pipeline"
                }

                installGeneral()
            }
        }
        stage('Tests') {
            steps {
                echo 'Test releases....'

                sh "docker run -i --rm --name maven-tests -u \$(id -u):\$(id -g) -v \$(pwd)/my_so/:/usr/src/maven-tests -w /usr/src/maven-tests markhobson/maven-chrome mvn clean test || true"
            }
        }
        stage('reports') {
            steps {
                script {
                    allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'my_so/allure-results']]
                ])
                }
            }
    }
    }
    post {
        always {
            script{
              if (currentBuild.result == 'SUCCESS') {
                env.BUILD_COLOR = 'good'
              } else if (currentBuild.result == 'FAILURE') {
                env.BUILD_COLOR = 'danger'
              } else {
                env.BUILD_COLOR = 'warning'
              }
            }

            slackSend channel: '#ci',
                color: "${env.BUILD_COLOR}",
                message: "<${env.BUILD_URL}|${env.JOB_NAME} ${currentBuild.displayName}> completed ${currentBuild.result}. <${env.BLUE_OCEAN_URL}|Build logs>\n<${env.BUILD_URL}allure/|Allure results>"

            deleteDir() /* clean up our workspace */
        }
    }
}
