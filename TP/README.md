hheja o seguinte cenário de uma aplicação a ser desenvolvida utilizando a técnica
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

A segunda parte do trabalho consiste na aplicação de operações de Refatoração no
código entregue pelos grupos na primeira parte. Todos os grupos aplicarão as
mesmas operações de Refatoração em seus trabalhos. As operações serão aplicadas
nas classes / métodos indicados pelo professor para cada grupo. Ao final das
operações de Refatoração, os grupos deverão apresentar como comentários no
código uma descrição detalhada dos efeitos da operação de refatoração no código. 

##### Lista de refatorações por grupos e seus locais de aplicação: 

| Grupo | Operação de Refatoração             | Classe / Método         |
|:-----:|:------------------------------------|:------------------------|
|   1   | Extrair método                      |(Repositorio privado)    |
|       | Extrair classe                      |(Repositorio privado)    |
|       | Substituir método por objeto-método |(Repositorio privado)    |
|-------|-------------------------------------|-------------------------|
|   2   | Extrair método                      | NotaFiscal::gerarNotaFiscal()|
|       | Extrair classe                      | Venda                   |
|       | Substituir método por objeto-método | Venda::calcularFrete()  |
|-------|-------------------------------------|-------------------------|
|   3   | Extrair método                      | Não entregue            |
|       | Extrair classe                      | Não entregue            |
|       | Substituir método por objeto-método | Não entregue            |
|-------|-------------------------------------|-------------------------|
|   4   | Extrair método                      |(Repositorio privado)    |
|       | Extrair classe                      |(Repositorio privado)    |
|       | Substituir método por objeto-método |(Repositorio privado)    |
|-------|-------------------------------------|-------------------------|
|   5   | Extrair método                      |(Repositorio inexistente)|
|       | Extrair classe                      |(Repositorio inexistente)|
|       | Substituir método por objeto-método |(Repositorio inexistente)|
|-------|-------------------------------------|-------------------------|
|   6   | Extrair método                      |RelatorioVenda::calculaVendasUltimoMes()|
|       | Extrair classe                      |Cliente                  |
|       | Substituir método por objeto-método |Venda::calculaTotalNota()|
|-------|-------------------------------------|-------------------------|
|   7   | Extrair método                      | SaleController::createSale() |
|       | Extrair classe                      | Sale                    |
|       | Substituir método por objeto-método | ProductController::createProduct() |
|-------|-------------------------------------|-------------------------|
|   8   | Extrair método                      | VendaModel::VendaModel()|
|       | Extrair classe                      | ClienteModel            |
|       | Substituir método por objeto-método | VendaModel::calculaCashback() |
|-------|-------------------------------------|-------------------------|
|   9   | Extrair método                      | Venda::realizarVenda()  |
|       | Extrair classe                      | Produto                 |
|       | Substituir método por objeto-método | Método realizarVenda(), resultante da refatoração Extrair Método |
|-------|-------------------------------------|-------------------------|
|  10   | Extrair método                      | Cliente::verificarEligibilidadeEspecial() |
|       | Extrair classe                      | Produto                  |
|       | Substituir método por objeto-método | Venda::calcularTotal()  |
|-------|-------------------------------------|-------------------------|
|  11   | Extrair método                      |(Repositorio privado)    |
|       | Extrair classe                      |(Repositorio privado)    |
|       | Substituir método por objeto-método |(Repositorio privado)    |
|-------|-------------------------------------|-------------------------|
|  12   | Extrair método                      | Compra::clienteElegivelParaEspecial() |
|       | Extrair classe                      | Imposto                 |
|       | Substituir método por objeto-método | Compra::valorTotalCompra() |
|-------|-------------------------------------|-------------------------|
|  13   | Extrair método                      | Venda::calcularValores()|
|       | Extrair classe                      | Produto                 |
|       | Substituir método por objeto-método | Venda::calcularImpostos() |
|-------|-------------------------------------|-------------------------|
|  14   | Extrair método                      | Venda::calcularValorFinal() |
|       | Extrair classe                      | Venda                   |
|       | Substituir método por objeto-método | Método calcularValorFinal, resultante da refatoração Extrair Método |
|-------|-------------------------------------|-------------------------|
|  15   | Extrair método                      | NotaFiscal::emiteNotaFiscal() |
|       | Extrair classe                      | NotaFiscal              |
|       | Substituir método por objeto-método | NotaFiscal::calcularValores() |
|-------|-------------------------------------|-------------------------|
|  16   | Extrair método                      | Sale::getCashback()     |
|       | Extrair classe                      | Product                 |
|       | Substituir método por objeto-método | Sale::checkout()        |
|-------|-------------------------------------|-------------------------|
|  17   | Extrair método                      | Venda::calcularTotal()  |
|       | Extrair classe                      | Cliente                 |
|       | Substituir método por objeto-método | Método calcularTotal, resultante da refatoração Extrair Método  |
|-------|-------------------------------------|-------------------------|
|  18   | Extrair método                      | Sale::calculateFreight()|
|       | Extrair classe                      | Taxes                   |
|       | Substituir método por objeto-método | Sale::finish()          |
|-------|-------------------------------------|-------------------------|
|  19   | Extrair método                      | Venda::calcularValorTotal() |
|       | Extrair classe                      | Produto                 |
|       | Substituir método por objeto-método | Método calcularValorTotal, resultante da refatoração Extrair Método |
|-------|-------------------------------------|-------------------------|
|  20   | Extrair método                      |(Repositorio privado)    |
|       | Extrair classe                      |(Repositorio privado)    |
|       | Substituir método por objeto-método |(Repositorio privado)    |
|-------|-------------------------------------|-------------------------|
|  21   | Extrair método                      |(Repositorio inexistente)|
|       | Extrair classe                      |(Repositorio inexistente)|
|       | Substituir método por objeto-método |(Repositorio inexistente)|
|-------|-------------------------------------|-------------------------|
|  22   | Extrair método                      | Cliente::definirValorFrete() |
|       | Extrair classe                      | Cliente                 |
|       | Substituir método por objeto-método | Venda::calcularValorDescontos() |
|-------|-------------------------------------|-------------------------|
|  23   | Extrair método                      |                         |
|       | Extrair classe                      |                         |
|       | Substituir método por objeto-método |                         |
|-------|-------------------------------------|-------------------------|
|  24   | Extrair método                      |                         |
|       | Extrair classe                      |                         |
|       | Substituir método por objeto-método |                         |
|-------|-------------------------------------|-------------------------|
|  25   | Extrair método                      |                         |
|       | Extrair classe                      |                         |
|       | Substituir método por objeto-método |                         |
|-------|-------------------------------------|-------------------------|
|  26   | Extrair método                      |                         |
|       | Extrair classe                      |                         |
|       | Substituir método por objeto-método |                         |
|-------|-------------------------------------|-------------------------|
|  27   | Extrair método                      |                         |
|       | Extrair classe                      |                         |
|       | Substituir método por objeto-método |                         |
|-------|-------------------------------------|-------------------------|
|  28   | Extrair método                      |                         |
|       | Extrair classe                      |                         |
|       | Substituir método por objeto-método |                         |
|-------|-------------------------------------|-------------------------|
|  29   | Extrair método                      |(Repositorio privado)    |
|       | Extrair classe                      |(Repositorio privado)    |
|       | Substituir método por objeto-método |(Repositorio privado)    |



## Critérios 

### Trabalho 1: TDD
- Todos os itens do enunciado foram implementados? 
- O programa é correto?
- Todos os testes foram implementados utilizando parametrização de testes?
- Todos os testes rodam sem erros?  

### Trabalho 2: Refatoração
- Extrair método (25 pontos): 
- Extrair superclasse (25 pontos): 
- Substituir método por objeto-método (50 pontos):

## Datas de entrega

### Trabalho 1: TDD

Data limite: 3/7/2024. Trabalhos entregues posteriormente serão penalizados com
um desconto de 50% na nota.

### Trabalho 2: Refatoração
