Seja o seguinte cenário de uma aplicação a ser desenvolvida utilizando a técnica
de Desenvolvimento Guiado por Testes. 

> [Cenário]
> Uma empresa de comércio varejista de bens de consumo classifica os seus
> clientes como padrão, especiais (para aqueles que têm compras mensais acima de
> R$100,00 e prime (para aqueles que pagam uma mensalidade no valor de R$20,00).
> 
> Os clientes especiais têm como benefício o desconto de 10% sobre o valor total
> da compra. Eles podem ainda receber mais 10% de desconto sobre o valor total
> do pedido, caso este seja pago utilizando o cartão de crédito da empresa.
> Cartões de crédito da empresa são identificados por começarem sempre com os
> algarismos 4296 13XX XXXX XXXX (X são valores não considerados na
> identificação do cartão da empresa). Clientes especiais ainda possuem um
> desconto de 30% no valor do frete. 
> 
> Os clientes Prime possuem isenção no valor do frete e recebem como _cashback_
> o valor de R$0,03 a cada real gasto na loja. Caso a compra tenha sido paga
> através do cartão de crédito da loja, o valor de cashback para cada real gasto
> é de R$0,05. Os valores acumulados como _cashback_ podem ser utilizados como
> descontos em compras. 
> 
> Para cada compra realizada é necessário calcular o ICMS e o imposto municipal.
> A empresa é sediada no DF e, por isso, aplica-se as seguintes taxas para os
> impostos: 
> - 12% de ICMS e 4% de imposto municipal em vendas para clientes fora do DF;
> - 18% de ICMS e 0% de imposto municipal em vendas para cliende do DF. 
> 
> Os fretes são calculados com base na tabela a seguir: 
> |                   | Capital  | Interior | 
> |-------------------|----------|----------|
> |Distrito Federal   | R$  5,00 |          |
> |Regiao Centro-oeste| R$ 10,00 | R$ 13,00 |
> |Regiao Nordeste    | R$ 15,00 | R$ 18,00 |
> |Regiao Norte       | R$ 20,00 | R$ 25,00 |
> |Regiao Sudeste     | R$  7,00 | R$ 10,00 |
> |Regiao Sul         | R$ 10,00 | R$ 13,00 |
> 
> Na impressão da nota fiscal é necessário que seja informado os valores dos
> impostos ICMS e municipal para cada item, de modo que o valor total dos
> impostos seja a soma do valor dos impostos de cada item. Os descontos,
> conforme o tipo de cada cliente, deverão também constar na nota fiscal. 

## Enunciado

Instruções gerais: 
- Os trabalhos deverão ser realizados em grupos de no máximo 4 alunos. 
- Os grupos deverão informar seus componentes e o endereço do repositório do
  trabalho no seguinte formulário
  [https://docs.google.com/forms/d/e/1FAIpQLSfzotcXeM93nI_YcSWeB2YntYn7Q1vMJaN3dtUlMwnhZJ245A/viewform](https://docs.google.com/forms/d/e/1FAIpQLSfzotcXeM93nI_YcSWeB2YntYn7Q1vMJaN3dtUlMwnhZJ245A/viewform)
- :warning: ATENÇÂO: os trabalhos deverão **obrigatoriamente** ser desenvolvidos
  em Java e JUnit 4. Outras linguagens e frameworks de testes não serão aceitas
e terão zero atribuído às suas notas. 

### Trabalho 1: TDD
Utilizando as técnicas de TDD, crie um programa que seja capaz de realizar as
seguintes ações: 
- Cadastrar clientes dos três diferentes tipos (padrão, especial e prime), com
  seus endereços de entrega em diferentes regiões do pais. Por simplicidade,
considere apenas o estado e informe se o endereço é na capital ou no interior. 
- Cadastrar diferentes tipos de produtos. Para cada produto deverá ser
  informado:
  - Codigo do item
  - Descricao
  - Valor de venda
  - Unidade (peça, unidade, metro, cm3, etc...)
- Realizar a venda de itens para os clientes. A venda consiste em uma data,
  cliente, itens vendidos e método de pagamento. Além disso serão calculados,
para cada venda em específico, o valor do frente e os descontos (caso haja),
além dos impostos ICMS e municipal. Se for uma venda para um cliente prime, este
poderá utilizar seu saldo de cashback para abater na compra. 
- Calcular o valor das vendas do ultimo mês para cada cliente e verificar se ele
  é elegível para ser considerado como um cliente especial. 
- Calcular o saldo de cashback para clientes-prime. 

Cada um desses itens deve ser desenvolvido através de TDD de modo que deve haver
pelo menos um caso de teste para cada. No caso de haver mais de um caso de teste
para cada item, os casos de testes que o implementam deverão estar agrupados em
uma suíte de testes. 

:warning: **ATENÇÃO:** todos os testes deverão ser triangulados utilizando a
**parametrização** de testes oferecida pelo JUnit4. 


### Trabalho 2: Refatoração

A ser definido. 

## Critérios 

### Trabalho 1: TDD
- Todos os itens do enunciado foram implementados? 
- O programa é correto?
- Todos os testes foram implementados utilizando parametrização de testes?
- Todos os testes rodam sem erros?  

### Trabalho 2: Refatoração

## Datas de entrega

### Trabalho 1: TDD

Data limite: 3/7/2024. Trabalhos entregues posteriormente serão penalizados com
um desconto de 50% na nota.

### Trabalho 2: Refatoração
