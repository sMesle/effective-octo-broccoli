# spring-rest-api-movie-mongodb
Simple movie Rest api with Mongodb

## Project setup
### Testing the App

```console
smesle@smesle-pc:~$ docker-compose up
```
### MongoDB

#### MongoDB Setup

Run mongodb with docker
```console
smesle@smesle-pc:~$ docker run -d -p 27017-27019:27017-27019 --name mongodb mongo
```
Go in the mongodb shell with this command:
```console
smesle@smesle-pc:~$ docker exec -it mongodb mongo
```
```console
mongodb@shell$ use movies
```
