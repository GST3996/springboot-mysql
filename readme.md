## Spring boot micro web service 


Tech Details:

Java 1.8
Spring Boot 2.1
JPA
Mysql
Maven
GITHUB (https://github.com/GST3996/springboot-mysql)
JUnit
Swagger

Implementation Steps :


As per the use case, the prerequisites setup is done installing MySQL, creating a GITHUB repository.
As per the installation guideline on DB setup, DDL and DML Scripts are executed to create tables and to insert data under the "employees" schema of the MySQL database.
Spring boot app is created using spring initializer with required dependencies.
JPA project is created connecting MySQL "employees" schema to generate java entities.
Request Mapping controller, service, JPA repositories implementations are added for CRUD operation.
Search Operation implemented using JPA criteria.
Generic Exception handlers, user-defined exceptions are added for exception handling.
JUnit test cased added for the exposed APIs.
Spring boot app is packaged as a jar file using MAVEN and deployed in embedded TOMCAT container.
The swagger configuration is included in-app to create API contract information and swagger UI(PFA) is used to test the API exposed.
Using git bash, code is pushed to the GITHUB repository (https://github.com/GST3996/springboot-mysql.git).


