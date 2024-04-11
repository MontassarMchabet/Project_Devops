FROM openjdk:8-jdk-alpine
EXPOSE 8082
COPY target/Project_Devops-1.0.jar Project_Devops-1.0.jar
ENTRYPOINT ["java","-jar","Project_Devops-1.0.jar"]
