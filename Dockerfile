FROM openjdk:17-alpine
MAINTAINER baeldung.com
COPY target/MyAnimeLibrary-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]