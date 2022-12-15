# hr-eureka-server

## Gerando imagem Docker

- Crie um arquivo na raiz do projeto com o nome de `Dockerfile` e adicione o _script_ a seguir:
``` Dockerfile
FROM openjdk:11
VOLUME /tmp
EXPOSE 8761
ADD ./target/hr-eureka-server.jar hr-eureka-server.jar
ENTRYPOINT ["java","-jar","/hr-eureka-server.jar"]

```

Com o terminal na raiz do projeto, faça os seguintes passos:

- Compile o seu projeto:
``` bash
./mvnw clean package
```

- Gere a imagem Docker:
```
docker build -t hr-eureka-server:v1 .
```

- Crie e inicie o seu container:
``` bash
docker run -p 8761:8761 --name hr-eureka-server --network hr-net hr-eureka-server:v1
```
