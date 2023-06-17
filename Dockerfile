#FROM openjdk:17-jdk-alpine
#ARG JAR_FILE=api/target/*.jar
#COPY ./api/target/api-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM maven:3.8.4-openjdk-17 AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY api /tmp/api
COPY core /tmp/core
WORKDIR /tmp/
RUN mvn clean install -Pdocker

FROM openjdk:17-jdk-alpine
COPY --from=MAVEN_TOOL_CHAIN /tmp/api/target/api-0.0.1-SNAPSHOT.jar app.jar

RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java", "-jar", "/app.jar"]