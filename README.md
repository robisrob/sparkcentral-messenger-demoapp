# Sparkcentral Messenger demo application [![Build Status](hhttps://travis-ci.org/sparkcentral/sparkcentral-messenger-demoapp.svg)](https://travis-ci.org/sparkcentral/sparkcentral-rtm-demo-jwtgenerator)
This is an application to demonstrate the integration of Sparkcentral Messenger with a website

## Build application
`./gradlew build`

## Run application
### Using gradle
- make sure you set the env variables `APP_ID`, `SECRET_ID` and `SECRET_KEY`
- `./gradlew run`

### Using Docker
The application is put on [Docker Hub](https://hub.docker.com/r/sparkcentralinc/sparkcentral-rtm-demo-jwtgenerator/). Therefore you can run the application using the following command:

`docker run -eAPP_ID=${app_id} -eSECRET_ID=${secret_id} -eSECRET_KEY={secret_key} -p5000:8080 sparkcentralinc/sparkcentral-rtm-demo-jwtgenerator:26`

## Documentation
- [Integration with a website](documentation/INTEGRATION.md)
- [JWT generator](documentation/JWTGENERATOR.md)
