FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/spring-gateway-*.jar app.jar

EXPOSE 5003

ENTRYPOINT ["java", "-jar", "app.jar"]
