# Version: 0.0.1
FROM openjdk:8-jre-alpine
MAINTAINER Rob Swartenbroekx "rob.s@sparkcentral.com"
WORKDIR /app
ADD ./sparkcentral-messenger-demoapp.tar .
RUN adduser -S app
USER app
CMD ./sparkcentral-messenger-demoapp/bin/sparkcentral-messenger-demoapp
