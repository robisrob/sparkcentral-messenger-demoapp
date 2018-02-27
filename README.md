# Sparkcentral Messenger demo application 
Application to demonstrate the integration of Sparkcentral Messenger

## Build application
`./gradlew build`

## Run application
After registering a Sparkcentral Messenger Channel in Sparkcentral, you will get an informationscreen with the APP_ID, SECRET_ID and SECRET_KEY. When starting the application, you need to pass these values, so that the demo application will be connected with your channel.

After starting the application, you can open it by going to [http://localhost:8080](http://localhost:8080)
### Using gradle
- make sure you set the env variables `APP_ID`, `SECRET_ID` and `SECRET_KEY`
- `./gradlew run`

### Using Docker
The application is put on [Docker Hub](https://hub.docker.com/r/sparkcentralinc/sparkcentral-messenger-demoapp/). Therefore you can run the application using the following command:

`docker run -eAPP_ID=${app_id} -eSECRET_ID=${secret_id} -eSECRET_KEY={secret_key} -p8080:8080 sparkcentralinc/sparkcentral-messenger-demoapp`

### Enable the detection of container-limited amount of RAM
Pass the following environment variable to your container:
`SPARKCENTRAL_MESSENGER_DEMOAPP_OPTS: -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap`

## Documentation
- [Integration with a website](documentation/INTEGRATION.md)
- [JWT generator](documentation/JWTGENERATOR.md)
