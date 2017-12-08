cd $HOME/build/sparkcentral/sparkcentral-rtm-demo-jwtgenerator
mkdir docker_workdir
./gradlew distTar
cp buildscripts/Dockerfile ./docker_workdir
cd docker_workdir
tar -xf ../build/distributions/sparkcentral-rtm-demo-jwtgenerator.tar
docker build -t sparkcentralinc/sparkcentral-rtm-demo-jwtgenerator:$TRAVIS_BUILD_NUMBER .
docker login -u="$DOCKER_USERNAME" -p="$DOCKER_PASSWORD"
docker push sparkcentralinc/sparkcentral-rtm-demo-jwtgenerator:$TRAVIS_BUILD_NUMBER
