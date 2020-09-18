### Stack
- Java
- Maven
- [GraphQL](https://github.com/leangen/graphql-spqr) 

### O que é ?
CRUD utilizando GraphQL

### Como rodar ?
- Execute **`mvn clean package`**
- Execute **`mvn spring-boot:run`**
- Para testar, estou utilizando como client o [Insomnia](https://insomnia.rest/)

> **POST** http://localhost:8080/graphql

![](https://github.com/lucianoortizsilva/spring-boot-graphql/blob/master/src/main/resources/static/github/mutation-createperson.jpg)

<hr>

![](https://github.com/lucianoortizsilva/spring-boot-graphql/blob/master/src/main/resources/static/github/query-findallperson.jpg)

<hr>

![](https://github.com/lucianoortizsilva/spring-boot-graphql/blob/master/src/main/resources/static/github/mutation-updateperson.jpg)

<hr>

![](https://github.com/lucianoortizsilva/spring-boot-graphql/blob/master/src/main/resources/static/github/mutation-deleteperson.jpg)
