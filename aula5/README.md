
UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

---

## Aula 5 - Exercícios de Testes Unitários 

**Tópicos da aula**
- Testes unitários
- Casos de testes
- Suítes de testes
- Categorias de testes
- Testes de Exceção
- Testes parametrizados


**Exercicios de fixação:**

**Casos de testes simples, categorizados e organizados por suítes de testes**

Seja o seguinte cenário: 

A condição de existência de um triângulo é que cada lado deve ser maior ou igual do que o módulo da diferença e menor ou igual do que o módulo da soma dos outros dois lados: $|b-c| \leq a \leq |b+c|$. Considere que todos os triângulos desse exercício sejam triângulos retângulos, em que $c$ é a hipotenusa e $a$ e $b$ sejam os catetos.

Com base nesse cenário, faça o que se pede:

1. Crie um caso de teste parametrizado que, para dados $a$, $b$ e $c$, sejam calculadas as áreas e perímetros dos triângulos apresentados abaixo. Rotule os testes como `Funcional`. Considere $a$ como sendo a altura e $b$ como sendo a base do triângulo. 

| a  | b  | c  |Área|Per.|
|----|----|----|----|----|
| 3  | 4  | 5  | 6  | 12 |
| 2  | 3  | 4  | 3  | 9  |
| 5  | 6  | 7  | 15 | 18 |

2. Extenda o caso de teste parametrizado da questão acima para incluir a verificação da condição de existência do triângulo. Caso os lados informados formem um triângulo, a classe deverá retornar o valor lógico `true` para o teste. Rotule esse teste como `Funcional`. 

| a  | b  | c  |Área|Per.|Triang.?|
|----|----|----|----|----|--------|
| 3  | 4  | 5  | 6  | 12 |  True  |
| 2  | 3  | 4  | 3  | 9  |  True  |
| 5  | 6  | 7  | 15 | 18 |  True  |

2.1 Para os casos em que os lados informados não formem um triângulo, uma exceção NaoEhTrianguloException deve ser disparada e capturada pelo teste. Rotule esse teste como `Excecao`. As medidas apresentadas abaixo são exemplos de lados que não formam um triângulo. Escreva um teste parametrizado capaz de capturar a exceção NaoEhTrianguloException.

| a  | b  | c  |
|----|----|----|
| 4  | 5  | 12 |
| 2  | 3  | 6  |
| 1  | 1  | 3  |

3. Crie as seguintes suites de testes:    
   3.1 Suite de testes `SteFuncionais` que execute apenas os testes funcionais.   
   3.2 Suite de testes `SteExcecao` que execute apenas os testes de excecao.    
   3.3 Suite de testes `AllTests` que agrupe as duas suites mencionadas acima.    

---
# Estudo Dirigido

Conteúdo abordado: 
  - Testes unitários, 
  - Casos de teste, 
  - Suítes de testes,
  - Categorias de testes, 
  - Testes de exceção, 
  - Testes parametrizados


## Exercício 1 - Jogo da Forca

Considere a seguinte execução de um jogo da forca cuja palavra oculta é `arara`.
Toda vez que o jogador tentar adivinhar uma palavra, o jogo informa quantos
caracteres foram encontrados e os apresenta em suas respectivas posições. 

Através de testes parametrizados, implemente os seguintes casos de testes:   
| Caractere | # caracteres presentes | Palavra revelada |  
|-----------|------------------------|------------------|
|    a      |         3              |   `a*a*a`        |
|    r      |         2              |   `*r*r*`        |
|    b      |         0              |   `*****`        |

Rotule seus testes parametrizados como sendo pertencentes à categoria
`Funcional`.

Dicas: Quem são as tuplas de seus testes? Em cada tupla, quem são os valores
informados e os valores esperados para os testes? Quantos testes possuem seu
caso de testes parametrizado? 

No caso do usuário informar um caractere vazio ou nulo, o teste deverá capturar
uma exceção do tipo `CaractereInvalidoException`. Rotule esse teste como
`Excecao`. 

Agrupe os testes em uma suíte de testes chamada `AllTests`.


## Exercício 2 - Conta-corrente

Considere uma conta-corrente, com um saldo inicial de R$ 200,00, não há cheque
especial (não tem como resultar em saldo negativo após qualquer operação de
retirada). Operações de retirada são sempre transações de valores negativos,
operações de entrada são sempre transações de valores positivos. Não pode,
portanto, haver operação de entrada com valor negativo. 

Implemente, como testes parametrizados e rotulados como `Processamento`, as
seguintes operações. 

| Operação | Valor | Operação processada? | Saldo Final |
|----------|-------|----------------------|-------------|
| Deposito | 200   |   true               |  400        | 
| Saque    | -100  |   true               |  100        | 
| Pix      | -100  |   true               |  100        | 
| Pix      | 300   |   true               |  500        | 
| Pix      | -300  |   false              |  200        | 

Nos casos em que há erro entre o tipo da operação e seu valor, uma exceção do
tipo `OperacaoInvalidaException` deve ser lançada. Exemplo: 

- Deposito, -300,00
- Saque, 200,00

Rotule esses testes com `Excecao`. 

Agrupe esses testes em uma suite de testes chamada `AllTests`.
