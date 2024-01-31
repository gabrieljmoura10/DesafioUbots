# DesafioUbots

# Sobre
Esta projeto foi desenvolvido como parte do Desafio Técnico da empresa Ubots. Seu propósito é desenvolver uma API REST para criar, atualizar, listar, deletar e avaliar filmes, podendo também ter um sistema de recomendação de filmes que não foram avaliados.

# Tecnologias Utilizadas
<br/>Linguagem de Programação: Java 17
<br/>Framework: Spring
<br/>Banco de Dados: PostgreSQL

# Como executar o projeto
1 - Clone este repositório
<br/>
git clone https://github.com/gabrieljmoura10/DesafioUbots.git


2 - Crie o banco de dados dentro do gerenciado desejado: PgAdmin, Dbeaver
<br/>Com o nome de "moviesdb"

3 - Abra o projeto em sua IDE desejada, utilizei o Intellij Idea

4 - Execute na classe Main.java

5 - Abra algum API Client, utilizei o Insomnia 

6 - Acesse a url http://localhost:8080/movies com a request POST para adicionar um novo filme no formato JSON
<br/>Utilize essa formatação para adicionar o filme
<br/>{
  <br/>"title" : "nome do filme",
  <br/>"description" : "descrição do filme"
<br/>}


7 - Para listar os filmes acesse a url http://localhost:8080/movies com a request GET

8 - Para atualizar um filme acesse a url http://localhost:8080/movies/{id do filme} com a request PUT
<br/>Utilize essa formatação para atualizar um determinado filme
<br/>{
  <br/>"title" : "nome do filme",
  <br/>"description" : "descrição do filme"
<br/>}


8 - Para deletar um filme acesse a url http://localhost:8080/movies/{id do filme} com a request DELETE

9 - Para receber uma recomendação de filme não avaliado acesse a url http://localhost:8080/movies/recommendations com a request GET

10 - Para avaliar um filme acesse a url  http://localhost:8080/reviews com a request POST
<br/>Utilize essa formatação para adicionar uma avaliação, foi definido a avaliação de 1 a 5
<br/>{
  <br/>"rating" : 4,
  <br/>"movieId" : "ID do filme"
<br/>}

