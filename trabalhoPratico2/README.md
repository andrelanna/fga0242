UnB - Universidade de Brasilia  
FCTE - Faculdade de Ciências e Tecnologias em Engenharias  
FGA0242 - Técnicas de Programação para Plataformas Emergentes  

--- 

# Trabalho prático 2 - semestre 2025/1


--- 

# Enunciado do trabalho

## Projeto de código

**Valor:** 40 pontos  
**Data de entrega:** 14/02/2025, 23:59hs. 

Projeto de software é, muitas vezes, entendido como uma atividade dentro do
processo de desenvolvimento em que uma equipe define as estruturas do software e
as interações entre elas. O intuito com esse tipo de abordagem é facilitar o
desenvolvimento à partir dos artefatos gerados durante a atividade de projeto.
Os artefatos gerados servem como uma especificação do que o software deve fazer
e quais as propriedades que devem ser garantidas quando ele estiver em operação.

Contudo, a realidade é diferente. O código é também uma atividade de projeto de
software. Basta relembrar do conceito de Refatoração. Martin Fowler, em seu
livro de refatoração, define como sendo "_o aperfeiçoamento do **projeto** de
código sem alterar o seu comportamento externamente observável._"(Fowler, 1999).
Por mais detalhado que sejam os artefatos de software criados durante a
atividade de projeto de software, eles não conseguirão capturar todos os
detalhes que são considerados durante a codificação. Os menores detalhes
escapam dos modelos gerados e, geralmente, são descobertos durante a atividade
de codificação sob a forma de inconsistências, falhas ou erros. Disso segue um
conceito-chave muito importante: 

> Conceito chave:  
> Programar é uma atividade de projeto de software. 

Portanto, são os programadores quem refinam e extendem o projeto de software na
medida em que, constantemente, várias vezes ao dia, refinam e extendem o código
da aplicação. Isso não significa que a idéia inicial de um projeto deva ser
descartada. Pelo contrário, ter em mente o projeto que se deseja alcançar é
importante, pois ele se torna uma meta a ser alcançada. Essa meta de projeto
deve ser minimamente coerente para que o projeto resultante não se transforme em
um projeto desestruturado e de difícil manutenção e evolução. 

## Projeto de software

Desenvolvedores, em suas funções, realizam atividades de projeto de código, como
classes, objetos e estruturas de dados. Essas pequenas contribuições vão sendo
incorporadas ao projeto do software na medida em que são desenvolvidas. Em
escala ascendente, os níveis de projeto de software são:  
- funções: nível mais elementar das atividades de projeto, mas não menos
  importante. Se as rotinas são projetadas sem cuidado todo o sistema será
  impactado. Uma vez definido quais são as funções necessárias, trabalha-se na
  implementação interna, definindo algoritmos e o fluxo de execução. 
- classes e tipos de dados: após a definição das funções, as atividades de
  codificação que resultam em alterações no projeto concentram-se nas definições
  de interfaces para utilização dessas funções. Nesse nível busca-se projetar
  interfaces que sejam representem o conjunto das funções encapsuladas. Isso se
  dá, no contexto de orientação a objetos, por meio da definição de classes e
  interfaces. 
- módulos e componentes: o passo seguinte é organizar as classes desenvolvidas
  em conjunto de classes, compreensíveis, que guardem alguma relação de
  similaridade ou proximidade entre si. Costuma-se chamar esses agrupamentos de
  módulos ou componentes, contudo, é necessário atentar-se ao que se entende por
  módulos. Por exemplo, pode ser considerado como um conjunto de classes em
  linguagens orientadas por objetos ou como bibliotecas em linguagens
  procedurais. Nesse ponto do projeto o que se busca é a definição de interfaces
  **publicadas**, as quais deverão ser estáveis pois desempenham o papel de
  contratos entre os módulos e entre as equipes que trabalham nelas. 
- arquitetura do sistema: nesse ponto observa-se o sistema e seus subsistemas
  como um todo. O projeto arquitetural desempenha forte influência no desempenho
  e nas características do sistema como um todo. 

O projeto de software é a base sobre a qual todo o software será construído, uma
vez que essa base é bem projetada e estruturada aumentam-se as chances do
software construído ter qualidade. São características de um bom projeto de
software: 
- fácil de escrever; 
- fácil de entender; 
- fácil de manter; 
- menos provável de ter bugs e, por fim,
- mais resiliente à mudanças.

Tudo isso exposto, conclui-se que ter um projeto de software correto,
principalmente desde o início, é muito importante. É possível pensar em
características de bom projeto em nível micro, durante a codificação, de modo
que as boas práticas se acumularão e terão impactos no projeto do software como
um todo. Vários desses princípios guardam estreita relação com as operações de
refatoração de modo que é possível realizar melhorias em projetos de código
existentes aplicando uma ou uma sequência de operações. Em linhas gerais, os
princípios de um bom projeto de código são: 
- simplicidade; 
- elegância; 
- modularidade; 
- boas interfaces; 
- extensibilidade; 
- evitar duplicação; 
- portabilidade; 
- código deve ser idiomático e bem documentado.

## Enunciado: 

Com base na descrição acima, cada grupo de trabalho deverá responder as
seguintes perguntas: 

1 - Para cada um dos princípios de bom projeto de código mencionados acima,
apresente sua definição e relacione-o com os maus-cheiros de código apresentados
por Fowler em sua obra.

2 - Identifique quais são os maus-cheiros que existem no trabalho prático 2 do
grupo, indicando quais os princípios de bom projeto estão sendo violados e
indique quais as operações de refatoração são aplicáveis. Atenção: não é
necessário aplicar as operações de refatoração, apenas indicar os princípios
violados e operações possíveis de serem aplicadas. 

## Formato e Data de entrega: 

O trabalho deverá ser entregue na forma de um relatório em PDF, elaborado pelo
grupo. O trabalho será enviado na sala da disciplina, disponível no Moodle. As
referências listadas abaixo devem ser consultadas em suas respostas. 

A data-limite de entrega é dia 14/02/2025, 23:59hs. 



## Referências bibliográficas
- Martin Fowler. Refactoring: Improving the design of Existing Code.
  Addison-Wesley Professional, 1999.
- Pete Goodliffe. Code Craft: The practice of Writing Excellent Code. No Starch
  Press, 2006. 
