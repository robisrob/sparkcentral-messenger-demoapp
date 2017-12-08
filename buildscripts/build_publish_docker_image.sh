cd $HOME/build/sparkcentral/sparkcentral-rtm-demo-jwtgenerator
mkdir docker_workdir
./gradlew :application:distTar
cp buildscripts/Dockerfile ./docker_workdir
cd docker_workdir
tar -xf ../application/build/distributions/application.tar
docker build -t sparkcentral/sparkcentral-rtm-demo-jwtgenerator:$TRAVIS_BUILD_NUMBER .
docker login -u="$DOCKER_USERNAME" -p="$DOCKER_PASSWORD"
docker push sparkcentralinc/kafka-experiment:$TRAVIS_BUILD_NUMBER
