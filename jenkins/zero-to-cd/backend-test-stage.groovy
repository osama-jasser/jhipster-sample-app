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

