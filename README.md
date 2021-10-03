# Differences between DAO and Repository Patterns

This purpose of this project is understand the Data Object Access(DAO) and Repository 
Patterns, write a simple API to use both patterns.


This API handles two different entities, once entity handle different logic.

- The entity Tweet is a representation of a tweet user.
- The entity User is a representation of a user.

## Out of scope

- The project is not considered suitable for production.
- The connectivity with the database is coupled to the code, if you want to add your 
  own database you have to modify the constant in the given class.
- in the same way the tests are coupled to the development database, they may contain 
  some errors when running them in your environment.

## Behaviour

This app is for educational purposes, i would not consider taking the implementation 
for a serious project, although I could give some code ideas with some good practices.

### User
- Can create a user
- Can get all users is saved

### Tweet

- Can create new tweets
- Can get all tweets by user email

## Running Project

This is a project that uses spring boot, you can run the project with the spring 
command bia terminal

```shell
./mvnw spring-boot:run
```

For create a executable jar, run this command
```shell
/mvnw clean package
```

## Docker

This project has its dockerfile configured for the application to run, run the 
following command in the terminal to create the container

```shell
docker build -t [username dockerhub]/[name container] .
```

**example**
```shell

docker build -t annonymous/sample-project .
```
**create a container**

```shell
 docker run -d -p 8090:8080 --name example-jar annonymous/sample-project
```

## Last Words

I hope this project will be useful to someone else.