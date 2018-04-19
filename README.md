To build project without integration tests use ./mvnw clean install

To build project with integration tests use ./mvnw clean install -Pintegration-test -DskipITTests=false

Swagger documentation available here after deployment: http://localhost:8080/rainy-hill/apiee 

I included wildfly into the project that it was possible to show without additional installation how integration tests work.