pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v $HOME/jenkins/blueocean-host/.m2:/root/.m2:z -u root'
    }

  }
  stages {
    stage('Build') {
      agent any
      steps {
        sh 'mvn -B -DskipTests clean package'
        stash(name: 'war', includes: 'target/**')
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