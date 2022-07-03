UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
TPPE - Técnicas de Programação para Plataformas Emergentes  

### Trabalho Prático 1 - _Test-Driven Development_

---

**Enunciado do trabalho** 

Seja o seguinte cenário descrito a seguir:

> Você foi contratado por uma empresa que explora o gerenciamento de
> estacionamentos particulares (prédios comerciais, shoppings, etc) e de
> instalações públicas (aeroportos, estádios, ginásios, etc). De um modo geral,
> o gerenciamento de um estacionamento se dá pela liberação das catracas
> eletrônicas sempre que houver pelo menos uma vaga disponível em todo o
> estacionamento. Os estacionamentos explorados por essa empresa possuem,
> obviamente, uma ocupação máxima que ao ser atingida impede que novos acessos
> sejam realizados pelas catracas eletrônicas de entrada. 
>
> Essa empresa realiza o gerenciamento de diversas formas de acesso aos
> estacionamentos. Essas formas de acesso estão descritas a seguir: 
> * Acesso por frações de quinze minutos: a cada quinze minutos contados a
>   partir do momento da passagem do veículo pela catraca eletrônica,
>   contabiliza-se o valor da fração; 
> * Acesso por horas cheias: a cada hora cheia (4 frações de 15 minutos
>   completas) o valor da hora pode ter um desconto estipulado em um valor
>   percentual; 
> * Acesso por diárias diurnas: sempre que o acesso do veículo durar mais de 9
>   horas, cobra-se um único valor relativo à diária do estacionamento. O valor
>   da diária é estabelecido como um valor fixo em Reais (R$). 
> * Acesso por diária noturna: a diária noturna caracteriza-se pelo acesso de um
>   veículo após um determinado horário e sua retirada anterior ao a um
>   determinado horário do dia seguinte. O valor da diária noturna é determinado
>   como um valor percentual aplicado sobre o valor da diária diurna.
> * Acesso mensalista: o valor do acesso mensalista é um valor fixo em Reais
>   (R$) e permite o acesso irrestrito do veículo nos horários em que o
>   estacionamento está em funcionamento. 
> * Acesso por evento: o acesso por evento é determinado por um valor fixo a ser
>   aplicado para os acessos realizados dentro de um determinado período do dia. 
ra
> 
> Os valores dos tipos de acessos apresentados acima vão variar de acordo com
> cada estacionamento que contrata a empresa gerenciadora de estacionamentos.
> Estacionamentos localizados em locais de maior movimentação (aeroportos,
> shoppings) geralmente possuem valores de acesso mais elevados do que em locais
> de menor movimentação (prédios comerciais). Cada local que contrata a empresa
> gerenciadora de estacioamento recebe uma parte do valor de cada acesso,
> definida em acordo com a empresa de gerenciamento do estacionamento. 
>
> Essa empresa trabalha em parceria com seguradoras de veículo para oferecer
> descontos sobre o valor total do estacionamento, em todos os estacionamentos
> que ela opera (o desconto não depende de cada estacionamento gerenciado). 
>
> Com base na descrição do cenário de gerenciamento de estacionamentos
> apresentado acima, pode-se pensar nos seguintes estacionamentos gerenciados pela
> empresa que te contratou. 
> 
> | Estacionamento | Valor fração | Valor hora cheia | Valor diária diurna | Valor diária noturna                               |
> |----------------|--------------|------------------|---------------------|----------------------------------------------------|
> | Estac. 1       | R$ 30,00     | 15 %             |  R$ 120,00          | 45 % (entrada após 19:00hs, retirada antes 8:00hs) |
> | Estac. 2       | R$ 20,00     | 10 %             |  R$  70,00          | 30 % (entrada após 21:00hs, retirada antes 7:00hs) |
> | Estac. 3       | R$ 10,00     |  0 %             |  R$  50,00          | 40 % (entrada após 20:00hs, retirada antes 8:00hs) |
> 
> | Estacionamento | Valor acesso mensalista | Valor acesso evento | Horario Funcionamento | Capacidade |
> |----------------|-------------------------|---------------------|-----------------------|------------| 
> | Estac. 1       |  R$ 600,00              |  R$ 50,00           |  6:00 às 22:00hs      | 300 carros | 
> | Estac. 2       |  R$ 455,00              |  R$ 60,00           |  24 horas             | 120 carros | 
> | Estac. 3       |  R$ 350,00              |  R$ 40,00           |  6:00 às 22:00hs      | 600 carros | 
> 
> | Estacionamento | % retorno contratante |
> |----------------|-----------------------|
> | Estac. 1       | 50 %                  |
> | Estac. 2       | 60 %                  |
> | Estac. 3       | 70 %                  |

Com base nos valores hipotéticos apresentados nas tabelas acima, pode-se simular
os seguintes valores para o gerenciamento dos estacionamentos: 

* Estacionamento 1:  
  Acessos: 
  | Placa | Hora entrada; hora saida | Tipo do acesso | Valor do acesso | Valor do contrante | 
  |-------|--------------------------|----------------|-----------------|--------------------|
  | HI139 | 8:30 ; 8:56              |                | R$ 60,00        | R$ 30,00           |
  | G49NG |                          | Mensalista     | R$ 600,00 (mes) | R$ 300,00          |
  | AC50M | 8:00 ; 18:00             |                | R$ 120,00       | R$ 60,00           |
  | RM3A9 |                          | Noturno        | R$ 54,00        | R$ 27,00           |
  | AM31J |                          | Evento         | R$ 50,00        | R$ 25,00           |

  Total apurado pelo contratante: R$ 442,00

* Estacionamento 2:  
  Acessos:  
  | Placa | Hora entrada; hora saida | Tipo do acesso | Valor do acesso | Valor do contrante | 
  |-------|--------------------------|----------------|-----------------|--------------------|
  | HI139 | 8:30 ; 9:30              |                | R$ 72,00        | R$ 43,20           |
  | G49NG | 15:12; 16:00             |                | R$ 72,00        | R$ 43,20           |
  | AC50M | 8:00 ; 18:00             |                | R$ 70,00        | R$ 42,00           |
  | RM3A9 | 21:36; 6:12              | Noturno        | R$ 21,00        | R$ 12,60           |
  | AM31J |                          | Evento         | R$ 60,00        | R$ 36,00           |

  Total apurado pelo contratante: R$ 177,00

Com base nas descrições dos cálculos acima **e em outras simulações de cálculo a
serem realizadas pelo grupo**, o trabalho a ser realizado consiste na criação de
uma ferramenta que seja capaz de realizar tais cálculos para essa empresa de
gerenciamento de estacionamentos. Essa ferramenta deverá ser construído através
do método de TDD utilizando, **obrigatoriamente**, as técnicas de falsificação,
duplicação e triangulação de testes. 

O projeto resultante do desenvolvimento através de TDD deverá ser capaz de, para
cada estacionamento gerenciado: 

* Cadastrar os acessos (placa, hora de entrada, hora de saída) 
* Com base nos dados do estacionamento (horário de funcionamento, horários de
    período noturno) e nos dados de acesso (hora de entrada e saída), o programa
    deverá **inferir** qual o tipo de cálculo a ser aplicado. **ATENÇÃO:** o
    único tipo de acesso que pode ser informado previamente pelo usuário é o
    acesso por eventos, os demais tipos de acessos e seus cálculos e seus
    cálculos deverão ser identificados pela própria aplicação. 
* Não permitir descrições em branco para os dados de acesso (placa, hora de
    entrada e saída) e para os dados do estacionamento que está sendo gerenciado
    (horário de funcionamento, valores de acessos - todos os tipos, valores de
    participação da contratane, capacidade do estacionamento). Nesse caso lançar
    uma exceção do tipo ``DescricaoEmBrancoException`` informando qual campo
    está em branco.
* Não permitir informar valores de acesso inválidos (negativos por exemplo).
Nesses casos lançar exceção do tipo ``ValorAcessoInvalidoException``.
* Calcular os valores a serem repassados pela gerenciadora de estacionamentos ao
    contratante, ao final da apuração dos valores de todos os acessos
    realizados. 
* Todas as exceções apresentadas acima deverão ser testadas por meio de testes
    unitários. 
* Utilizem os rótulos ``Teste Funcional`` e ``TesteExcecao`` para testes de
    funcionalidades e testes de lançamentos de exceções criados para cada teste
    unitário criado. Ao final crie uma suíte de testes capaz de executar todas
    as categorias de testes. 


O trabalho deverá apresentar o emprego das três técnicas de TDD (falsificação,
duplicação e triangulação) em, pelo menos, nas três seguintes situações: 

* Calculo do valor de acesso para acesso de hora cheia; 
* Cálculo do valor de acesso para acesso noturno; 
* Calculo do valor apurado pela contratante com, no mínimo, um acesso por
    evento, um acesso de diária diurna e um acesso de 3 frações de 15 minutos. 

Nesses três casos deverá, para efeito de evidência, ter a seguinte sequencia de
_commits_:
* falsificação; 
* duplicação; 
* triangulação.


:exclamation::exclamation::exclamation:**ATENÇÃO:** todos os testes finais
deverão estar triangulados por parametrização, com exceção dos testes de
exceções.

---

**Grupos de alunos**

Os trabalhos deverão ser executados por grupos de até 5 alunos. O grupo deverá
criar um repositório público no GitHub, cujo arquivo README.md deverá conter os
nomes e matrículas dos componentes, bem como as instruções de execução dos
testes unitários (a depender do framework de testes unitários adotado pelo
grupo). Os grupos de trabalho e o endereço do repositório deverão ser enviados
por email para o professor.

**Entrega do trabalho**

Os trabalhos deverão ser entregues através de repositório no GitHub, até as
23:59:59hs do dia 18 de julho de 2022, impreterivelmente. 

Os grupos deverão informar ao professor o endereço do repositório do projeto
antes da data final de entrega. 

**Valor do trabalho**

30 pontos. 

**Forma de avaliação**

Os trabalhos serão avaliados através:

- da corretude dos cálculos realizados pela aplicação ;
- da utilização de testes parametrizados em todos os testes funcionais; 
- da utilização de testes de exceção e, por fim, 
- das seqüências de _commits_ para os casos em que o emprego das técnicas de
falsificação, duplicação e triangulação é obrigatório.

