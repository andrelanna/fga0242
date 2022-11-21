
UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

---

## Aula 6 - Testes unitários, prática 

**Tópicos da aula**

Últimos tópicos sobre testes unitários: 
  - Testes parametrizados
  - Testes de lançamentos de exceções
  - Categorias de testes

**Vídeo da aula**
* [Vídeo](https://youtu.be/ZxQP4R08vK4)

**Código da aula**  
* [Testes](tests/)
* [Excecoes](exception/)
* [Codigo](app/)

**Exercicios de fixacao**

_Esse problema foi perguntado pela Google_

> Dadas duas strings A e B, retorne se A pode ser deslocada algum número de vezes
> para obter B. 
> 
> Por exemplo, se A é `abcde` e B é `cdeab`, retorne `true`. Se A é `abc` e B é
> `acb`, retorne `falso`.

Crie duas categorias de teste, chamadas `Funcional` e `Excecao`. Os testes
funcionais deverão garantir:

 a) que a solução consegue descobrir quando ocorre o deslocamento da string A
para se obter a string B e   
 b) quando não há deslocamento possível para transformar A em B, deve-se lançar
a exceção `StringsDiferentesException`. 

Quando uma das duas strings A ou B for fazia, deverá ser lançada uma exceção
`StringVaziaException`. Um teste deverá ser escrito para garantir o lançamento
dessa exceção. 

Utilize as seguintes strings para a escrita dos testes. 

| A    | B     |
|------|-------|
|abcde | cdeab |
|gama  | amag  |
|arara | arara |
|mesa  | ames  |
