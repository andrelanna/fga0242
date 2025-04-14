
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

1. Crie um caso de teste parametrizado que, para dados $a$, $b$ e $c$, sejam calculadas as áreas e perímetros dos triângulos apresentados abaixo. Rotule os testes como "Funcional". Considere $a$ como sendo a altura e $b$ como sendo a base do triângulo. 

| a  | b  | c  |Área|Per.|
|----|----|----|----|----|
| 3  | 4  | 5  | 6  | 12 |
| 2  | 3  | 4  | 3  | 9  |
| 5  | 6  | 7  | 15 | 18 |

2. Extenda o caso de teste parametrizado da questão acima para incluir a verificação da condição de existência do triângulo. Caso os lados informados formem um triângulo, a classe deverá retornar o valor lógico "true" para o teste. Rotule esse teste como "Funcional". 

    2.1 Para os casos em que os lados informados não formem um triângulo, uma exceção NaoEhTrianguloException deve ser disparada e capturada pelo teste. Rotule esse teste como "Excecao". As medidas apresentadas abaixo são exemplos de lados que não formam um triângulo. Escreva um teste parametrizado capaz de capturar a exceção NaoEhTrianguloException.

| a  | b  | c  |Área|Per.|Triang.?|
|----|----|----|----|----|--------|
| 3  | 4  | 5  | 6  | 12 |  True  |
| 2  | 3  | 4  | 3  | 9  |  True  |
| 5  | 6  | 7  | 15 | 18 |  True  |

3. Crie as seguintes suites de testes: 
   3.1 Suite de testes `SteFuncionais` que execute apenas os testes funcionais.
   3.2 Suite de testes `SteExcecao` que execute apenas os testes de excecao. 
   3.3 Suite de testes `AllTests` que agrupe as duas suites mencionadas acima. 
