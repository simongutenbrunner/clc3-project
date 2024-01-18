FROM openjdk:17
EXPOSE 8080
ADD target/calculator.jar calculator
ENTRYPOINT ["java", "-jar", "/calculator.jar"]