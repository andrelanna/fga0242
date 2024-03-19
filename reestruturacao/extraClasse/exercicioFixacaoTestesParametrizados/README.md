UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação em Plataformas Emergentes  
---

Exercícios de fixação do conteúdo de testes parametrizados.

1. Considere a implementação de duas unidades, uma que calcula os termos 
   e outra que calcula a soma dos termos de uma Progressão Aritmética. 
   Escreve um caso de teste parametrizado capaz de testar as duas unidades
   com base nos seguintes parâmetros:
   
   |  a0  |  r  |  n  |  n-esimo termo  |  soma  |
   |:----:|:---:|:---:|:---------------:|:------:|
   |   2  |  3  |  5  |        14       |    10  |
   |   3  |  4  |  5  |        19       |    55  |
   |   5  | -3  |  6  |       -10       |   -15  |
   
   
2. Escreva um teste parametrizado que testa uma unidade que informa se 
   3 medidas de lado formam um triângulo. Propriedade: 3 medidas são lados
   de um triangulo se, para cada medida, ela é maior do que o módulo da 
   diferença e menor do que a soma dos outros dois lados.  
   |l2 - l3| < l1 < |l2 + l3|   
   Parâmetros:
   
   |  l1  |  l2  |  l3  |  Resultado  |
   |:----:|:----:|:----:|:------------|
   |   3  |   4  |   5  |    true     |
   |   1  |   5  |   7  |   false     |
   |   5  |   7  |   8  |    true     |
   |   6  |   3  |   1  |   false     |
   
   
3. Seja um simulador de texto que oferece alguns comandos de teclado para
   realizar operações no texto. Esses comandos recebem o texto a ser processado, 
   o comando a ser executado e um argumento para o comando. Escreva um teste 
   parametrizado capaz de testar as seguintes operações:  
   |  Texto a ser processado  |  Comando  |  Argumento  |  Resposta                |
   |:-------------------------|:---------:|:-----------:|:-------------------------|
   |  Andre Lanna             |    5L     |      0      | ["Andre"]                |
   |  Andre Lanna             |   split   |     " "     | ["Andre", "Lanna"]       |
   |  Andre                   |   y3v     |    null     | ["AndreAndreAndreAndre"] |
   |  Andre Lanna             |   split   |     "n"     | ["A", "dre La", "a" ]    |
