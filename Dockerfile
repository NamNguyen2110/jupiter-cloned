FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
ENV password bdbJupiter123
ENV profile dev
WORKDIR /opt/app
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","application.jar"]
