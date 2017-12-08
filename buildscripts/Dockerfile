# Version: 0.0.1
FROM openjdk:8-jre-alpine
MAINTAINER Rob Swartenbroekx "rob.s@sparkcentral.com"
WORKDIR /app
COPY ./sparkcentral-rtm-demo-jwtgenerator .
RUN adduser -S app
USER app
CMD ./bin/sparkcentral-rtm-demo-jwtgenerator