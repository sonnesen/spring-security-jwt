<h1 align="center">
  Spring Security JWT
</h1>

Tutorial de referência apresentado [nesse vídeo](https://youtu.be/kEJ8a1w4a2Q) para ilustrar como implementar uma autenticação e autorização com Spring Security e JWT.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Security](https://spring.io/projects/spring-security)
- [Spring Data JDBC](https://spring.io/projects/spring-data-jdbc)
- [H2](https://www.h2database.com)
- [Lombok](https://projectlombok.org/)

## Como gerar o par de chaves RSA
```
$ openssl genrsa -out app.key 4096
```
```
$ openssl rsa -in app.key -pubout -outform PEM -out app.pub
```

## Como Executar
- Clonar repositório git:
```
git clone https://github.com/sonnesen/spring-security-jwt.git
```

- Construir o projeto:
```
./mvnw clean package
```

- Executar:
```
java -jar ./target/spring-security-jwt-0.0.1-SNAPSHOT.jar
```

- Testar ( com [httpie](https://httpie.io) ):
```
$ http -a username:password POST :8080/authenticate
```
```
$ export JWT_TOKEN=<token>
```
```
$ http -A bearer -a ${JWT_TOKEN} GET :8080/private
```