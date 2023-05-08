UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
TPPE - Técnicas de Programação para Plataformas Emergentes  

### Trabalho Prático 1 - _Test-Driven Development_

---

**Enunciado do trabalho** 

Seja o cenário descrito a seguir: 

> Cálculo da completude de informações estruturadas, aninhadas ou não: 
> 
> Um sistema de informações deve, dentre várias outras atribuições, calcular o
> quão completa é uma informação que ele processa baseado em um modelo
> descritivo das informações sob análise. As informações são sempre tratadas
> como valores textuais, independentemente se o valor é de fato um texto ou não.
> Avaliar a completude, nesse caso, significa verificar a presença ou ausência
> de algum valor para o campo correspondente. 
> 
> Um registro, i.e. um conjunto de informações científicas agregadas, é composto
> de vários campos, podendo cada um desses campos serem atômicos ou compostos em
> vários níveis. Exemplos: 
> * Atômico: CPF
> * Atômico: Matricula
> * Atômico: Sexo 
> * Atômico: Email
> * Composto: Nome
>   * Atômico: PrimeiroNome
>   * Atômico: NomeMeio
>   * Atômico: UltimoNome
> 
> Os campos podem ser agrupados para criar novos campos formando uma árvore de
> campos para os registros. Essa árvore deve respeitar o modelo de dados sob
> análise. Exemplo:
> * Composto: PessoaFisica
>   * Composto: Nome
>     * Atômico: PrimeiroNome
>     * Atômico: NomeMeio
>     * Atômico: UltimoNome
>   * Atômico: CPF
>   * Atômico: Matricula
>   * Atômico: Sexo 
>   * Atômico: Email
> 
> Os campos aninhados podem ser agrupados seguindo duas regras lógicas bem
> conhecidas. A regra OU EXCLUSIVO estabelece que o campo raiz é considerado
> completo quando apenas um dos campos filhos está presente, qualquer um dos
> campos filhos agregados. A regra OU INCLUSIVO estabelece que o campo raiz é
> considerado preenchido quando pelo menos um campo filho está presente. O caso
> especial em que nenhum campo filho está presente é considerado como
> não-preenchido. Para o campo raiz ser considerado completo, todos os campos
> filhos devem estar presente. 
> 
> Para o caso de campo atômico, ele é considerado completo se há um valor
> atribuído a ele. 
> 
> O cálculo da completude de um registro é feito de maneira recursiva, de modo
> que o valor da completudo do campo pai de um registro é dado pelo valor da
> completude de seus filhos, considerando as regras apresentadas anteriormente. 




O trabalho deverá apresentar o emprego das três técnicas de TDD (falsificação,
duplicação e triangulação) em, pelo menos, nas três seguintes situações: 

* Calculo da completude de campos OR EXCLUSIVO; 
* Cálculo da completude de registros multi-campos.

Nesses dois casos deverá, para efeito de evidência, ter a seguinte sequencia de
_commits_:
* falsificação; 
* duplicação; 
* triangulação.


:exclamation::exclamation::exclamation:**ATENÇÃO:** todos os testes finais
deverão estar triangulados por parametrização, com exceção dos testes de
exceções.

---

**Grupos de alunos**

Os trabalhos deverão ser executados por grupos de até 6 alunos. O grupo deverá
criar um repositório público no GitHub, cujo arquivo README.md deverá conter os
nomes e matrículas dos componentes, e as instruções para execução do projeto.

**Entrega do trabalho**

Os trabalhos deverão ser entregues através de repositório no GitHub, até as
23:59:59hs do dia 22 de maio de 2023, impreterivelmente. 

Os grupos deverão informar ao professor o endereço do repositório do projeto
antes da data final de entrega. 

**Valor do trabalho**

30 pontos. 

**Forma de avaliação**

Os trabalhos serão avaliados através:

- da corretude dos cálculos realizados pelo simulador;
- da utilização de testes parametrizados em todos os testes funcionais; 
- da utilização de testes de exceção e, por fim, 
- das seqüências de _commits_ para os casos em que o emprego das técnicas de
  falsificação, duplicação e triangulação é obrigatório.
