# hr-config-server

## Gerando imagem Docker

- Crie um arquivo na raiz do projeto com o nome de `Dockerfile` e adicione o script a seguir:
``` Dockerfile
FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/hr-config-server-0.0.1-SNAPSHOT.jar hr-config-server.jar
ENTRYPOINT ["java","-jar","/hr-config-server.jar"]
```

Com o terminal na raiz do projeto, faça os seguintes passos:

- Compile o seu projeto:
``` bash
./mvnw clean package
```

- Gere a imagem Docker:
```
docker build -t hr-config-server:v1 .
```

- Crie e inicie o seu container:
``` bash
docker run -p 8888:8888 --name hr-config-server --network hr-net -e GITHUB_USER=RicardoLopes1 -e GITHUB_PASS= hr-config-server:v1
```
