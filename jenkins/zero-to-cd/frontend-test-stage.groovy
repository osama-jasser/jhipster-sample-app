agent {
  docker 'node:alpine'
}
steps {
  sh 'yarn install'
  sh '# yarn global add gulp-cli'
  sh '# gulp test'
}
