FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
EXPOSE 8082
COPY target/achat-1.0.jar.original achat-1.0.jar.original
ENTRYPOINT ["java","-jar","achat-1.0.jar.original"]