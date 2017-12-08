# Version: 0.0.1
FROM openjdk:8-jre-alpine
MAINTAINER Rob Swartenbroekx "rob.s@sparkcentral.com"
WORKDIR /app
COPY ./application .
RUN adduser -S app
USER app
CMD ./bin/application