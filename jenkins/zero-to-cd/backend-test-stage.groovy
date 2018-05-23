agent {
  docker {
    image 'maven:3-alpine'
    args '-v /home/bitwiseman/docker/.m2:/root/.m2'
  }
}

steps {
  parallel(
   'Unit' : {
     unstash 'war'
     sh 'mvn -B -Dmaven.test.failure.ignore=true test || exit 0'
     junit '**/surefire-reports/**/*.xml'
    },
    'Performance' : {
      unstash 'war'
      sh '# ./mvn -B gatling:execute'
   })
 }
