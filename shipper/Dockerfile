# FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine-slim
FROM maslick/minimalka:jdk11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} shipper-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/shipper-0.0.1-SNAPSHOT.jar"]