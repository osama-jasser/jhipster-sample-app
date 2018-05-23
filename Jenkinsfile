pipeline {
  agent none
  stages {
    stage('Build') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v $HOME/jenkins/blueocean-host/.m2:/root/.m2:z -u root'
        }

      }
      steps {
        sh 'mvn -B -DskipTests clean package'
        stash(name: 'war', includes: 'target/**')
      }
    }
    stage('Backend') {
      parallel {
        stage('Unit') {
          agent {
            docker {
              image 'maven:3-alpine'
              args '-v $HOME/jenkins/blueocean-host/.m2:$HOME/.m2:z -u root'
            }

          }
          steps {
            unstash 'war'
            sh 'mvn -B -DtestFailureIgnore test || exit 0'
            junit '**/surefire-reports/**/*.xml'
          }
        }
        stage('Performance') {
          agent {
            docker {
              image 'maven:3-alpine'
              args '-v $HOME/jenkins/blueocean-host/.m2:/root/.m2:z -u root'
            }

          }
          steps {
            unstash 'war'
            sh '# ./mvn -B gatling:execute'
          }
        }
      }
    }
    stage('Front-end') {
      agent {
        docker {
          image 'node:alpine'
        }

      }
      steps {
        sh 'yarn install'
        sh '# yarn global add gulp-cli'
        sh '# gulp test'
      }
    }
    stage('Static Analysis') {
      steps {
        sh 'env'
      }
    }
    stage('Deploy') {
      steps {
        sh 'env'
      }
    }
  }
}