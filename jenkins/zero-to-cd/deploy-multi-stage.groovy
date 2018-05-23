stage('Deploy to Staging') {
  steps {
    sh './deploy.sh staging'
    sh 'echo Notifying the Team!'
  }
}

stage('Deploy to Production') {
  input {
    message 'Deploy to production?'
    ok 'Fire away!'
  }
  steps {
    sh './deploy.sh production'
    sh 'echo Notifying the Team!'
  }
}
