UnB - Universidade de Brasilia  
FCTE - Faculdade de Ciência e Tecnologia em Engenharias  
FGA0242 - Técnicas de Programação para Plataformas Emergentes  

---

Atividade extraclasse

Esta atividade prepara vocês para a próxima aula, e aborda os Grupos 1 e 2 do
catálogo de refatorações: **Composição de Métodos** e **Movendo Recursos entre
Objetos**.

A atividade é sobre conceitos relacionados aos grupos e as operações de
refatoração: não é necessário escrever ou alterar código. O objetivo é chegar à
aula já com vocabulário e critérios claros sobre o que cada refatoração faz, por
que ela existe e o que muda no código depois de aplicada -- a aula vai se apoiar
nessas definições para ir direto aos exemplos práticos.


## Grupo 1: Composição de Métodos

**Exercício 1.1** -- Definição conceitual do grupo

Responda cada uma das questões a seguir:

a) O que caracteriza uma refatoração do grupo Composição de Métodos? Que tipo de
problema estrutural ela ataca dentro de um único método (ex.: método longo,
mistura de níveis de abstração, trechos difíceis de nomear ou reaproveitar)?  

b) Qual é o objetivo geral perseguido por esse grupo de refatorações — o que se
espera que um método passe a ter (ou deixe de ter) depois de refatorado?  

c) Que "sintomas" no código (code smells) costumam apontar para a necessidade de
uma refatoração deste grupo?  


**Exercício 1.2** -- Refatorações do grupo

Considere apenas as seguintes refatorações do **Grupo 1 - Composição de
métodos**: 

- Extrair Método (Extract Method)
- Extrair Variável (Extract Variable)
- Dividir Variável Temporária (Split Temporary Variable)

Para cada uma das operações acima, escreva um parágrafo curto que responda:

a) Intuito -- qual problema essa refatoração resolve e o que ela faz,
   conceitualmente, com o código.

b) Quando aplicar -- que sinais no código indicam que essa refatoração é a mais
   adequada (e não outra do mesmo grupo).

c) Resultados -- o que muda na estrutura do código após a aplicação
   (legibilidade, granularidade, acoplamento, testabilidade etc.), e se há algum
   cuidado ou risco a observar.


---

## Grupo 2: Movendo Recursos entre Objetos

**Exercício 2.1** -- Definição conceitual do grupo

Responda cada uma das questões a seguir:

a) O que caracteriza uma refatoração do grupo Movendo Recursos entre Objetos?
Diferente do Grupo 1, o foco aqui não é a estrutura interna de um método, e sim
a distribuição de responsabilidades entre classes. Que tipo de problema esse
grupo ataca?

b) Qual é o objetivo geral perseguido por esse grupo -- o que se espera da
relação entre as classes envolvidas depois da refatoração (coesão, acoplamento,
localização correta do comportamento)?

c) Quais "sintomas" no código costumam apontar para a necessidade de mover um
método, um campo, ou até extrair/embutir uma classe inteira (ex.: Feature Envy,
Data Class, classes que fazem pouco ou demais)?


**Exercício 2.2** -- Refatorações do grupo

Considere apenas as seguintes refatorações do **Grupo 2 -- Movendo Recursos
entre Objetos**:

- Mover Método (Move Method)
- Mover Campo (Move Field)
- Extrair Classe (Extract Class)
- Introduzir Método Estrangeiro (Introduce Foreign Method)

Para cada uma das operações acima, escreva um parágrafo curto que responda:

a) Intuito -- qual problema de distribuição de responsabilidades essa
   refatoração resolve e o que ela faz, conceitualmente, com as classes
   envolvidas.

b) Quando aplicar -- que sinais no código indicam que essa refatoração é a mais
   adequada (e não outra do mesmo grupo).

c) Resultados -- o que muda no relacionamento entre as classes após a aplicação
   (coesão, acoplamento, quem passa a conhecer quem), e se há algum cuidado ou
   risco a observar (ex.: quebra de encapsulamento, dependências cíclicas).
