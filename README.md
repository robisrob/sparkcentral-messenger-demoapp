# Sparkcentral Messenger demo application [![Build Status](https://travis-ci.org/sparkcentral/sparkcentral-messenger-demoapp.svg)](https://travis-ci.org/sparkcentral/sparkcentral-messenger-demoapp)
Application to demonstrate the integration of Sparkcentral Messenger

## Build application
`./gradlew build`

## Run application
### Using gradle
- make sure you set the env variables `APP_ID`, `SECRET_ID` and `SECRET_KEY`
- `./gradlew run`

### Using Docker
The application is put on [Docker Hub](https://hub.docker.com/r/sparkcentralinc/sparkcentral-messenger-demoapp/). Therefore you can run the application using the following command:

`docker run -eAPP_ID=${app_id} -eSECRET_ID=${secret_id} -eSECRET_KEY={secret_key} -p5000:8080 sparkcentralinc/sparkcentral-messenger-demoapp`

## Documentation
- [Integration with a website](documentation/INTEGRATION.md)
- [JWT generator](documentation/JWTGENERATOR.md)
