
UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

---

## Aula 4 - Testes parametrizados

**Tópicos da aula**
- Testes parametrizados
- Objetos de teste
- Construtor de testes
- Método getParameters()
- Método de teste

**Slides da aula**
* [Slides](https://docs.google.com/presentation/d/1H9Dy6ZHJVIBqr5gnEaEHmZ_Lvm8RYqD-5D6icMNvIx0/edit?usp=sharing)

**Video da aula**  

* [Video](https://youtu.be/CFGCDrVld5I)

**Exercicios de fixacao**

Você foi chamado para desenvolver uma calculadora de rentabilidade líquida anual
para investimentos em CDB. Uma aplicação em CDB é caracterizada pelo seu prazo
em dias (n), o valor da aplicação inicial ( p ), a taxa de juros anual (i)
acordada no momento da aplicação e a tributação de imposto de renda (d). 

A tributação do imposto de renda segue a seguinte tabela: 


: Prazo da aplicação :|: Alíquota de imposto :
----------------------|-----------------------
22,5%                 |  Até 180 dias
20%                   |  De 181 a 360 dias
17,5%                 |  De 361 a 720 dias
15%                   |  Acima de 720 dias

O rendimento bruto (rb) é dado por aplicar a taxa de juros sobre o valor inicial
durante o tempo em que a aplicação esteve sob custódia de uma instituição
financeira (ou seja, considere cálculo de juros simples). Para efeitos práticos,
o tempo pode ser dado como um valor relativo ao período de 365 dias. Exemplo:
183 dias = 0.5 ano, 91 dias = 0.25 ano, 730 dias = 2.0 ano, 639 dias = 1.75 ano.  

A porcentagem do rendimento líquido é encontrada após se dividir o resultado
final pelo capital inicial, multiplicar o valor encontrado por 100 e, na
sequência, subtrair 100. Exemplos de cálculos de rentabilidade líquida estão
descritos na tabela abaixo.

Dias (n)  |  Apl. inicial (p)  |  Tx. juros (i)  |  Aliquota     |  IR       |  Rend liq (%)
---------:|-------------------:|----------------:|--------------:|----------:|-------------:
  60      | R$  1.000,00       |           8,5 % |        22,5 % | R$   3,14 |  1,0829       
 120      | R$    500,00       |           8,0 % |        22,5 % | R$   2,96 |  2,0384       
 240      | R$  3.000,00       |           9,0 % |        20,0 % | R$  35,51 |  4,7342       
 270      | R$  2.000,00       |           8,5 % |        20,0 % | R$  25,15 |  5,0301       
 390      | R$    100,00       |           7,5 % |        17,5 % | R$   1,40 |  6,6113       
 420      | R$    250,00       |           8,0 % |        17,5 % | R$   4,03 |  7,5945       
 550      | R$    400,00       |           8,0 % |        17,5 % | R$   8,44 |  9,9452       
 670      | R$    800,00       |           8,0 % |        17,5 % | R$  20,56 | 12,1151      
 700      | R$  2.500,00       |           9,0 % |        17,5 % | R$  75,51 | 14,2397      
 900      | R$  4.200,00       |           9,5 % |        15,0 % | R$ 147,58 | 19,9110      
1000      | R$    100,00       |           7,5 % |        15,0 % | R$   3,08 | 17,4658      

**Enunciado**: crie um teste parametrizado para cada resposta a ser calculada e,
posteriormente, unifique todos os testes parametrizados em uma suíte de testes
chamada ```SteTestesInvestimentos```. Os testes parametrizados deverão chamar
```TstIR``` e ```TstRendLiq```. 

:star: Sugestão: crie uma hierarquia de casos de teste para evitar código
duplicado. :wink:
