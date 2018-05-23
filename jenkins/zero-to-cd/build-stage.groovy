agent {
  docker {
    image 'maven:3-alpine'
    args '-v /home/jenkins/docker/.m2:/root/.m2'
  }
}

steps {
  sh 'mvn -B -DskipTests clean package'
  stash name: 'war', includes: 'target/**'
}
