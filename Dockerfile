FROM openjdk:8
EXPOSE 8080
ADD target/springboot-swagger-test.jar  springboot-swagger-test.jar

ENTRYPOINT ["java", "-jar", "springboot-swagger-test.jar"]