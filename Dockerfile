FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
EXPOSE 8089
COPY target/achat-1.0.jar.original achat-1.0.jar.original
ENTRYPOINT ["java","-jar","achat-1.0.jar.original"]