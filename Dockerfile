From openjdk:latest
ADD target/ecommerce-egen-SpringBoot.jar ecommerce-egen-SpringBoot.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ecommerce-egen-SpringBoot.jar"]
