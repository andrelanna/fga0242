UnB - Universidade de Brasilia  
FCTE - Faculdade de Ciencias e Tecnologias em Engenharias  
TPPE - Técnicas de Programação para Plataformas Emergentes  
---

Trabalho Prático - Valor 40 pontos. 

Enunciado Geral 

* Os trabalho prático será realizado em 3 etapas, com os conteúdos distribuídos
  da seguinte maneira: 
  - Etapa 1: TDD
  - Etapa 2: Refactoring

* O trabalho deverá ser realizado em grupos de 3 a 5 alunos. 
* Os grupos deverão ser informados através do formulário presente no seguinte [link](https://forms.gle/A28odYrQxo7fv19J8).
* A divisão dos pontos do trabalho será a seguinte: 
  - Etapa 1 (TDD): 15 pontos
  - Etapa 2 (Refactoring): 25 pontos

* O trabalho pode ser desenvolvido na linguagem que o grupo desejar, desde que
  haja um framework de testes unitários que contenha os recursos de testes
  unitários vistos em sala de aula (principalmente categorias de testes, testes
  de exceção, suites de testes, testes parametrizados).

# Cenário da aplicação

Repositórios de informações científicas desempenham um papel importante nas
instituições de pesquisa (tais como universidades públicas ou privadas,
institutos de pesquisa, dentre outros), fundações de fomento à pesquisa (tais
como agências de pesquisa -- FAPDF, CAPES, CNPq, etc..) e órgãos
governamentais. Tais repositórios ajudam na elaboração de editais,
acompanhamento e avaliação da aplicação dos recursos financeiros nas pesquisas
realizadas. Para isso, é necessário que os dados de todo o ecossistema de
pesquisas sejam avaliados quanto à sua qualidade. 

O desafio da avaliação desses dados reside na integração de diferentes fontes de
dados, cada uma com seu formato de representação. Parte dessas informações vêm
de fontes autodeclaratórias, em que os próprios pesquisadores são os
responsáveis por cadastrar suas produções (o Currículo Lattes é o exemplo mais
notório de repositório autodeclaratório). Além disso, muitos repositórios atuam
como indexadores de informações científicas que estão armazenados em repositório
de terceiros. Por exemplo, uma publicação de uma revista científica da área da
Computação fica armazenada no repositório da ACM, mas é indexada por outros
repositórios como ScienceDirect, IEEEXplore, Scopus, etc... Ao integrar os dados
desses diferentes indexadores, é comum que duplicidades de registros sejam
inseridas no banco de dados. 

Busca-se, na curadoria das informações desse repositório, cuidar das
representações desses dados de modo a excluir registros duplicados, unificar as
informações para o que é chamado de padrão-ouro, casos em que há uma
representação padrão a ser adotada para uma parte do registro de informação
científica. 

# Exemplo de curadoria de dados

Seja o seguinte conjunto de registros para uma publicação (dados anonimizados).
Esses dados são, respectivamente, o ID do autor e seu nome dentro de uma mesma
publicação. 

| ID    | Nome                 |
|:------|:---------------------|
| 28372  | Ana de Mattos Seabra |
| 243349 | Ana de Mattos Seabra |
| 582585 | A. M. Seabra |
| 582585 | Seabra A. M. |
| 582585 | AM Seabra |
| 582585 | Ana Mattos Seabra |
| 28371  | Cassius de Souza |
| 746936 | Cassius Souza |
| 746936 | Souza C. |
| 746936 | C. Souza |
| 746936 | Souza, Cassius de |
| 31303  | Veronica de Oliveira Moreira |
| 243352 | Verônica de Oliveira Moreira |
| 608303 | V. de O. Moreira |
| 608303 | Moreira V O |
| 608303 | Moreira V. de O.|
| 746941 | Verônica de Oliveira Noreira |
| 746937 | Luiz de Oliveira de Souza |
| 608296 | Luiz Oliveira Souza |
| 549242 | Souza, Luiz de Oliveira   |
| 549242 | Luiz de O. de Souza |
| 31297  | Souza, L. O. |
| 31299  | Monica Hirata Sant`anna |
| 433095 | Mônica Hirata Sant’anna |
| 746942 | Mônica Hirata St'anna   |
| 549244 | Sant'anna M. H. |
| 608298 | M. H. Sant'anna |
| 763027 | Vanilda Cristina Junior |
| 763027 | Vanilda Cristina Junior |
| 335284 | Vanilda Cristina Júnior |
| 335284 | Vanilda Cristina Júnior |
| 335284 | Vanilda Cristina Júnior |
| 554799 | Sergio Henrique Guaraldi |
| 243350 | Sérgio Henrique Guaraldi |
| 954057 | SH Guaraldi |
| 954057 | Sérgio Henrique Guaraldi |
| 954057 | Sérgio Henrique Guaraldi |
| 954057 | Sérgio Henrique Guaraldi |
| 31298  | Raphael Goncalves Viana |
| 433094 | Raphael Gonçalves Viana |
| 549243 | Raphael Gonçalves Viana |
| 608297 | Raphael Gonçalves Viana |
| 746938 | Raphael Gonçalves Viana |
| 899639 | Lilian Luíza Viana Vieira |
| 243351 | Lílian Luíza Viana Vieira |
| 663795 | Lílian Luíza Viana Vieira |
| 663795 | Lílian Luíza Viana Vieira |
| 663795 | Lílian Luíza Viana Vieira |
| 663795 | Lilian Luíza Viana Vieira |
| 713897 | Yuri Vieira Faria |
| 713897 | Yuri Vieira Faria |
| 713897 | Yuri Vieira Faria |
| 713897 | Yuri Vieira Faria |


No caso dessa publicação, a autoria contém diversos problemas. Cada problema
está listado e explicado em seguida. 

## Caso 1: Diferenças de grafia (tipográficas) 

Esse caso acontece quando há diferença na codificação utilizada ou na grafia dos
nomes. São exemplos desses erros a presença/ausência de acentuação no mesmo
caractere em registros diferentes, uso de acentuação diferente para representar
o mesmo item (apóstrofo, crase ou acento agudo), presenca / ausencia de cedilha
ou acentuação, dentre vários outros. Abaixo são dois exemplos de registros
diferentes para o mesmo autor. 

| ID     |                      |
|--------|----------------------|
| 31299  | M**o**nica Hirata Sant**`**anna |
| 433095 | M**ô**nica Hirata Sant**’**anna |
|--------|----------------------|
| 554799 | S**e**rgio Henrique Guaraldi |
| 243350 | S**é**rgio Henrique Guaraldi |

A solução para ambos os registros acima deve ser a unificação dos registros,
garantindo que estejam corretamente acentuados e com o uso do caractere adequado
(apostrofo) para a palavra composta. Desse modo, a solução seria a alteração dos
nomes para os seguintes registros (as alterações estão destacadas em negrito): 

| ID     |                      |
|--------|----------------------|
| 31299  | **Mônica Hirata Sant'anna** |
| 433095 | **Mônica Hirata Sant'anna** |
|--------|----------------------|
| 554799 |   Sérgio Henrique Guaraldi   |
| 243350 | **Sérgio Henrique Guaraldi** |


## Caso 2: Sobrenome + Iniciais dos nomes

Nesse caso a ocorrência do nome completo e de sua versão abreviada (com ou sem
pontos nas iniciais) devem ser consideradas iguais e unificadas para a versão
completa. Os dois casos apresentados abaixo mostram os nomes completos de
autores e suas versões simplificadas, com e sem a ocorrência de pontos nas
iniciais. 

| ID     |                      |
|--------|----------------------|
| 28372  | Ana de Mattos Seabra |
| 582585 | Seabra A M |
|--------|----------------------|
| 28371  | Cassius de Souza |
| 746936 | Souza C. |

Nesse caso, a deduplicação dos nomes deve ser capaz de identificar a
equivalência entre as versões abreviadas e completas dos nomes e unificá-las
considerando a versão completa. Nesses casos, os registros ficariam (as
alterações estão destacadas em negrito): 

| ID     |                      |
|--------|----------------------|
| 28372  |   Ana de Mattos Seabra   |
| 582585 | **Ana de Mattos Seabra** |
|--------|----------------------|
| 28371  |   Cassius de Souza   |
| 746936 | **Cassius de Souza** |


## Caso 3: Partículas *de* e uso de ponto nas abreviações opcionais

É comum que o uso das partículas _de_ sejam omitidas em algumas bases. O uso de
ponto nas abreviações dos nomes/sobrenome também é variável, considerado como
elemento opcional. Os casos abaixo mostram registros que ocultam a partícula
_de_ e o ponto após a abreviação. 

| ID     |                      |
|--------|----------------------|
| 746937 | Luiz de Oliveira de Souza |
| 608296 | Luiz Oliveira Souza |
| 549242 | Luiz de O. de Souza |

Todos esses casos devem ser considerados equivalentes e a forma completa (com o
uso da partícula _de_) deve ser considerada para a deduplicação. Nesse caso, os
registros ficariam da seguinte maneira (alterações destacadas em negrito): 

| ID     |                      |
|--------|----------------------|
| 746937 | Luiz de Oliveira de Souza |
| 608296 | **Luiz de Oliveira de Souza** |
| 549242 | **Luiz de Oliveira de Souza** |



## Caso 4: Iniciais dos nomes agrupadas + sobrenome

Há casos em que as iniciais do nome e dos primeiros sobrenomes são agrupadas
restando por extenso apenas o último nome. Os registros apresentados abaixo
mostram ocorreências desse tipo de duplicação de nomes. 

| ID     |                      |
|--------|----------------------|
| 763027 | Vanilda Cristina Junior |
| 763027 | VC Junior |
| 243350 | Sérgio Henrique Guaraldi |
| 954057 | SH Guaraldi |

Em ambos os casos, a versão completa do nome deve ser preferida em relação à
versão com abreviações. Nesses casos, a deduplicação deverá resultar nos
seguintes registros (alterações destacadas em negrito): 

| ID     |                      |
|--------|----------------------|
| 763027 | Vanilda Cristina Junior |
| 763027 | **Vanilda Cristina Junior** |
| 243350 | Sérgio Henrique Guaraldi |
| 954057 | **Sérgio Henrique Guaraldi** |


## Caso 5: IDs diferentes para o mesmo autor.

Por fim, devido às diversas fontes de dados, os registros de publicação e
autorias ficam duplicados, sendo um registro para cada fonte. Nesses casos,
todos os registros deverão ser mapeados para o mesmo id, sendo o id de menor
valor eleito para ser utilizado na deduplicação. Os seguintes registros abaixo
são de um mesmo autor em uma mesma publicação. 

| ID     |                      |
|--------|----------------------|
| 31298  | Raphael Goncalves Viana |
| 433094 | Raphael Gonçalves Viana |
| 549243 | Raphael Gonçalves Viana |
| 608297 | Raphael Gonçalves Viana |
| 746938 | Raphael Gonçalves Viana |

Nesse caso, todos os registros deverão ser mapeados para o ID 31298, conforme
demonstra o resultado abaixo (alterações destacadas em negrito): 

| ID     |                      |
|--------|----------------------|
| 31298  | Raphael Goncalves Viana |
| **31298**  | Raphael Gonçalves Viana |
| **31298**  | Raphael Gonçalves Viana |
| **31298**  | Raphael Gonçalves Viana |
| **31298**  | Raphael Gonçalves Viana |


# Enunciado do Trabalho Prático 1

O trabalho prático 1 consiste no desenvolvimento das unidades para cada um dos
casos apresentados acima, utilizando a técnica de _Test-Driven Development_
(TDD). Os grupos deverão desenvolver os trabalhos em alguma **linguagem
orientada a objetos**, à escolha do grupo, **desde que exista um framework de
testes unitários para essa linguagem**. O framework de testes unitários deverá
ter suporte a suítes de testes, categorias de testes, testes parametrizados e
testes de exceção. 

Todos os cinco casos acima deverão estar contemplados no trabalho dos grupos.
Para cada caso deve haver, no mínimo um teste para a unidade correspondente.
Caso a unidade desenvolvida seja testada por mais de um teste, todos os testes
deverão estar agrupados em uma suite correspondente ao item que foi
desenvolvido. 

Os grupos podem considerar os dados de cada caso como valores para os testes que
vão ser desenvolvidos. Recomenda-se, para efeitos de reforçar os testes, que os
valores de cada item sejam complementados com alterações nos dados apresentados
na tabela presente na seção `Exemplo de curadoria de dados`. 

A raiz do repositório do trabalho do grupo deverá conter um arquivo `README.md`
contendo os seguintes itens: 
- Nome e matrícula de todos os integrantes do grupo
- Linguagem Orientada por Objetos que foi utilizada
- Framework de testes unitários que foi utilizado, indicando claramente a versão
- **Instruções de execução dos testes no framework utilizado**


# Critérios de correção:

- Deve haver, no mínimo, um teste para cada caso de deduplicação de nomes. 
- Deve haver, no mínimo, dois conjuntos de dados de teste para cada caso de
  deduplicação. 
- Cada teste, para ser avaliado, deve necessariamente passar (barra verde). Nos
  casos em que os testes não passam (barra vermelha) a unidade será considerada
como não implementada. 
- Nos casos em que os testes passam, a unidade correspondente será avaliada
  quando à efetividade de sua implementação. Unidades _hard-coded_ ou apenas
falsificadas serão consideradas como não implementadas. 
- Todos os testes deverão ser executados em conjunto, independentemente do
  escalonamento dos testes (não deve haver condição de corrida). 



# Data de entrega: 

- 10/06/2025, 16:00hs, via repositório dos grupos. 


---
# Enunciado do Trabalho Prático 2 - Refatoração

O trabalho prático #2 consiste na aplicação de operações de refatoração e será
realizado com base nos artefatos entregues pelos grupos no TP1. 

Todos os grupos vão aplicar as mesmas operações de refatoração em seus
trabalhos, a citar, `Extrair Método`, `Substituir Método por Objeto-Método`, e
`Extrair Classe`. A tabela abaixo mostra para cada grupo, onde cada uma dessas
operações de refatoração deverá ser aplicada. Identifique a qual grupo você
pertence pelo número de matrícula. 



| Grupo # | Matrículas dos componentes                            | Extrair Método                           | Substituir Método por Objeto Método                  | Extrair classe    | 
|:-------:|:------------------------------------------------------|:-----------------------------------------|:-----------------------------------------------------|:---------------   |
|    1    |                                                       |                                          |                                                      |                   |
|    2    |                                                       |                                          |                                                      |                   |
|    3    |                                                       |                                          |                                                      |                   |
|    4    |                                                       |                                          |                                                      |                   |
|    5    |                                                       |                                          |                                                      |                   |
|    6    |                                                       |                                          |                                                      |                   |
|    7    |                                                       |                                          |                                                      |                   |
|    8    |                                                       |                                          |                                                      |                   |
|    9    |                                                       |                                          |                                                      |                   |
|   10    |                                                       |                                          |                                                      |                   |
|   11    |                                                       |                                          |                                                      |                   |
|   12    |                                                       |                                          |                                                      |                   |
|   13    |                                                       |                                          |                                                      |                   |
|   14    |                                                       |                                          |                                                      |                   |
|   15    |                                                       |                                          |                                                      |                   |
|   16    |                                                       |                                          |                                                      |                   |
|   17    |                                                       |                                          |                                                      |                   |
|   18    |                                                       |                                          |                                                      |                   |
|   19    |                                                       |                                          |                                                      |                   |
|   20    |                                                       |                                          |                                                      |                   |

## Formato de entrega: 

- Para cada operação de refatoração aplicada, o grupo deverá ao final realizar
  um commit com a seguinte mensagem de título:  
  `[Refact] <operação>, <Classe / Método alvo>`  
  em que `<operação>` deve ser o nome da refatoração aplicada e `<Classe /
Método alvo>` deve ser o nome do local onde ela foi aplicada. 
- A entrega será feita pelo envio dos commits aos repositórios dos grupos.
  Somente serão aceitos commits até a data limite da entrega, commits
posteriores serão desconsiderados. 


## Critérios de Correção: 
- Para cada operação de refatoração: 
  - A refatoração foi aplicada no lugar indicado?
  - A operação de refatoração foi aplicada corretamente, em especial, aquelas
    operações realizadas sem suporte ferramental? 
  - O resultado da operação de refatoração é correto do ponto de vista da
    estrutura do código gerado? 
- Os testes continuam efetivos e passando? 

## Data-limite para entrega: 
- xx/xx/xxxx, xx:xxhs. 
