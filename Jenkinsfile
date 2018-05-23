pipeline {
  agent any
  stages {
    stage('Build') {
      agent any
      steps {
        sh 'env '
      }
    }
    stage('Backend') {
      parallel {
        stage('Unit') {
          steps {
            sh 'env'
          }
        }
        stage('Performance') {
          steps {
            sh 'env'
          }
        }
      }
    }
    stage('Front-end') {
      steps {
        sh 'env'
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