# spring-mysql-docker-example

This project developed with `SpringBoot` with `mysql` for web app. Project using dockerization for operations.


To run project;

Firstly pull `mysql` from [hub.docker.com](https://hub.docker.com/_/mysql/)
```
docker pull mysql
```

After pull, you need a mysql container. If you don't have any mysql container, you should create it
```
docker run --name <custom_mysql_container_name> -e MYSQL_ROOT_PASSWORD=passwrd -d mysql
```
Now we ready to enter your mysql container
```
docker exec -it <custom_mysql_container_name> mysql -uroot -ppasswrd
```

some mysql commands;
```
show databases;                     //to view current databases

create database <custom_db_name>;   //create new custom database

use <custom_db_name>;               //switch to any database;

show tables;                        //to view tables at selected database;
```



After all you ready for run project
```
mvn clean install
```

Note: For this project, Docker image will create automaticly after build. If you want to create your own image
```
docker build -f Dockerfile -t springboot-mysql/springboot-mysql-docker .
```

Finally run Docker image that we created
```
docker run -p 6000:6000 --link=<custom_mysql_container_name> springboot-mysql/springboot-mysql-docker 
```

