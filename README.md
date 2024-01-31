# DesafioUbots

# Sobre
Esta projeto foi desenvolvido como parte do Desafio Técnico da empresa Ubots. Seu propósito é criar uma API REST para criar, atualização, listagem, deleção e avaliação de filmes, podendo também ter um sistema de recomendação de filmes que não foram avaliados.

# Tecnologias Utilizadas
. Linguagem de Programação: Java
. Framework: Spring
. Banco de Dados: PostgreSQL

# Como executar o projeto
1 - Clone este repositório
$ git clone https://github.com/gabrieljmoura10/DesafioUbots.git

2 - Crie o banco de dados dentro do gerenciado desejado: PgAdmin, Dbeaver
Com o nome de "moviesdb"

3 - Abra o projeto em sua IDE desejada, utilizei o Intellij Idea

4 - Execute na classe Main.java

5 - Abra algum API Client, utilizei o Insomnia 

6 - Acesse a url http://localhost:8080/movies com a request POST para adicioar um novo filme no formato JSON
Utilize essa formatação para adicionar o filme
{
  "title" : "nome do filme",
  "description" : "descrição do filme"
}

7 - Para listar os filmes acesse a url http://localhost:8080/movies com a request GET

8 - Para atualizar um filme acesse a url http://localhost:8080/movies/{id do filme} com a request PUT
Utilize essa formatação para atualizar um determinado filme
{
  "title" : "nome do filme",
  "description" : "descrição do filme"
}

8 - Para deletar um filme acesse a url http://localhost:8080/movies/{id do filme} com a request DELETE

9 - Para receber uma recomendação de filme não avaliado acesse a url http://localhost:8080/movies/recommendations com a request GET

10 - Para avaliar um filme acesse a url  http://localhost:8080/reviews com a request POST
Utilize essa formatação para adicionar uma avaliação, foi definido a avaliação de 1 a 5
{
  "rating" : 4,
  "movieId" : "ID do filme"
}
