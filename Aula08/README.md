# Aula 8

## Crie o banco de dados
Crie um banco de dados no Postgresql. Altere a configuração em ```backend/src/main/resources/application.properties```.

O exemplo usa o banco de dados ```pcs-gme``` na porta ```5432```, username ```postgres``` e senha ```admin```.

## Iniciando o backend
Vá na pasta ```backend``` e execute:

```mvn spring-boot:run```

Abra a página [http://localhost:8080/pcs-gme/swagger-ui.html](http://localhost:8080/pcs-gme/swagger-ui.html) para verificar se funcionou.

## Inciando o frontend
Vá na pasta ```frontend``` e execute para preparar o ambiente:

```pnpm install```

Terminando a instalação, faça:

```pnpm start```

Abra a página [http://localhost:3000/pcs-gme/](http://localhost:3000/pcs-gme/) e a aplicação estará funcionando.