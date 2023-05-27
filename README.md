# DSList
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/daviembrito/dslist/blob/main/LICENSE)

## About

DSList consists of an API that provides information about games stored in a database. It is possible to retrieve information about a specific game, as well as lists of games and their contents.

## Technologies 
### API Server
- Java
- Spring Boot
- JPA / Hibernate
- Maven

### Database
- H2
- PostgreSQL

### Production Environment
- Railway

## Prerequisites

Before building the project, make sure you have the following tools installed in your environment:

- Java Development Kit (JDK) 17
- Maven

## Setup

- Clone the project repository
```shell
git clone https://github.com/daviembrito/DSList.git
cd DSList
```
- Download the project dependencies
```shell
mvn clean install
```
- Configure the database information depending on the profile selected in "application.properties". By default, the test profile is loaded. You can change H2 configuration properties in "application-test.properties".You must provide a valid database URL, username and password
- Start the server
```shell
mvn spring-boot:run
```

## Endpoints

- **GET /games**: returns a simplified version of all games stored in the database

![/games example](https://cdn.discordapp.com/attachments/400108474748370946/1111869891411185714/image.png)

- **GET /games/{id}**: returns all atributes of the game with the provided id

![/games/id example](https://cdn.discordapp.com/attachments/400108474748370946/1111871502678245467/image.png)

- **GET /lists**: returns all game lists from the database

![/lists example](https://cdn.discordapp.com/attachments/400108474748370946/1111872564927668244/image.png)

- **GET /lists/{id}/games**: returns all games belonging to the list with the specified ID

![/lists/id/games example](https://cdn.discordapp.com/attachments/400108474748370946/1111873402832162866/image.png)