FROM maven:3.6.3-jdk-11-slim as build
COPY src /app/mobaas/src
COPY pom.xml /app/mobaas/
EXPOSE 8080
CMD ls -lah /app/mobaas/
RUN mvn -f /app/mobaas/pom.xml clean package
CMD ls -lah  /usr/local/lib/
ENTRYPOINT ["java","-jar","/app/mobaas/target/mobaas-0.0.1-SNAPSHOT.jar"]
