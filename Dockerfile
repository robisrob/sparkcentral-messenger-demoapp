# Version: 0.0.1
FROM openjdk:9-jre
MAINTAINER Rob Swartenbroekx "rob.s@sparkcentral.com"
WORKDIR /app
ADD ./sparkcentral-messenger-demoapp.tar .
RUN useradd app
USER app
CMD ./sparkcentral-messenger-demoapp/bin/sparkcentral-messenger-demoapp
