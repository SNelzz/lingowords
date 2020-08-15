FROM adoptopenjdk/openjdk14:alpine-jre
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]