# Curso: Microsserviços Java com Spring Boot e Spring Cloud

*******
Tabela de conteúdo
- 1. [Descrição](#descrição)
- 2. [Microsserviços](#microsserviços)
  - 2.1. [hr-worker](#hr-worker) 
  - 2.2. [hr-payroll](#hr-payroll) 
  - 2.3. [hr-eureka-server](#hr-eureka-server) 
  - 2.4. [hr-api-gateway-zuul](#hr-api-gateway-zuul)     
  - 2.5. [hr-config-server](#hr-config-server) 
  - 2.6. [hr-user](#hr-user)
  - 2.7. [hr-oauth](#hr-oauth)
- 3. [Configurando o Postman para produtividade](#configurando-o-postman-para-produtividade)
  - 3.1. [Collection de testes](#collection-de-testes)
  - 3.2. [Variáveis](#variáveis)
  - 3.3. [Script para atribuir token à variável de ambiente do Postman](#script-para-atribuir-token-à-variável-de-ambiente-do-postman)
- 4. [Histórico de versões/Autores](#histórico-de-versõesautores)
*******


| Tecnologia | Framework | Versão do projeto |
|------------|-----------|-------------------|
| Java 11 | Spring 2.3.4.RELEASE | 1.0.0 |


## Descrição

Este projeto foi desenvolvido com o curso prático de microsserviços feito na Udemy, o curso **Microsserviços Java com Spring Boot e Spring Cloud**, ministrado pelo professor **Nélio Alves** da escola de programação **DevSuperior**.\
Neste curso foram criados dois repositórios no GitHub, um é um monorepo contendo os sete microsserviços que simular um sistema de Recursos Humanos, e o outro é o [repositório de configuração](https://github.com/RicardoLopes1/ms-course-configs).

Neste projeto você irá encontrar:
- Spring Cloud Routing
  - OpenFeign 
  - Ribbon 
  - Hystrix
  - Discovery Server Eureka
  - API Gateway Zuul
  - Config Server
  - OAuth2
  - JWT
- SQL
  - Spring Data JPA
  - Spring Data JPA Specification
  - H2 Database
  - PostgreSQL
- Testes
  - JUnit 
  - Mockito
  - JaCoCo
- Outros
  - Lombok
  - ModelMapper

## Microsserviços

### hr-worker

No projeto **hr-worker** foi desenvolvido uma aplicação para registrar os trabalhadores. Nesta aplicação é possível encontrar um CRUD simples para buscar todos os trabalhadores ou buscar por ID. Aqui é possível encontrar mapeamento de banco, um **mapper** genérico para converter entidades para DTOs, testes unitários com JUnit e cobertura de testes com JaCoCo. Este app também é um cliente Eureka.

### hr-payroll

O **hr-payroll** é um app que busca os dados dos trabalhadores no app **hr-worker** como um cliente Feign, e retorna o valor do pagamento do trabalhador. Neste app vc encontra a exemplificação de como fazer requisições de um app para outro com OpenFeign. Este app também é um cliente Eureka.\
Todos os apps que tiverem a anotação `@EnableEurekaClient` são clientes Eureka, ou seja, se conectam ao servidor Eureka (**hr-eureka-server**).

### hr-eureka-server

Este é o servidor Eureka, onde os microsserviços vão se registrar utilizando portas aleatórias, e o servidor Eureka vai tratar de registrar todas as instancias (caso haja mais de uma instancia do microsserviço). E quando houver a necessidade de "chamar" um microsserviço, basta chamar utilizando o nome do microsserviço, sem a necessidade de saber a localização, porta, etc.\
Vale ressaltar que o servidor Eureka faz o balanceamento de carga, se houver necessidade.

### hr-api-gateway-zuul

Este app serve como um portal para as chamadas das requisições dos microsserviços, o **hr-api-gateway-zuul** vai gerenciar e rotear as chamadas utilizando somente o nome dos microsserviços independente de quantas instancias existem de cada, independente de porta.

### hr-config-server

Este microsserviço é responsável por ser o servidor de configuração. O objetivo de existir um servidor de configuração é para que os nossos microsserviços tenham as suas configurações de forma centralizada, em um único repositório privado. Como este é um projeto com finalidade didática, o repositório de configuração está público [aqui](https://github.com/RicardoLopes1/ms-course-configs).\
No cenário em que o repositório esteja privado (em uma aplicação real), será necessário criar duas variáveis de ambiente com as credenciais de acesso do repositório.

Veja o exemplo no arquivo [hr-config-server/src/main/resources/application.yml](hr-config-server/src/main/resources/application.yml), na propriedade `spring.cloud.config.server.git`.

### hr-user

É o microsserviço responsável por manter um cadastros de usuário e os seus perfis, como operador e administrador. Cada perfil possui um tipo de acesso, ou seja, autorizações diferentes.

### hr-oauth

Este microsserviço é o responsável por autorização, fazendo o papel de servidor de autorização do sistema. Ao ser feito o login (autenticação), o **hr-oauth** retorna um _token_ JWT para ser enviado nas requisições, onde, dependendo do Token, o usuário terá ou não autorização para ver determinado recurso.

## Configurando o Postman para produtividade

### Collection de testes

Importe o arquivo [ms-course.postman_collection.json](ms-course.postman_collection.json) no seu Postman, esse é o arquivo com a _collection_ de testes.

### Variáveis

Crie um ambiente no seu Postman e adicione as seguintes variáveis de ambiente:

- api-gateway: `http://localhost:8765`
- config-host: `http://localhost:8888`
- client-name: myappname123
- client-secret: myappsecret123
- username: `leia@gmail.com`
- password: 123456
- token:

### Script para atribuir token à variável de ambiente do Postman

``` JavaScript
if (responseCode.code >= 200 && responseCode.code < 300) {
    var json = JSON.parse(responseBody);
    postman.setEnvironmentVariable('token', json.access_token);
}
```
Insira o _script_ na aba `Tests` na requisição do _login_.

## Histórico de versões/Autores

* Versão 1.0.0 - Lançamento inicial
  - [Paulo Ricardo da Silva Lopes](https://github.com/RicardoLopes1)

---
