FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY ./target/ibagent-0.0.1-SNAPSHOT.jar ./
CMD ["java", "-jar", "ibagent-0.0.1-SNAPSHOT.jar"]