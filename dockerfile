FROM openjdk:17-alpine
COPY ./target/*.jar /
EXPOSE 32010
ENTRYPOINT ["java", "-jar", "./target/*.jar"]