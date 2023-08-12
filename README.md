# Transactions Game

In this project, I'll manipulate a JSON list of transactions and apply various filters and sorting actions to make it easier to read.

## Table of Contents

- [Overall View](#overall-view)
- [Installation](#installation)
- [Utilization](#utilization)
 
## Overall View
This is an easy to install Spring Boot application for a code game contest.

## Installation
To run the Spring Boot application, follow these steps:

1. Open the `application.properties` file.
2. Change the application port by modifying the following line:
```
server.port = 8080
```
3. Run the following command to start the application:
```
mvn spring-boot:run
```

## Utilization
To use the API, follow these steps:

1. Run the Spring Boot application.
2. Make requests to the API using tools like Postman.
3. Use the `/v1/api` path to interact with the API.
4. You can add filter or sorting parameters to the API requests:
- `merchant`: Filter by merchant name.
- `amount`: Filter by transaction amount.
- `status`: Filter by transaction status.
- `sortBy`: Specify the field for sorting.
- `sortOrder`: Specify the sorting order (ascending or descending).
- `page`: Specify the page number.
- `pageSize`: Specify the number of items per page.


I hope you like the project 😄

