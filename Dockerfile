# Version: 0.0.1
FROM openjdk:8-jre-alpine
MAINTAINER Rob Swartenbroekx "rob.s@sparkcentral.com"
WORKDIR /app
ADD ./sparkcentral-rtm-demo-jwtgenerator.tar .
RUN adduser -S app
USER app
CMD ./sparkcentral-rtm-demo-jwtgenerator/bin/sparkcentral-rtm-demo-jwtgenerator