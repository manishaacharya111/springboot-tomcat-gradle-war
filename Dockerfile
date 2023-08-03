FROM openjdk:11 as base
VOLUME /tmp
ARG WAR_FILE
COPY ${WAR_FILE} app.jar
ENTRYPOINT {"java", "war", "/app.war"}
