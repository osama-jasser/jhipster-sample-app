agent {
  docker {
    image 'maven:3-alpine'
    args '-v $HOME/jenkins/blueocean-host/.m2:/root/.m2:z -u root'
  }
}

steps {
  sh 'mvn -B -DskipTests clean package'
  stash name: 'war', includes: 'target/**'
}
