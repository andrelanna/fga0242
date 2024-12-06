UnB - Universidade de Brasilia  
FCTE - Faculdade de Ciências e Tecnologias em Engenharias  
FGA0242 - Técnicas de Programação para Plataformas Emergentes  

--- 

# Trabalhos práticos - semestre 2024/2

## Descrição do cenário

O Imposto de Renda de Pessoas Físicas (IRPF) é um imposto federal calculado com base na renda e despesas dedutíveis dos cidadãos brasileiros. De modo bastante resumido, o imposto considera, mensalmente, todas as rendas tributáveis recebidas pelo cidadão e todas suas deduções legais. A base de cálculo do IRPF é a diferença da renda pelas deduções de modo que o imposto devido é calculado sobre esse valor. Por fim, a alíquota efetiva é dada pelo quociente entre o imposto pago e o total de rendimentos tributáveis. Cada um desses passos está apresentado abaixo, através de um exemplo ilustrativo.


### Rendimentos  

Os rendimentos são aqueles valores recebidos pelo cidadão ao longo de um mês. Os rendimentos são classificados como *tributáveis* quando há a incidência de imposto sobre eles, ou*não-tributáveis*, caso contrário. São exemplos de rendimentos tributáveis os salários, rendimentos de alguns tipos de investimentos, pro-labore, dentre outros. São exemplos de rendimentos não-tributáveis os ressarcimentos de despesas de trabalho, bolsas de estudos, dentre outros. Apenas os rendimentos tributáveis são considerados para efeito de cálculo do imposto de renda. 

Suponha que um cidadão possua os seguintes rendimentos: 

| Descrição do Rendimento | Tributável? | Valor        |
|:------------------------|:-----------:|-------------:|
| Salário                 |  Sim        | R$ 8.000,00  |
| Aluguel                 |  Sim        | R$ 2.000,00  |
| Bolsa de estudos        |  Não        | R$ 1.500,00  |
| **Total rendimentos:**  |             | R$ 11.500,00 |
| **Total rend. tribut.:**|             | R$ 10.000,00 |

### Deduções

As deduções são os valores que, legalmente, podem ser descontados para o cálculo do imposto. Para cada dependente do contribuinte (filho/filha) desconta-se o valor de R$189,59. Valores pagos à previdência oficial (Previdência Social do Governo Federal) são deduzidos em sua integralidade. Valores pagos à previdência complementar (planos de previdência privada do tipo PGBL), ao Carnê-leão e à pensões alimentícias também são deduzidos integralmente. 

Em nosso exemplo, supondo que o cidadão possua um dependente, pague R$500,00 de previdência oficial, R$1.000,00, de previdência complementar e R$1.500,00 de pensão alimentícia, tem-se a seguinte tabela de deduções. 

| Descrição da dedução  | Valor           |
|:----------------------|----------------:|
| 1 filho               | R$ 189,59       |
| Cont. Prev. oficial   | R$ 500,00       |
| Cont. Prev. privada   | R$ 1.000,00     |
| Pensão alimentícia    | R$ 1.500,00     |
| **Total de deduções** | **R$ 3.189,59** |

### Base de cálculo

A base de cálculo é o valor que será utilizado para cálculo do imposto de renda. Ele é dado pela diferença dos total de rendimentos tributáveis pelo total das deduções legais. No exemplo, a base de cálculo é calculada como demonstrado a seguir.

| Descrição                        | Valor            |
|:---------------------------------|-----------------:|
| Total de rendimentos tributáveis | R$ 10.000,00     |
| Total de deduções                | R$  3.189.59     |
| **Total**                        | **R$  6.810,41** |

### Cálculo do imposto  

A tributação do imposto de renda é realizada através de cinco faixas. Cada faixa possui uma alíquota de imposto aplicada ao valor da base de cálculo que se enquadrou naquela faixa. Os limites e as alíquotas são crescentes conforme tabela seguinte. O valor total do imposto é dado pela soma dos impostos de cada faixa.

| Faixa | Faixa de valores         | Alíquota |
|:------|:-------------------------|:--------:|
| 1a.   | Até 2.259,20             |  0.0 %   |
| 2a.   | De 2.259,21 até 2.826,65 |  7.5 %   |
| 3a.   | De 2.826,66 até 3.751,05 | 15.0 %   |
| 4a.   | De 3.751,06 até 4.664,68 | 22.5 %   |
| 5a.   | Acima de 4.664,68        | 27.5 %   |

No caso do exemplo desse trabalho, a base de cálculo do IRPF é de R$ 6.810,41. Portanto, ela contempla todas as faixas do IRPF, conforme demonstrado pela tabela a seguir: 

*Base de cálculo:* R$ 6.810,41

| Faixa | Alíquota  | Imposto devido |
|:------|:---------:|---------------:|
| 1a.   |  0.0 %    | R$   0,00      |
| 2a.   |  7.5 %    | R$  53,59      |
| 3a.   | 15.0 %    | R$ 138,66      |
| 4a.   | 22.5 %    | R$ 205,56      |
| 5a.   | 27.5 %    | R$ 590,07      |
|       | **Total** | R$ 987,88      |

A alíquota efetiva é dada pelo quociente entre o imposto pago e o total de rendimentos tributáveis. Embora o cidadão do exemplo se encontrar na quinta faixa (27,5%), a alíquota efetiva do imposto pago é de 9,87% ($\frac{R\$ 987,88}{R\$ 10.000,00}$).

--- 

# Enunciados dos trabalhos

## Entrega 1 - TDD

**Valor:** 20 pontos  
**Data de entrega:** 13/12/2024  


## Entrega 2 - Refatoração

**Valor:** 20 pontos  
**Data de entrega:** 23/12/2024  


## Entrega 3 - Depuração de código

**Valor:** 20 pontos  
**Data de entrega:** a ser definida

