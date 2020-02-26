FROM maven:3.6-jdk-8 as BUILD
 
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
WORKDIR /usr/src/app
RUN mvn package

FROM openjdk:8-alpine

COPY --from=BUILD /usr/src/app/target/FinaOps-0.0.1-SNAPSHOT.jar /


ENTRYPOINT ["java", "-jar", "FinaOps-0.0.1-SNAPSHOT.jar" ]
