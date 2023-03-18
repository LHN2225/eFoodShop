FROM maslick/minimalka:jdk11
VOLUME /tmp
ADD target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/app.jar"]