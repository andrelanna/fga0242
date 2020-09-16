Aula 3 - Introdução a JUnit
---

Exercícios de fixação sobre  _Junit Runners_  a citar:
* Suite
* Parameterized
* Categories

**Enunciado do exercício:** a aplicação contida nessa pasta é um simulador de financiamento utilizando apenas a modalidade PRICE (também conhecida como _Sistema Francês de Amortização_). 

O intuito dessa aplicação é simular financiamentos com bancos diferentes (varia-se a taxa de juros entre os financiamentos). Para isso a classe `Modalidade`, presente em `Modalidade.java`, é responsável por criar uma simulação para cada banco com sua respectiva taxa de juros (denotada por _i_). 

Para a simulação de cada banco é necessário informar os seguintes valores do financiamento: 
* Valor Presente ( _PV_ ): o valor a ser financiado pelo cliente; 
* número de parcelas ( _n_ ) e,
* margem: o valor máximo que a prestação do financiamento pode assumir. Esse valor é hipoteticamente calculado nesse exemplo como o quociente entre _pv_ e _n_ . 

Os valores de um financiamento devem ser informados à classe `Financiamento` presente no arquivo `Financiamento.java` e posteriormente vinculados à simulação de um banco. 

Os seguintes valores são considerados inválidos para um financiamento e as seguintes exceções devem ser lançadas: 
* n < 5 --> `NumeroDeParcelasInvalidasException` ; 
* i = 0 --> `TaxaDeJurosInvalidaException`; 
* o valor da prestação / parcela ( _pmt_ ) ser maior do que a margem `PrestacaoMaiorQueMargemException`.

Isso exposto, faça o que se pede: 

a) Crie um pacote chamado `tst` para salvar seus arquivos de testes;  
b) Crie um _TestCase_ chamado `CriacaoSimulacaoTeste` que vai criar simulações de financiamento para três bancos: `Banco 1`, `Banco 2` e `Banco 3`. Certifique-se que os objetos foram instanciados adequadamente. Categorize esse teste como `TstFuncional`.  
c) Crie um _TestCase_ chamado `TstInformacoesFinanciamento` com dois testes para a classe `Financiamento`. Para o primeiro teste informe os seguintes valores _pv_ = 10.000, _n_ = 12, _margem_ = 2000 e categorize-o como `TstFuncional`. Certifique-se que o objeto `Financiamento` foi instanciado adequadamente.  Para o segundo teste informe os seguintes valores _pv_ = 10.000, _n_ = 12, _margem_ = 600 e categorize-o como `TstExcecao`.  
d) Crie um _TestCase_ chamado `TstCalculoPrice` que cria simulações de financiamento para os seguintes valores:  
  * Banco = `Banco 1`, pv = 10000, n = 10, i = 2.0, parcelaEsperada = 1113.26, totalJurosEsperado = 1132.65;
  * Banco = `Banco 2`, pv = 10000, n = 12, i = 1.8, parcelaEsperada = 934.01, totalJurosEsperado = 1208.23;
  * Banco = `Banco 3`, pv = 10000, n = 15, i = 1.7, parcelaEsperada = 760.89, totalJurosEsperado = 1413.43;
  * Banco = `Banco 2`, pv = 10000, n = 20, i = 1.5, parcelaEsperada = 582.45, totalJurosEsperado = 1649.14;   
   
   Esse caso de teste deverá ser categorizado como `TstFuncional` e parametrizado (ou seja, utilizando o _runner_  `Parameterized` de JUnit) com base nos valores informados acima.
   
e) Escreva uma suite de testes chamada `TestesFuncionais` composta por todos os casos de testes criados até então, mas somente execute os testes da categoria `TstFuncional`.
f) Similar ao item acima crie uma suite de testes chamada `TestesExcecao` composta por todos os casos de testes criados até então, mas somente execute os testes da categoria `TstExcecao`.
g) Crie uma suite de testes chamada `AllTestes` composta pelas duas suítes de testes criadas anteriormente (`TestesFuncionais` e `TestesExcecao`). 



**Forma de entrega:** através de _pull-request_ nesse repositório.   
**Horário limite de entrega:**  18 de setembro de 2020, 18:00 horas impreterivelmente. Pull-requests além desse horário serão descartados e o exercício será considerado como não entregue. Portanto, atenção ao horário do servidor do GitHub!    
   