FROM openjdk:17
ADD target/LoanAppClient2-0.0.1-SNAPSHOT.jar loan_app_client2.jar
EXPOSE 8022
ENTRYPOINT ["java", "-jar", "loan_app_client2.jar"]