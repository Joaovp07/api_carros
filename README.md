# API Carros

API REST em Java com Spring Boot para gerenciamento de carros e usuários.

## Descrição

Este projeto foi desenvolvido para expor endpoints REST para cadastro, consulta, atualização e remoção de registros de carros e usuários, utilizando Spring Data JPA com MySQL.

A aplicação inclui:

- CRUD de carros
- CRUD de usuários
- Persistência com MySQL
- API REST com endpoints organizados por controller
- Estrutura baseada em Spring Boot

## Stack Tecnológica

- Java 21
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- MySQL Connector
- Maven
- Lombok

## Estrutura do Projeto

```text
api_carros/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/api_carros/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       │   ├── entity/
│   │   │       │   └── repository/
│   │   │       ├── service/
│   │   │       └── ApiCarrosApplication.java
│   │   └── resources/
│   │       └── application.yml
│   └── test/
│       └── java/
│           └── com/example/api_carros/
├── pom.xml
├── mvnw
├── mvnw.cmd
├── HELP.md
└── README.md
```

## Endpoints

### Carros

- GET `/carro` → status da API
- GET `/carro/list` → lista todos os carros
- GET `/carro/{id}` → busca carro por ID
- POST `/carro` → cadastra um carro
- PUT `/carro/{id}` → atualiza um carro
- DELETE `/carro/{id}` → exclui um carro

### Usuários

- GET `/usuario` → status da API
- GET `/usuario/list` → lista todos os usuários
- GET `/usuario/{id}` → busca usuário por ID
- POST `/usuario` → cadastra um usuário
- PUT `/usuario/{id}` → atualiza um usuário
- DELETE `/usuario/{id}` → exclui um usuário

## Configuração do Banco de Dados

A aplicação usa MySQL com configuração definida em `src/main/resources/application.yml`.

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/carro?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
    username: root
    password: admin
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: update
```

Antes de executar a aplicação, certifique-se de que:

1. O MySQL esteja instalado e em execução.
2. O banco `carro` exista ou seja criado pela aplicação.
3. As credenciais informadas no arquivo de configuração estejam corretas.

## Pré-requisitos

- Java 21+
- Maven 3.9+
- MySQL

## Executando o Projeto

Na raiz do projeto, execute:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

Ou no Windows:

```bash
mvnw.cmd clean install
mvnw.cmd spring-boot:run
```

## Porta da Aplicação

A API está configurada para rodar na porta:

```text
http://localhost:8090
```

## Observações

- O projeto foi gerado com Spring Initializr e adaptado para uma API de gerenciamento de veículos.
- A configuração atual está voltada para ambiente local com banco MySQL.
- Os arquivos de controllers, services e entities seguem uma organização básica em camadas.

## Licença

Este projeto é destinado a fins de estudo e desenvolvimento.

## Autor

Joaovp07
