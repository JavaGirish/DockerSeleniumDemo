FROM maven:3.6.0-jdk-8-alpine

COPY src /home/DockerSeleniumDemo/src

COPY pom.xml /home/DockerSeleniumDemo

COPY testng.xml /home/DockerSeleniumDemo

RUN mvn -f /home/DockerSeleniumDemo/pom.xml clean test -DskipTests=true
