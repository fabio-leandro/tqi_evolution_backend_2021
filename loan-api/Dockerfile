FROM openjdk:11
WORKDIR /app
COPY target/loan-api-0.0.1-SNAPSHOT.jar /app/loan-api.jar
ENTRYPOINT ["java","-jar","loan-api.jar"]