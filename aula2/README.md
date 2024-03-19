
UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

---

## Aula 2 - Revisão de testes unitários e frameworks xUnit

**Tópicos da aula**
- Revisão de testes unitários e frameworks xUnit; 
- propriedades de testes, 
- independência e atomicidade de testes

**Slides da aula**
* [Slides](https://docs.google.com/presentation/d/1cA1Sae4qgXidI7ZyVGhI-r9l5o0TMBrj5Yl0qyj2xfU/edit?usp=sharing)

### Exercícios de fixação

##### Exercício 1: Operações Matemáticas Simples:  

Crie uma classe chamada `Calculadora` que possua dois métodos: `soma` e `multiplica`. O método soma deve receber dois inteiros como parâmetros e retornar a soma deles. O método multiplica também deve receber dois inteiros como parâmetros e retornar o produto deles. Escreva casos de teste utilizando JUnit 4 para verificar se os métodos soma e multiplica estão retornando os resultados corretos.

##### Exercício 2: Verificação de Tipos e Valores Desenvolva três classes com métodos específicos:  
 - Uma classe `Condicional` com um método `ehMaior` que recebe dois inteiros e retorna um booleano indicando se o primeiro é maior que o segundo.  
 - Uma classe `Matematica` com um método `pi` que retorna o valor aproximado de pi como um float. Considere o erro máximo permitido de 0.001.  
 - Uma classe `StringUtil` com um método `unir` que concatena duas strings recebidas como parâmetros e retorna a string resultante.  

Para cada um desses métodos, escreva casos de teste utilizando JUnit 4 que empreguem asserções para validar se os valores retornados estão corretos. 


##### Exercício 3: Testando um Carrinho de Compras de E-commerce  

Imagine que você está trabalhando no desenvolvimento de uma aplicação de e-commerce. Uma das funcionalidades cruciais do sistema é o carrinho de compras, que permite aos usuários adicionar produtos, remover produtos e calcular o total da compra. Sua tarefa é implementar e testar a classe `CarrinhoDeCompras`.

A classe `CarrinhoDeCompras` deve ter os seguintes métodos:

 - `adicionarProduto(Produto p)`: adiciona um produto ao carrinho.
 - `removerProduto(Produto p)`: remove um produto do carrinho.
 - `calcularTotal()`: retorna o valor total dos produtos no carrinho como um float.

A classe `Produto` deve ter um `id` do tipo `int`, um `nome` do tipo `String`, e um `preço` do tipo `float`.

Escreva casos de teste utilizando JUnit 4 que verifiquem:

  - Se um produto adicionado está realmente no carrinho.
  - Se o produto removido não está mais no carrinho.
  - Se o total calculado está correto após adicionar e remover produtos.

Utilize asserções para verificar se os métodos estão funcionando conforme o
esperado. Por exemplo, após adicionar um produto, use `assertTrue` para verificar
se o `id` do produto está presente na lista de produtos do carrinho. Para o
cálculo do total, use `assertEquals` com uma margem de erro para validar o valor
retornado pelo método `calcularTotal()`.
