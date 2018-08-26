# meli-test

Tecnologias utilizadas:

* Java 8
* JUnit 5 (TDD)
* Spring boot
* Spring web
* Spring Data(Jpa, Hibernate)
* H2 (Por se tratar apenas de um teste, resolvi utilizar o banco mais prático possível. Poderia ter sido um Docker também...) 

Para rodar a aplicação: ./mvnw spring-boot:run ou rodar o método main da classe Application.

Endpoints:
* Verificar se o DNA é Mutante: POST http:localhost:8080/mutant
* Estatisticas: GET http:localhost:8080/mutant/stats
