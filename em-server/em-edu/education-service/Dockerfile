FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/education-service-*.jar app.jar

EXPOSE 5005

ENTRYPOINT ["java", "-jar", "app.jar"]
