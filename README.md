# java-api

Para rodar esse microsserviço é necessário:
 -Estar com o banco MongoDB rodando, e criar um documento chamado: logs
 Comando Docker para rodar o mongo: docker run --name mongodb -p 27017:27017
 
 -Estar com o RabbitMQ rodando localmente: 
 Comando docker: docker run -d --hostname my-rabbit --name some-rabbit -e RABBITMQ_DEFAULT_USER=guest -e RABBITMQ_DEFAULT_PASS=guest rabbitmq:3-management
 user=guest
 password=guest

Detalhe importante: Atentar-se em rodar os dois projetos: ms-car e ms-log
