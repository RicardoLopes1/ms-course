# hr-user

## Gerando imagem Docker

- Crie um arquivo na raiz do projeto com o nome de `Dockerfile` e adicione o _script_ a seguir:
``` Dockerfile
FROM openjdk:11
VOLUME /tmp
ADD ./target/hr-user.jar hr-user.jar
ENTRYPOINT ["java","-jar","/hr-user.jar"]
```

Com o terminal na raiz do projeto, faça os seguintes passos:

- Compile o seu projeto:
``` bash
./mvnw clean package -DskipTests
```

- Gere a imagem Docker:
```
docker build -t hr-user:v1 .
```

- Crie e inicie o seu container:
``` bash
docker run -P --network hr-net hr-user:v1
```

---
