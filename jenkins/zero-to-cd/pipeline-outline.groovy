pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'echo Build'
      }
    }
    stage('Backend Test') {
      steps {
        parallel(
          "Unit": {
            sh 'echo Unit'

          },
          "Performance": {
            sh 'echo Performance'

          }
        )
      }
    }
    stage('Frontend Test') {
      steps {
        sh 'echo Static Analyis'
      }
    }
    stage('Static Analysis') {
      steps {
        sh 'echo Static Analyis'
      }
    }
    stage('Deploy') {
      steps {
        sh 'echo Deploy'
      }
    }
  }
}
