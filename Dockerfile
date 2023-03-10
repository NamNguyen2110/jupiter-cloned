FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
WORKDIR /opt/app
COPY ${JAR_FILE} application.jar
COPY docker-compose.yml docker-compose.yml
ENTRYPOINT ["java","-jar","application.jar"]
