<<<<<<< HEAD
### Trabalho Prático 1 - Test-Driven Development
=======
UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
TPPE - Técnicas de Programação para Plataformas Emergentes  

### Trabalho Prático 1 - _Test-Driven Development_

---

**Enunciado do trabalho** 

Seja o seguinte cenário descrito a seguir:

> De um modo bastante resumido, o Imposto de Renda de Pessoa Física (IRPF) de
> todo contribuinte é calculado mensalmente considerando os rendimentos
> tributáveis recebidos no mês corrente e as deduções legais. Da subtração
> desses valores (rendimentos - deduções) obtem-se a *base de cálculo*, sobre o
> qual será calculado o valor do imposto. Há 5 faixas de cálculo de imposto,
> cada qual com sua alíquota (definida em \%) a ser aplicada sobre o valor que a
> base de cálculo ocupou da faixa. O valor do imposto final é a soma dos valores
> de impostos a serem pagos para cada faixa e a alíquota efetiva total (em \%) é
> o resultado do valor do imposto dividido pela base de cálculo. Cada um desses
> passos está detalhado a seguir.
>
> Como rendimentos tributáveis entende-se todos aqueles valores recebidos pelo
> contribuinte tais como salários, aluguéis, participação em lucros e
> rendimentos de empresas, dividendos, lucros de aplicações financeiras, dentre
> outros. O valor total desses rendimentos deve ser utilizado para efeitos do
> cálculo do IRPF. 
>
> O contribuinte tem direito legal a vários deduções no mês corrente. Como
> deduções integrais entende-se aquelas cujos valores totais serão abatidos do
> valor total de dividendos. São exemplos de deduções integrais: 
> * Contribuição previdenciária oficial (podendo ser mais de uma contribuição,
>   por exemplo, no contracheque + contribuição via carnê INSS);
> * Pensão alimentícia;
> * Previdência privada ou Fundo de Previdência dos Servidores públicos
>   (Funpresp); 
> * Valores pagos via carnê-leão, dentre outros.  
>
> O contribuinte poderá ainda deduzir para cada dependente legal o valor de
> R$189,59 por mês.  
> Todas essas deduções deverão ser somadas para efeitos de cálculo do total de
> deduções a que o contribuinte tem direito.  
> 
> A base de cálculo do IRPF é dada pela subtração do total de rendimentos pelo
> total de deduções. 
> 
> Para o valor da base de cálculo, é calculado o valor de cada uma das 5 faixas
> de imposto. As faixas possuem as seguintes alíquotas:   
> | Faixa | Alíquota    |
> |:-----:|:-----------:|
> | 1a.   | 0% (isenta) |
> | 2a.   | 7,5%        |
> | 3a.   | 15%         |
> | 4a.   | 22,5%       |
> | 5a.   | 25%         |
> Portanto, baseado na tabela acima, os valores da base de cálculo que atingiram
> as faixas serão multiplicados pelas respectivas alíquotas para cálculo do
> valor do imposto de cada uma das faixas. O valor total do imposto a ser pago
> naquele mês é a soma dos valores dos impostos de todas as faixas. 
> 
> Por fim, a alíquota efetiva é calculada como sendo a taxa (%) do valor total
> do imposto pelo valor da base de cálculo. 
>
> Todo esses cálculos podem ser realizados através do [Simulador de IRPF da
> Receita Federal Brasileira (RFB)](https://www27.receita.fazenda.gov.br/simulador-irpf/). 


Com base na descrição do cálculo do IRPF acima, o trabalho a ser realizado pelo
grupo consiste na criação de um simulador similar ao simulador disponibilizado
pela RFB. Esse simulador deverá ser construído através do método de TDD
utilizando, **obrigatoriamente**, as técnicas de falsificação, duplicação e
triangulação de testes. 

**Grupos de alunos**

**Entrega do trabalho**

**Valor do trabalho**

**Forma de avaliação**
>>>>>>> organizacaoDisciplina

