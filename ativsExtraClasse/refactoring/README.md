UnB - Universidade de Brasilia  
FCTE - Faculdade de Ciências e Tecnologias em Engenharias  
FGA0242 - Técnicas de Programação para Plataformas Emergentes  
---

# Atividade extra-classe / Estudo dirigido para avaliação 2 (Refactoring)

### Observações: 
- Essa atividade corresponde ao conteúdo das aulas dos dias 27 e 29/04/2026.
- A atividade deverá ser entregue impressa até o dia 11/05/2026. 

### Referências a serem utilizadas nessa atividade
- [Refactoring Guru](https://refactoring.guru/refactoring)
- [Refactoring Catalog](https://refactoring.com/)
- FOWLER, M.; BECK, K. **Refactoring : improving the design of existing code**.
  Reading, Ma: Addison-Wesley, Addison Wesley Longman, Inc., November, 2014.


---

#### Questão 1:
Defina o conceito de Refatoração, conforme a literatura clássica (Martin
Fowler). Em sua resposta, explique qual é o objetivo primordial dessa prática e
como ela se diferencia de uma manutenção corretiva ou da simples adição de novas
funcionalidades.

#### Questão 2: 
Uma das premissas da refatoração é que ela não deve alterar o comportamento
observável do software. Como o desenvolvedor pode garantir que uma transformação
no código não quebrou funcionalidades existentes? Explique o papel dos Testes
Unitários e do ciclo _Red-Green-Refactor_ nesse processo.

#### Questão 3: 
Realize uma breve pesquisa e defina os seguintes princípios, apresentando um
pequeno exemplo (pode ser em pseudocódigo ou descrição lógica) de como eles
melhoram a estrutura de um sistema:
- Alta Coesão e Baixo Acoplamento (GRASP);
- DRY (Don't Repeat Yourself);
- Princípio da Responsabilidade Única (SRP - SOLID);
- Ocultamento de Informação (Encapsulamento).

#### Questão 4: 
O que são os chamados "maus-cheiros de código"? Explique a relação direta entre
a presença de um _Code Smell_ (como Long Method ou God Class) e a violação dos
princípios de bom projeto discutidos na questão anterior. Por que o "cheiro" é
um indicador e não necessariamente um erro de compilação?

#### Questão 5: 
Martin Fowler organiza as operações de refatoração em grupos para facilitar a
identificação da solução. Cite e explique brevemente os grupos definidos no
catálogo por Fowler, mencionando pelo menos um exemplo de operação pertencente a
cada grupo escolhido.

#### Questão 6: 
Existem cenários onde refatorar pode ser contraproducente ou até perigoso.
Explique por que Interfaces Publicadas (APIs utilizadas por terceiros)
representam um desafio crítico para a refatoração. Cite outra situação em que o
custo de refatorar um código existente supera o benefício, sendo preferível
reescrevê-lo do zero.

#### Questão 7 - Prática de refatoração

Na pasta desse exercício encontra-se o código da calculadora de IRPF. O código
está organizado nas seguintes subpastas: 
* `main.java.fga0242`: contém os arquivos desenvolvidos para a aplicação. Essas
  funcionalidades foram desenvolvidas seguindo as técnicas de TDD. 
* `main.java.exceptions`: contém as classes que originam objetos de exceção
  lançadas pela aplicação. 
* `test.java.fga0242`: contém os arquivos de testes, em especial, a classe
  `AppTest` que implementa uma suíte que cobre todos os testes desenvolvidos. 

Com base nesses arquivos, faça o que se pede a seguir: 

a) a classe `Declaracao` é a principal classe da aplicação. Avalie-a e
identifique ao menos 3 maus-cheiros de código. Para cada mau-cheiro indique,
claramente, seu nome, o local em que ocorre e qual a(s) operação(ões) de
refatoração sugeridas. 

b) identifique códigos duplicados ao longo da classe `Declaracao` e aplique a
operação `Extrair método` para eliminar os códigos duplicados. 

c) aplique a operação de refatoração `Substituir método por objeto-método` nos
métodos `cadastrarDependente(String nome, String cpf)` e `calcularImposto()`.
