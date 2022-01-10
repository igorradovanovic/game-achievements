# Game Achievement Application

[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

[Spring Boot](http://projects.spring.io/spring-boot/) Game Achievements App.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [PostgreSQL](https://www.postgresql.org)


## Running PostgreSQL Database in Docker Container

- [PostgreSQL Docker Container](https://github.com/igorradovanovic/game-achievements/tree/master/postgre-docker)

The easiest way to deploy docker container is to build it and run it:

```shell
sudo docker build -t  game-achievement .
```
This will create:

* An DockerImage called "game-achievement"

In order to run this docker container execute the following command

```shell
sudo docker run  --name postgres -p 5432:5432 game-achievemenet
```

## Running the application locally

Download dependencies:

```shell
mvn install
```
In order to run this App you must have initialized Docker Container
There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.ingsoftware.gameachievements.GameAchievementsApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Testing

Test this application with Postman Collection. Download postman collection from this Repository.

-[Postman Testing Collection](https://github.com/igorradovanovic/game-achievements/tree/master/postman)

## Copyright

Igor Radovanovic.
