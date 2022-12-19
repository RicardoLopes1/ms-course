# Curso: Microsserviços Java com Spring Boot e Spring Cloud



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

## hr-worker

No projeto **hr-worker** foi desenvolvido uma aplicação para registrar os trabalhadores. Nesta aplicação é possível encontrar um CRUD simples para buscar todos os trabalhadores ou buscar por ID. Aqui é possível encontrar mapeamento de banco, um **mapper** genérico para converter entidades para DTOs, testes unitários com JUnit e cobertura de testes com JaCoCo. Este app também é um cliente Eureka.

## hr-payroll

O **hr-payroll** é um app que busca os dados dos trabalhadores no app **hr-worker** como um cliente Feign, e retorna o valor do pagamento do trabalhador. Neste app vc encontra a exemplificação de como fazer requisições de um app para outro com OpenFeign. Este app também é um cliente Eureka.\
Todos os apps que tiverem a anotação `@EnableEurekaClient` são clientes Eureka, ou seja, se conectam ao servidor Eureka (**hr-eureka-server**).

## hr-eureka-server

Este é o servidor Eureka, onde os microsserviços vão se registrar utilizando portas aleatórias, e o servidor Eureka vai tratar de registrar todas as instancias (caso haja mais de uma instancia do microsserviço). E quando houver a necessidade de "chamar" um microsserviço, basta chamar utilizando o nome do microsserviço, sem a necessidade de saber a localização, porta, etc.\
Vale ressaltar que o servidor Eureka faz o balanceamento de carga, se houver necessidade.

## hr-api-gateway-zuul

Este app serve como um portal para as chamadas das requisições dos microsserviços, o **hr-api-gateway-zuul** vai gerenciar e rotear as chamadas utilizando somente o nome dos microsserviços independente de quantas instancias existem de cada, independente de porta.

## hr-config-server

Este microsserviço é responsável por ser o servidor de configuração. O objetivo de existir um servidor de configuração é para que os nossos microsserviços tenham as suas configurações de forma centralizada, em um único repositório privado. Como este é um projeto com finalidade didática, o repositório de configuração está público [aqui](https://github.com/RicardoLopes1/ms-course-configs).\
No cenário em que o repositório esteja privado (em uma aplicação real), será necessário criar duas variáveis de ambiente com as credenciais de acesso do repositório.

Veja o exemplo no arquivo [hr-config-server/src/main/resources/application.yml](hr-config-server/src/main/resources/application.yml), na propriedade `spring.cloud.config.server.git`.

## hr-user

É o microsserviço responsável por manter um cadastros de usuário e os seus perfis, como operador e administrador. Cada perfil possui um tipo de acesso, ou seja, autorizações diferentes.

## hr-oauth

Este microsserviço é o responsável por autorização, fazendo o papel de servidor de autorização do sistema. Ao ser feito o login (autenticação), o **hr-oauth** retorna um _token_ JWT para ser enviado nas requisições, onde, dependendo do Token, o usuário terá ou não autorização para ver determinado recurso.


## Histórico de versões/Autores

* Versão 1.0.0 - Lançamento inicial
  - [Paulo Ricardo da Silva Lopes](https://github.com/RicardoLopes1)

---
