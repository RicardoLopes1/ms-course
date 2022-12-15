# hr-api-gateway-zuul

## Gerando imagem Docker

- Crie um arquivo na raiz do projeto com o nome de `Dockerfile` e adicione o _script_ a seguir:
``` Dockerfile
FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/hr-api-gateway-zuul.jar hr-api-gateway-zuul.jar
ENTRYPOINT ["java","-jar","/hr-api-gateway-zuul.jar"]
```

Com o terminal na raiz do projeto, faça os seguintes passos:

- Compile o seu projeto:
``` bash
./mvnw clean package -DskipTests
```

- Gere a imagem Docker:
```
docker build -t hr-api-gateway-zuul:v1 .
```

- Crie e inicie o seu container:
``` bash
docker run -p 8765:8765 --name hr-api-gateway-zuul --network hr-net hr-api-gateway-zuul:v1
```
- `docker`: chamada do Docker.
- `run`: comando Docker para criar um container.
- `-p 8765:8765`: porta da máquina que será usada : porta do container.
- `--name hr-api-gateway-zuul`: nome do container.
- `--network hr-net`:  nome da rede que o container irá rodar.
- `hr-api-gateway-zuul:v1`: nome da imagem que será usada para criar o container.
