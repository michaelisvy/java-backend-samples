# Starting the application with default profile (h2)

`mvn spring-boot:run`


# Starting the application with MySql profile

`mvn spring-boot:run -Dspring.profiles.active=mysql`

# In order to run all the tests
* `MySql` should be started (on MacOS you can use MAMP)
* `MongoDB` should be started (on MacOS: `mongod --config /usr/local/etc/mongod.conf`)
* `RabbitMQ` should be started (on MacOs: `rabbitmq-server`)
