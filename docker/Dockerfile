FROM maven:3.6.3-jdk-11-slim as build
COPY ../src /app/mobaas/src
COPY ../pom.xml /app/mobaas/
RUN mvn -f /app/mobaas/pom.xml clean package
COPY  /app/mobaas/target/mobaas-0.0.1-SNAPSHOT.jar /usr/local/lib/mobaas.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/mobaas.jar"]
