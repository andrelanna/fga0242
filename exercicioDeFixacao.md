UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
TPPE - Técnicas de Programação em Plataformas Emergentes  


# Exercícios de fixação - Revisão de Testes Unitários

_Obs.: Esse exercício será utilizado para efeitos de cálculo de freqüência
relativo às aulas dos dias 4, 9 e 11 de agosto de 2021. A entrega dos exercícios
é individual e deverá ser realizada através de pull-request nesse
repositório._

## Enunciado do exercício:

O intuito desse exercício é reforçar o conteúdo sobre testes unitários, em
especial, os testes parametrizados e testes de exceções. Nesse exercício, vamos
elaborar uma calculadora de operações inteiras que não permitem alterações
automáticas de tipos (casting) e operações inválidas. 

A calculadora a ser implementada deve operar apenas com valores do tipo _short_
cujo intervalo de representação em Java é [-32768, 32767], não sendo permitida a
transformação automática em um tipo de dado de maior representação (_int_, por
exemplo). 

* Adição: 

Para a operação de adição serão testados valores intermediários e nos limites
inferior e superior do intervalo de representação do tipo _short_. Quando os
limites inferior e superior forem extrapolados as respectivas exceções deverão
ser lançadas e capturadas pelo teste unitário.

Valores a serem utilizados pelos testes parametrizados: 
| Operando 1 | Operando 2 | Resultado esperado                  |
|------------|------------|-------------------------------------|
|    3       |      2     |          5                          |
|   -3       |     -2     |         -5                          |
|   3        |      0     |          3                          |
|   -3       |      0     |         -3                          |
|    0       |      0     |          0                          |
|   -32768   |      0     |         -32768                      | 
|   -32768   |      1     |         -32767                      | 
|   -32768   |     -1     |  LimiteInferiorExtrapoladoException |
|   -32768   |     -2     |  LimiteInferiorExtrapoladoException |
|    32767   |     -1     |         32766                       |
|    32767   |      0     |         32767                       |
|    32767   |      1     |  LimiteSuperiorExtrapoladoException |
|    32767   |      2     |  LimiteSuperiorExtrapoladoException |


* Subtração:

Para a operação de subtração de dois inteiros utilize os seguintes valores para
os testes parametrizados.

| Operando 1 | Operando 2 | Resultado esperado                  |
|------------|------------|-------------------------------------|
|    3       |      2     |          1                          |
|    2       |      3     |         -1                          |
|   -3       |     -2     |         -1                          |
|   -2       |     -3     |          1                          |
|    3       |      0     |          3                          |
|    0       |      3     |         -3                          |
|   -3       |      0     |         -3                          |
|    0       |      3     |         -3                          |
|    0       |      0     |          0                          |
|   -32768   |      0     |         -32768                      | 
|   -32768   |      1     |  LimiteInferiorExtrapoladoException | 
|    1       |   -32768   |  LimiteSuperiorExtrapoladoException | 
|   -32768   |     -1     |         -32767                      |
|   -1       |   -32768   |          32767                      |
|   -32768   |     -2     |         -32766                      |
|   -2       |   -32768   |          32766                      |
|    32767   |     -1     |          32766                      |
|    -1      |    32767   |          32768                      |
|    32767   |      0     |          32767                      |
|    0       |    32767   |         -32767                      |
|    32767   |      1     |          32766                      |
|    1       |    32767   |         -32768                      |
|    32767   |      2     |          32765                      |
|    2       |    32767   |         -32765                      |
