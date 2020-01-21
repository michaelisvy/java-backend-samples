# Build system
As of now, this project can be built using Gradle or Maven. Gradle seems much more concise so it's possible that we'll move to Gradle only in the future.

# Starting the application with default profile (h2)
`gradle bootRun`
`mvn spring-boot:run`

# Visualising our API (based Swagger documentation)
Start the application and connect to `http://localhost:8080/swagger-ui.html`


# Starting the application with MySql profile

`SPRING_PROFILES_ACTIVE=mysql gradle clean bootRun`
`mvn spring-boot:run -Dspring.profiles.active=mysql`

# In order to run all the tests
* `MySql` should be started (on MacOS you can use MAMP)
* `MongoDB` should be started (on MacOS: `mongod --config /usr/local/etc/mongod.conf`)
* `RabbitMQ` should be started (on MacOs: `rabbitmq-server`)
