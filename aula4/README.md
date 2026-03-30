UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

---

# Aula 4 - Exercícios de revisão de Design Patterns

---

Tópicos da aula:
- Realizar exercíos sobre os seguintes padrões de projeto: 
  - Composite
  - Template Method
  - Factory Method
  - Singleton

Observações:
- Esse exercício será utilizado como base para as aulas de testes unitários. 

--- 

## Descrição do cenário:

#### Sistema de Processamento de Folha de Pagamento e Encargos

Uma empresa precisa de um sistema para gerenciar sua estrutura organizacional e
automatizar o cálculo de pagamentos. A estrutura é composta por departamentos,
subdepartamentos e funcionários individuais.

##### Os Desafios:
- Estrutura Hierárquica: Um departamento pode conter outros departamentos ou
  funcionários. O sistema deve permitir calcular o custo total de qualquer nível
da hierarquia de forma uniforme.

- Processamento de Bônus: Existem diferentes tipos de contratos (CLT, PJ,
  Estagiário). O processo de cálculo do bônus anual segue um rito obrigatório
(verificar metas, calcular valor base, aplicar impostos), mas o cálculo do
"valor base" e a "alíquota de imposto" variam drasticamente conforme o tipo de
contrato.

- Criação de Objetos: O sistema não deve acoplar a lógica de negócio à criação
  de instâncias de funcionários, delegando isso a fábricas especializadas.



##### Enunciado do Exercício
- Objetivo: 
    - Exercitar o projeto de padrões que colaboram entre si, tanto na formação
      da estrutura construída pelas associações entre objetos, quando pela
      execução de funcionalidades através das colaborações entre eles.

    - Apresentar o Diagrama de Classes UML para a solução construída.

    - Implementar o núcleo do sistema em Java, aplicando padrões de projeto que
      garantam extensibilidade e facilidade para futuros testes unitários.


- Requisitos Técnicos:
  - Padrão Composite:

    - Crie uma interface `ComponenteOrganizacional` com o método `getSalario()`.
     
    - Implemente a classe `Funcionario` (Folha) e `Departamento` (Composite). Um
      departamento deve ser capaz de retornar a soma dos salários de todos os
      seus membros (diretos ou indiretos).

  - Padrão Template Method:
  
    - Crie uma classe abstrata `ProcessadorBonus`. Ela deve ter um método final
      chamado `processarPagamento()`.
     
    - Este método deve definir os passos: `verificarPresenca()`,
      `calcularValorBase()` (abstrato) e `aplicarImposto()` (abstrato).
     
    - Implemente as subclasses `BonusCLT`, `BonusPJ` e `BonusEstag`, provendo as
      regras específicas de cada uma.

    - Detalhamento de regras de negócio para os diferentes tipos de funcionários

      1. Funcionário CLT (Consolidação das Leis do Trabalho)
         - Os funcionários CLT recebem bônus baseados em tempo de casa e sofrem
           retenção na fonte.
          
         - Cálculo do Valor Base: O bônus é de 15% do salário bruto para cada
           ano completo de empresa (limite de 10 anos).
          
         - Aplicação de Imposto: 
           - Se o valor base for menor que R$ 2.000,00: Isento (0%).
          
           - Se for maior ou igual a R$ 2.000,00: Retenção fixa de 27,5% de
             IRRF.
      
      2. Funcionário PJ (Pessoa Jurídica)
         - Os parceiros PJ recebem um bônus por entrega de metas contratuais e
           gerem seus próprios impostos, mas a empresa aplica uma taxa de
           serviço.
          
         - Cálculo do Valor Base: Valor fixo de R$ 5.000,00 (independente do
           salário), multiplicado por um "Fator de Desempenho" (um valor double
           entre 0.0 e 1.5 definido no cadastro do prestador).
          
         - Aplicação de Imposto: Taxa única de 5% de nota fiscal de serviço
           (ISS) retida pela TechCorp.
      
      3. Estagiário
         - Os estagiários possuem uma regra simplificada para incentivo aos
           estudos.
          
         - Cálculo do Valor Base: Valor fixo de R$ 500,00 se a nota média da
           faculdade (informada no sistema) for superior a 7.0. Caso contrário,
           o bônus é zero.
          
         - Aplicação de Imposto: Isenção total (0%), conforme a legislação
           vigente para bolsas de estágio.



  - Padrão Factory Method:
  
    - Implemente uma `FuncionarioFactory` com um método `criarFuncionario(String
      tipo)`.
     
    - Isso permitirá que, nos testes unitários, possamos instanciar diferentes
      tipos de funcionários sem espalhar o operador `new` pelo código.
  
  - Padrão Singleton:
  
    - Crie uma classe `ConfiguracaoSistema` que armazena a "Taxa de Bônus
      Global".
     
    - Garanta que apenas uma instância desta classe exista e que ela seja
      acessível globalmente.

##### Preparação para Testes Unitários (Próxima Etapa)
Ao implementar, certifique-se de que sua lógica de negócio não esteja "presa" a
métodos estáticos ou entradas de teclado (Scanner). Para facilitar os testes que
escreveremos nas próximas aulas, você deverá ser capaz de:

- Testar se o cálculo do Departamento está correto ao somar 3 funcionários.
 
- Testar se o `ProcessadorBonus` lança uma exceção se a meta não for atingida.
 
- Garantir que o Singleton mantém o estado consistente entre diferentes chamadas.
