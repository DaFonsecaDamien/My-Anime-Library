FROM maven:3.8.5-eclipse-temurin-17-alpine AS build
WORKDIR /home/app
COPY pom.xml .
RUN mvn clean
COPY src ./src
RUN ["mvn", "package", "-Dmaven.test.skip=true"]

FROM openjdk:17.0.2-slim-buster

COPY --from=build /home/app/target/*.jar /usr/local/lib/build.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","/usr/local/lib/build.jar"]