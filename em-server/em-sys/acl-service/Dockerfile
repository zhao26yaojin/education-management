FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/acl-service-*.jar app.jar

EXPOSE 5007

ENTRYPOINT ["java", "-jar", "app.jar"]
