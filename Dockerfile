FROM openjdk:17-jdk-slim as build

COPY target/hotels-0.0.1-SNAPSHOT.jar hotels-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/hotels-0.0.1-SNAPSHOT.jar"]