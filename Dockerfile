# Version: 0.0.1
FROM openjdk:8-jre-alpine
MAINTAINER Rob Swartenbroekx "rob.s@sparkcentral.com"
WORKDIR /app
ADD ./sparkcentral-rtm-demo-jwtgenerator.tar .
RUN adduser -S app
USER app
CMD ./bin/sparkcentral-rtm-demo-jwtgenerator