UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
TPPE - Técnicas de Programação para Plataformas Emergentes  

### Trabalho Prático 1 - _Test-Driven Development_

---

**Enunciado do trabalho** 

Seja o cenário descrito a seguir: 

> Um sistema de estoque e inventário é uma aplicação de software projetada para
> ajudar as empresas a gerenciar eficientemente o controle de estoque e o
> acompanhamento de mercadorias. Esses sistemas são essenciais para empresas que
> mantêm um inventário de produtos físicos, sejam eles materiais para produção,
> produtos acabados para venda ou componentes diversos. Aqui estão alguns
> detalhes-chave sobre o que um sistema de estoque e inventário envolve:
> 
> ##### Componentes Principais:  
> 
> - Produtos e Materiais:  
> Cada item no estoque é representado como um produto ou material.  Informações
> associadas incluem descrição, código de barras, custo, preço de venda,
> quantidade disponível, etc.
> 
> - Categorias e Classificações:
> Os produtos são geralmente organizados em categorias e classificações para
> facilitar a organização e busca.  Exemplos de categorias podem ser
> eletrônicos, roupas, alimentos, etc.
> 
> - Fornecedores:
> Os detalhes dos fornecedores são registrados para cada produto, facilitando o
> reabastecimento e a gestão de relacionamentos com fornecedores.
> 
> - Transações de Estoque:
> Cada movimentação no estoque é registrada como uma transação.
> Transações incluem recebimento de mercadorias, vendas, devoluções,
> transferências entre locais, etc.
>
> - Quantidades e Valores:
> O sistema mantém um registro preciso da quantidade disponível de cada produto,
> bem como seu valor monetário total no estoque.
> 
> - Alertas de Estoque Baixo:
> O sistema pode gerar alertas automáticos quando os níveis de estoque atingem
> um limiar mínimo, indicando a necessidade de reabastecimento.
> 
> ##### Funcionalidades Importantes:
> 
> 
> - Cadastro de Produtos:
> Permite ao usuário adicionar novos produtos ao sistema, incluindo informações
> como nome, descrição, código de barras, preço de compra, preço de venda,
> quantidade inicial em estoque e fornecedor.
> 
> - Consulta de Estoque:
> Permite visualizar de forma rápida e intuitiva a quantidade atual em estoque
> de cada produto, facilitando o acompanhamento dos níveis de inventário.
> 
> - Gestão de Transações:
> Possibilita o registro de todas as movimentações de estoque, como recebimento
> de mercadorias, vendas, transferências entre filiais, devoluções, ajustes de
> estoque, entre outros.
> 
> - Alertas de Estoque Baixo:
> Configuração de alertas automáticos que notificam os usuários quando os níveis
> de estoque de um produto atingem um limite mínimo predefinido, indicando a
> necessidade de reabastecimento.
> 
> - Rastreamento de Lotes e Validade:
> Permite o rastreamento detalhado de lotes de produtos, especialmente útil para
> itens com data de validade. O sistema pode alertar sobre produtos próximos ao
> vencimento.
> 
> - Relatórios Gerenciais:
> Geração de relatórios detalhados sobre o desempenho do estoque, movimentações,
> produtos mais vendidos, histórico de transações e outros dados relevantes para
> a tomada de decisões estratégicas.
> 
> - Gestão de Fornecedores:
> Facilita o cadastro e a atualização de informações sobre os fornecedores, além
> de fornecer uma visão geral das compras realizadas com cada fornecedor.
> 
> - Gestão de Pedidos e Compras:
> Permite a criação, acompanhamento e fechamento de ordens de compra,
> integrando-se ao processo de compras e garantindo uma gestão eficiente do
> relacionamento com fornecedores.
> 
> - Controle de Acesso:
> Configuração de diferentes níveis de permissão de acesso para usuários,
> garantindo que apenas pessoal autorizado possa realizar operações críticas,
> como ajustes manuais de estoque.
> 
> - Integração com Sistemas Externos:
> Oferece a capacidade de integração com sistemas de vendas, contabilidade e
> outros sistemas corporativos para garantir consistência nos dados e evitar a
> necessidade de entrada manual de informações em vários sistemas.

O trabalho prático 1 consiste na implementação de parte dessa aplicação com o
emprego das técnicas de TDD. As 5 primeiras funcionalidades deverão ser
implementadas pelos grupos, **utilizando linguagens (e os conceitos) de
Orientação por Objetos**, e frameworks de testes unitários adequados para a
linguagem adotada para o desenvolvimento da aplicação. Para cada funcionalidade
deverão ser implementados testes que asseguram o resultado final desejável para
a funcionalidade e os testes para os casos de exceção. As funcionalidades e as
descrições dos testes estão listados a seguir: 

* Cadastro de Produtos: 
  - Garantir que o produto está cadastrado no sistema informando
    obrigatoriamente o nome do produto, seu código de barras, preço de compra, 
    preço de venda e quantidade inicial em estoque. 
  - Se algum desses itens acima não for informando, garantir que o produto não
    seja cadastrado através do lançamento da exceção `DescricaoEmBrancoException`.
  - Se os valores de compra e venda e a quantidade de itens inicial em estoque
    for menor ou igual a zero, garantir que o item não seja cadastrado através
    do lançamento da exceção `ValorInvalidoException`.  
  
* Consulta de Estoque: 
  -  Garantir que o produto seja recuperado toda vez que ele for recuperado em
     buscas pelo seu nome ou pelo seu código de barras.  
<<<<<<< HEAD

* Gestão de Transações:
  - Garantir que os seguintes tipos de transações sejam realizadas e os estoques
    dos produtos sejam atualizados: recebimento de mercadoria, vendas,
    transferências entre filiais, devoluções, ajustes de estoque. 
  - Garantir que não serão informadas quantidades negativas para as transações,
    exceto para ajustes de estoque. Nos outros casos, lançar exceções do tipo
    `ValorInvalidoException`. 

* Alertas de Estoque Baixo: 
  - Garantir que um alerta de estoque mínimo seja emitido sempre que um produto
    atingir uma quantidade igual ou inferior ao seu limite pré-definido. 
  - Esse alerta deverá informar os dados do produto, a quantidade atual em
    estoque e os dados do fornecedor do produto. 
  - Nos casos em que o estoque for menor do que zero após a movimentação do
    produto, deverá ser lançada uma exceção do tipo `EstoqueNegativoException`
    que deverá atribuir 0 (zero) à quantidade de itens em estoque do produto. 

* Rastreamento de lotes e validade: 
  - Garantir que o sistema informe corretamente a quantidade total de itens para
    um determinado produto; 
  - Garantir que o sistema informe corretamente a quantidade total de itens de
    cada lote para um determinado produto; 
  - Garantir que o sistema emita um alerta de lotes próximos à data de validade
    e atualize o preço de venda daqueles produtos em -20%. 
=======
  
>>>>>>> 65a4fa4d73c969eff175f4534a587fce88a38138

* Gestão de Transações:
  - Garantir que os seguintes tipos de transações sejam realizadas e os estoques dos produtos sejam atualizados: recebimento de mercadoria, vendas, transferências entre filiais, devoluções, ajustes de estoque. 
  - Garantir que não serão informadas quantidades negativas para as transações,
    exceto para ajustes de estoque. Nos outros casos, lançar exceções do tipo
`ValorInvalidoException`. 

* Alertas de Estoque Baixo: Configuração de alertas automáticos que notificam os usuários quando os níveis de estoque de um produto atingem um limite mínimo predefinido, indicando a necessidade de reabastecimento.

Rastreamento de Lotes e Validade: Permite o rastreamento detalhado de lotes de produtos, especialmente útil para itens com data de validade. O sistema pode alertar sobre produtos próximos ao vencimento.

O trabalho deverá apresentar o emprego das três técnicas de TDD (falsificação,
duplicação e triangulação) em, pelo menos, nas três seguintes situações: 

<<<<<<< HEAD
* Transferência entre filiais
* Emissão de alerta de produtos próximos à data de validade
=======
* Situação X
* Situação X
>>>>>>> 65a4fa4d73c969eff175f4534a587fce88a38138

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
23:59:59hs do dia 3 de dezembro de 2023, impreterivelmente. 

Os grupos deverão informar ao professor o endereço do repositório do projeto
antes da data final de entrega. 

**Valor do trabalho**

30 pontos. 

**Forma de avaliação**

Os trabalhos serão avaliados através:

- da corretude dos testes;
- da utilização de testes parametrizados em todos os testes funcionais; 
- da utilização de testes de exceção e, por fim, 
- das seqüências de _commits_ para os casos em que o emprego das técnicas de
  falsificação, duplicação e triangulação é obrigatório.
