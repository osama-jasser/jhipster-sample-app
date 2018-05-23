stage('Deploy to Staging') {
  agent any
  steps {

    sh './deploy.sh staging'
    sh 'echo Notifying the Team!'
  }
}

stage('Deploy to Production') {
  agent any
  input {
    message 'Deploy to production?'
    ok 'Fire away!'
  }
  steps {
    sh './deploy.sh production'
    sh 'echo Notifying the Team!'
  }
}
