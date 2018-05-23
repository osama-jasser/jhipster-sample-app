
# docker run -p 8080:8080 -u root -v /var/run/docker.sock:/var/run/docker.sock jenkinsci/blueocean
# docker run -p 32769:8080 -p 32768:50000 -v /var/run/docker.sock:/var/run/docker.sock -v /home/bitwiseman/docker/blueocean:/var/jenkins_home --name blueocean-master jenkinsci/jenkins:latest
# docker run -p 32769:8080 -p 32768:50000 --name blueocean-master jenkinsci/blueocean:latest
docker run -p 32769:8080 -p 32768:50000 --name blueocean-master jenkinsci/jenkins:latest
