
UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

---

## Aula 17 - Programação Defensiva



**Tópicos da aula**
- Exercícios de fixação


### Enunciado do Exercício

**Título:** O Sistema de Controle da "EcoCiclo"   

**Cenário:**  
Você é o engenheiro de software responsável pelo backend da *EcoCiclo*, uma
startup de aluguel de bicicletas compartilhadas.

Sua tarefa é projetar a classe `EstacaoDeBicicletas`. Cada estação física no
mundo real possui um número limitado de "Docks" (docas/vagas) onde as bicicletas
são travadas. O sistema deve garantir a integridade dos dados o tempo todo: não
podemos alugar bicicletas fantasmas, nem devolver bicicletas em uma estação que
já está fisicamente cheia.


**Requisitos do Sistema:**

1.  Toda estação é inicializada com uma **capacidade máxima** (número de vagas)
    e um **estoque inicial** de bicicletas.
2.  A capacidade máxima deve ser sempre um número positivo.
3.  A quantidade atual de bicicletas nunca pode ser negativa e nunca pode
    exceder a capacidade máxima da estação.
4.  Existe um método `alugarBicicleta()` que retira uma unidade do estoque.
5.  Existe um método `devolverBicicleta()` que adiciona uma unidade ao estoque.

**Sua Missão:**
Utilizando os princípios de *Design by Contract* (Bertrand Meyer), defina
formalmente a especificação desta classe. Escreva o código completo da
implementação mas, principalmente, escreva as assinaturas dos métodos e as
regras de contrato.

**Especifique:**

1.  **Invariantes de Classe:** As regras que devem ser sempre verdadeiras para o
    objeto `EstacaoDeBicicletas`, independentemente do momento.
2.  **Pré-condições:** O que deve ser verdade *antes* de chamar
    `alugarBicicleta()` e `devolverBicicleta()`.
3.  **Pós-condições:** O que o sistema garante que será verdade *após* a
    execução bem-sucedida desses métodos.

-----
