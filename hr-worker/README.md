# ${ProjectName}
### ${Language} ${Framework/LIB}
### Versão ${Version}

## Descrição

Faça aqui uma descrição explicativa do ${ProjectName}, de forma que o leitor tenha ampla clareza sobre sua funcionalidade e utilidade.\
Lembre-se que abaixo você terá um texto de exemplo o qual você precisa editar e refletir a realidade de seu projeto.\

Configurado com as seguintes dependências:
- Ferramentas de desenvolvimento
    - Spring Boot DevTools
    - Lombok
- Web
    - Spring Web
- Database
    - Spring Data JPA
    - H2 Database
- Outros
    - ModelMapper

---


## Pre-requisitos

Antes de iniciar, se assegure que possui os requisitos abaixo:
* Java 11

---

## Compilação / Configuração

Para compilar / instalar o ${ProjectName}, siga as seguintes etapas:

Windows, Linux and macOS:

- Executar o setup para convenção de mensagens de commits:
    - No Linux
        > `$ chmod +x ./.githooks/*` \
        > `$ git config core.hooksPath .githook`


Gerando o arquivo JAR:

No Linux
``` bash
./mvnw clean install
```

No Windows
``` bash
mvnw.cmd clean install
```

---

## Instalação / Execução

Executando o projeto:

No Linux
``` bash
./mvnw spring-boot:run
```

No Windows
``` bash
mvnw.cmd spring-boot:run
```
---
## Documentação

Para mais detalhes, por favor, olhe a [documentação do projeto](/docs/README.md).

## Histórico de versões/Autores

* Versão 1.0 - Lançamento inicial
  - [Paulo Ricardo da Silva Lopes](https://github.com/RicardoLopes1)

## Licença

- [Apache 2.0](https://choosealicense.com/licenses/apache-2.0/) - Herdado das dependências do Spring
- [MIT](https://choosealicense.com/licenses/mit/) - Herdado do Lombok

---
