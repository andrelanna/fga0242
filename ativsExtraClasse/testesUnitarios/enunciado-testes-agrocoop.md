UnB -- Universidade de Brasilia   
FCTE -- Faculdade Ciência e Tecnologia em Engenharias  
FGA0242 -- Técnicas de Programação para Plataformas Emergentes   

---


### Atividade extra-classe -- Testes Unitários com JUnit4

## 1. Contexto

A **AgroCoop** é uma cooperativa de agricultura familiar que vende produtos
(hortifrúti, grãos, laticínios e insumos) para três perfis de cliente:
**cooperados**, **varejo** e **atacado**. O sistema já possui a lógica de
negócio implementada (fornecida a vocês nos pacotes `com.agromart.model` e
`com.agromart.service`), mas está **sem nenhum teste automatizado**.

Seu trabalho não é alterar as regras de negócio, e sim **escrever a
suíte de testes JUnit4** que garanta que essas regras continuem
corretas ao longo do tempo -- exercitando, de forma justificada pelo
próprio domínio, todos os recursos de JUnit4 vistos em aula.

## 2. Classes fornecidas

| Classe | Responsabilidade |
|---|---|
| `Produto`, `Cliente`, `TipoCliente`, `ItemPedido`, `Pedido` | Modelo de domínio |
| `Estoque` | Reserva de itens; lança `EstoqueInsuficienteException` |
| `CalculadoraFrete` | Cálculo de frete por região e cálculo de rota de entrega ótima (força bruta, O(n!)) |
| `AplicadorDesconto` | Regras de desconto por tipo de cliente/valor/categoria (RN01–RN04, documentadas no Javadoc da classe) |
| `PedidoService` | Orquestra validação, reserva de estoque, frete e desconto; lança `PedidoInvalidoException` |

Leia com atenção o Javadoc de `AplicadorDesconto` e `PedidoService` --
as regras de negócio descritas lá são a base para os dados de teste
que vocês vão construir.

Uma classe `ExemploEstiloTest` é fornecida **apenas como referência de
estilo** (uso de `@Before`, comparação de `double` com margem de erro). 

## 3. O que deve ser entregue

Você deve criar as classes de teste necessárias para cobrir, **todas
sobre o mesmo sistema AgroCoop**, os sete recursos de JUnit4 vistos em
aula. Cada requisito abaixo indica *o que* testar -- a forma exata (nomes
de métodos, organização em quantas classes) é decisão sua, desde que
os requisitos sejam atendidos.

### R1 -- Casos de teste simples (`@Test`)
Escreva casos de teste simples para `CalculadoraFrete.calcularFrete`
(pelo menos um caso por região: `"DF"`, `"GO"`, `"OUTROS"`) e para
`Estoque` (reposição e consulta de quantidade no caminho feliz).

### R2 -- Suíte de testes
Crie uma classe `RegrasNegocioSuite`, usando `@RunWith(Suite.class)` e
`@Suite.SuiteClasses(...)`, agrupando **todas** as classes de teste que
você criar para `Estoque`, `CalculadoraFrete`, `AplicadorDesconto` e
`PedidoService`.

### R3 -- Testes de exceção
Teste os dois caminhos de erro do sistema:
- `Estoque.reservar` deve lançar `EstoqueInsuficienteException` quando a
  quantidade solicitada excede a disponível;
- `PedidoService.processar` deve lançar `PedidoInvalidoException` para
  um pedido sem itens **e** para um pedido sem cliente.

Implemente esses casos de teste com `@Test(expected = ...)`.

### R4 -- Teste com timeout
`CalculadoraFrete.calcularRotaMaisEconomica` é, de propósito,
implementado por força bruta (O(n!)) -- leia o comentário Javadoc do
método para entender por quê isso é aceitável no contexto da AgroCoop.
Escreva um teste com `@Test(timeout = ...)` que comprove que, para uma
rota com **até 7 pontos de entrega**, o método responde dentro de um
limite de tempo aceitável (justifique o valor escolhido em um
comentário).

### R5 -- Categorias de teste
Marque o teste de timeout do item R4 com `@Category(TestesLentos.class)`
e os testes simples "puros" (sem laços custosos) com
`@Category(TestesRapidos.class)`. As interfaces marcadoras já estão
prontas no pacote `com.agromart.categorias`. Crie uma segunda suíte,
`TestesRapidosSuite`, usando `@RunWith(Categories.class)` com
`@IncludeCategory(TestesRapidos.class)`, que execute somente os testes
rápidos do projeto.

### R6 -- Teste ignorado
O método `PedidoService.processarComFreteGratisAtacado` ainda não foi
implementado (ver `TODO` no código-fonte). Escreva o teste que
**deveria** validar essa regra quando ela for implementada, mas marque-o
com `@Ignore("motivo")`, explicando no motivo por que ele está
desabilitado.

### R7 -- Teste parametrizado com tuplas de tipos mistos
Crie uma classe `AplicadorDescontoParameterizedTest` com
`@RunWith(Parameterized.class)`. O método anotado com
`@Parameterized.Parameters` deve retornar um `Collection<Object[]>` em
que **cada tupla combina valores de tipos diferentes**, cobrindo as
regras RN01–RN04 do Javadoc de `AplicadorDesconto`:

```java
// Exemplo de assinatura de uma tupla (tipos misturados de propósito):
// { TipoCliente tipoCliente, double valorTotalPedido, String categoriaProduto,
//   double percentualEsperado, boolean elegivelEsperado }
```

Inclua **pelo menos 6 tuplas**, cobrindo: cooperado abaixo e acima do
limite, atacado nas três faixas de desconto, varejo elegível e não
elegível, e ao menos um caso com categoria `"INSUMOS"` (que nunca tem
desconto, mesmo para um cliente que teria direito).

Com os campos injetados pelo construtor da classe parametrizada,
implemente **pelo menos 3 métodos `@Test` distintos** que reaproveitem
a mesma tupla, por exemplo:
1. um teste que verifica `calcularPercentualDesconto`;
2. um teste que verifica `isElegivelParaDesconto`;
3. um teste que verifica `calcularValorComDesconto` (valor final do
   pedido após aplicar o desconto esperado).


## 4. Dicas

- Rode `mvn test` (ou o comando equivalente configurado em sua IDE) e
  observe no relatório quais testes foram *skipped* (ignorados) e
  quais falharam -- isso ajuda a verificar se `@Ignore` e `@Category`
  foram usados corretamente.
- Para R4, comece testando localmente quanto tempo o método leva com 7
  pontos antes de escolher o valor do `timeout`, para não escrever um
  limite irreal.
- Releia o Javadoc de `AplicadorDesconto` antes de montar as tuplas do
  R7 -- todas as regras de negócio que sua tabela de dados precisa
  cobrir já estão descritas ali.
