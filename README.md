# playwiremock-app - Aggregation REST API

Aggregation REST API to expose accounts and transactions for the users you have in your application. App connects to another provider to get this data. 
This provider can return accounts and transactions for any user. A call the /login endpoint and use the received JWT in the other requests. 
More documentation here and how to run it: https://hub.docker.com/repository/docker/mihaitatinta/wiremock-example

```shell
docker run -it --rm -p 8080:8080 mihaitatinta/wiremock-example
```

## Requirements 

You need to create 2 endpoints to expose accounts and transactions from your local application storage (anything you want - the faster, the better)
The accounts and transactions need to be updated 1 time per day in your application.
Exception handling
Nice to have: tests
Frontend is optional
Readme: how to build and run your application
Pushed to github/gitlab or similar.
Spring boot/Java 8+ are recommended but not mandatory
If you can't run Docker on your machine, you can run your own wiremock server from here: https://hub.docker.com/repository/docker/mihaitatinta/wiremock-example

## Tools, frameworks and libraries used

* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3](https://maven.apache.org)
* [Spring Tool Suite 4.5.0.RELEASE](https://spring.io/tools) 
* Spring Boot 2.2.7, Spring Data JPA with embedded database (in-memory database) H2, Spring WebFlux, WebClient
* Postman
* Docker Desktop for Windows
 
## For building and running the application
There are several ways to run this application locally.

1. Clone the repository (cmd line):

```shell
git clone https://github.com/catalinFlorea/playwiremock.git
```
or clone from Eclipse STS ->`Import Project from Git` -> `Clone URI` -> Enter above cloning address.


2. Project -> Right Click -> `Run as` -> `Spring Boot app`.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html):

```shell
mvn spring-boot:run
```

## Exposed endpoints
Done
http://localhost:8081/accounts/v1/getAccountsForUser?username=? - Get Accounts for username
http://localhost:8081/accounts/v1/syncAccounts - Only for TEST to fill DB with provider accounts
http://localhost:8081/accounts/v1/getAllAccounts - Show All Accounts from DB


```shell
curl -X POST \
  http://localhost:8081/accounts/v1/syncAccounts \
  -H 'Cache-Control: no-cache' \
  -H 'Postman-Token: 0b435d3e-5643-9b44-b1a7-4c8def4dbfa9'
  
curl -X GET \
  http://localhost:8081/accounts/v1/getAllAccounts \
  -H 'Cache-Control: no-cache' \
  -H 'Postman-Token: f8b55f79-af93-3a1e-793e-b020be4b94a3'
  
curl -X GET \
  'http://localhost:8081/accounts/v1/getAccountsForUser?username=Gigi' \
  -H 'Cache-Control: no-cache' \
  -H 'Postman-Token: ff725896-4766-1051-5502-6b6b247b9a48'
```
Not Completed
http://localhost:8081/transactions/v1/syncTransactions -  Only for TEST to fill DB with provider accounts
http://localhost:8081/transactions/v1/getAllTransactions - Get all Transactions from local DB for all accounts

```shell
curl -X POST \
  http://localhost:8081/transactions/v1/syncTransactions \
  -H 'Cache-Control: no-cache' \
  -H 'Postman-Token: c40be8bf-a7a8-cbcd-61d4-691dd0490b77'

curl -X GET \
  http://localhost:8081/transactions/v1/getAllTransactions \
  -H 'Cache-Control: no-cache' \
  -H 'Postman-Token: 740b3ee7-4524-67e9-dec0-7bab86c6d296'
```


## Improvements
* Add Spring Security on exposed endpoints - Spring Security module can be used (Basic Authentication, OAUth etc.).
* Consider using a No-SQL database engine depending non functional requirements.
* Refactor more the classes, separate better the layers and project dependencies to become lighter - get rid of modules not used.
* Pack project in Docker and deliver as Docker image.
* Better Exception Handling - maybe customized messages, but without exposing internal services, business
* Add Tests - WebTestClient can be used to mock requests
.....
