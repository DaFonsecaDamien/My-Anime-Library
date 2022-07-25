FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
MAINTAINER baeldung.com
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]