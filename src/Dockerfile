FROM openjdk:8-alpine
RUN mkdir /deployments/ \
  && chmod -R 777 /deployments/
ADD /target/FinaOps-0.0.1-SNAPSHOT.jar /deployments/FinaOps-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/deployments/FinaOps-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
