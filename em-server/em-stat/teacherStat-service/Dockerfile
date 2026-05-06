FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/teacherStat-service-*.jar app.jar

EXPOSE 5006

ENTRYPOINT ["java", "-jar", "app.jar"]
