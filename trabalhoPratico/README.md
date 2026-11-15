#### UnB - Universidade de Brasilia
#### FCTE - Faculdade de Ciencia e Tecnologia em Engenharias
#### FGA-0242 - Tecnicas de Programacao para Plataformas Emergentes
---

# 1. O desafio

Você e seus colegas herdaram um sistema **legado** de compras coletivas de
supermercado. Ele foi escrito às pressas, não tem nenhum teste e **"funciona na
maioria dos casos"**. Na prática, ele erra contas, aceita lixo, quebra com
mercados que falham e é vulnerável a ataques.

A missão do grupo é transformá-lo em um sistema **correto, testado, bem
estruturado e defensivo**, aplicando de forma deliberada o que foi visto na
disciplina:

* **TDD** (testes primeiro, ciclo vermelho - verde - refatora);
* **Refatoração** (catálogo de *code smells* e refatorações, em passos pequenos,
  sempre com testes verdes);
* **Programação defensiva** (barricada, fail fast, pré-condições, asserções,
  exceções com contexto, cópias defensivas, `try-with-resources`, injeção de
  SQL, sanitização, logging).


# 2. Regras do trabalho

| Item | Definição |
|---|---|
| Grupos | **8 alunos** por grupo |
| Entrega | **6 de dezembro de 2026, 23h59**, no repositório Git do grupo (link e convite deverão ser enviados ao professor) |
| Apresentação ao vivo | Data e horário definidos pelo professor, com todos os integrantes presentes |
| Linguagem | **Java 17**, somente |
| Bibliotecas permitidas | JDK, **H2 2.3.232** e **JUnit 4.13.2**.  Nenhuma outra é permitida (ex. Lombok, Mockito etc.) |
| Nota do trabalho | **50% execução da suíte oculta de testes** + **50% apresentação e defesa oral** |

**Sobre o uso de ferramentas de apoio:** a defesa oral é feita sobre o código
entregue. Quem não souber explicar uma linha do próprio repositório perde
pontos junto com o grupo, qualquer que seja a origem dessa linha. Portanto, o
grupo deve se apropriar do código. 

# 3. Como serão calculadas as notas

## 3.1 Suíte oculta (50%)

Existem **10 testes automatizados que vocês não verão**, valendo **10 pontos
cada** (100 pontos, depois convertidos para 50% da nota). A correção é binária.

* A suíte testa **somente o que está escrito neste documento** (as regras RN-01
  a RN-12 e o contrato da seção 5). Nenhuma exigência está escondida: o que está
  escondido são os **casos de teste**, e eles incluem entradas hostis.
* Ela usa apenas a **API pública congelada** (seção 5). **Se você renomear ou
  mudar a assinatura de qualquer item do contrato, a suíte não compila e a nota
  de testes é ZERO.** Por isso o repositório traz o `ContratoApiTest`: rode-o a
  cada commit.
* Ela é executada com **asserções habilitadas** (`-ea`) e com a configuração
  padrão de logging do JDK.
* Cada teste tem um limite de tempo; laços infinitos reprovam.

## 3.2 Apresentação e defesa oral (50%)

Máximo de 20 minutos por grupo. Todos os integrantes devem estar presentes e
**qualquer um pode ser chamado a responder**. Formato:

1. **Apresentação (até 13 min):** arquitetura antes e depois, principais
   decisões, como o grupo trabalhou.
2. **Perguntas dirigidas (cerca de 5 min):** o professor aponta trechos do seu
   código e pergunta o porquê. Exemplos do tipo de pergunta: "Que *code smell*
   era este e qual refatoração você aplicou?", "Isso é validação, pré-condição,
   asserção ou tratamento de exceção? Por quê?", "Mostre o teste que prova que esta
   defesa funciona", "O que acontece aqui se eu trocar *X* por *Y*?".

A rubrica completa da defesa está na seção 9.

# 4. O sistema

Várias pessoas enviam suas **listas de compras** ao sistema. Ao **fechar uma
rodada**, o sistema:

1. **agrupa** todas as listas em um único **lote** (soma das quantidades por
   produto);
2. pede **cotação** do lote inteiro a **vários mercados** (quanto maior a
   quantidade, menor o preço unitário: o desconto é aplicado pelo próprio
   mercado);
3. escolhe o mercado com **menor preço total da venda** (itens + frete);
4. **compra** o lote nesse mercado;
5. **fraciona** os itens comprados entre os compradores, gerando um **pedido**
   por comprador;
6. **persiste** os pedidos em banco de dados (H2 em memória).

```
 listas -> agrupa -> lote -> cotacao (N mercados) -> vencedor -> compra
                                                                  |
 pedidos persistidos <- fraciona entre os compradores <-----------+
```

Os **mercados são sistemas externos e não são confiáveis**: podem sair do ar,
demorar, devolver preços absurdos, devolver lixo, ou até tentar alterar os dados
que recebem.

# 5. O contrato (API congelada)

Estas classes e métodos **públicos** são a fronteira com o mundo exterior e
**não podem mudar**. Tudo o que está *dentro* deles é livre: você pode (e deve)
reorganizar, criar classes, interfaces, tipos, pacotes auxiliares etc., desde
que o contrato permaneça.

Pacote **`supercompras`**:

```java
public interface Mercado {
    String nome();
    Map<String, BigDecimal> cotarPrecosUnitarios(Map<String, Integer> itens)
            throws MercadoIndisponivelException;
    BigDecimal frete(Map<String, Integer> itens) throws MercadoIndisponivelException;
    String comprar(Map<String, Integer> itens, Map<String, BigDecimal> precosUnitarios)
            throws MercadoIndisponivelException;
}

public interface PedidoRepositorio {
    void salvar(Pedido pedido);
    List<Pedido> buscarPorComprador(String compradorId);
}

public class PedidoRepositorioJdbc implements PedidoRepositorio {
    public PedidoRepositorioJdbc(java.sql.Connection conexao)   // cria o esquema no construtor
}

public class SistemaCompras {
    public SistemaCompras(List<Mercado> mercados, PedidoRepositorio repositorio)
    public void receberLista(String compradorId, Map<String, Integer> itens)
    public ResultadoRodada fecharRodada()
}

public class ResultadoRodada {     // apenas estes métodos são do contrato
    String getMercadoVencedor();  String getProtocolo();
    BigDecimal getTotalLote();    List<Pedido> getPedidos();
}

public class Pedido {              // apenas estes métodos são do contrato
    String getId();  String getCompradorId();  String getMercado();  String getProtocolo();
    Map<String, Integer> getItens();  Map<String, BigDecimal> getValoresPorSku();
    BigDecimal getSubtotal();  BigDecimal getFrete();  BigDecimal getTotal();
}
```


Exceções (todas com os construtores indicados):

| Exceção | Tipo | Construtores |
|---|---|---|
| `MercadoIndisponivelException` | **checada** | `(String)` e `(String, Throwable)` |
| `EntradaInvalidaException` | não checada | `(String)` |
| `SemCotacaoValidaException` | não checada | `(String)` |
| `CompraNaoRealizadaException` | não checada | `(String)` |
| `PersistenciaException` | não checada | `(String, Throwable)` |

Observações:

* **`Pedido` e `ResultadoRodada` só precisam ter os métodos acima.** Podem ser
  classes comuns, imutáveis, `record` com métodos extras etc. A suíte oculta
nunca os constrói: só lê.
* A interface `Mercado` e as exceções foram entregues prontas. **Não as
  altere.**
* "Comprador" é identificado por texto (`compradorId`); "produto" por um código
  (**SKU**).

# 6. Regras de negócio

Leia cada regra com "lupa". A suíte oculta cobra exatamente isto.

## RN-01 · Identificador de comprador

Formato obrigatório: de **3 a 30** caracteres, apenas **letras minúsculas ASCII,
dígitos ASCII, `_`, `.` e `-`**, começando por letra minúscula ou dígito
(expressão regular `[a-z0-9][a-z0-9_.-]{2,29}`, casando o texto **inteiro**).
Qualquer outra coisa (nulo, vazio, espaços, acentos, maiúsculas, quebras de
linha, dígitos de outros alfabetos etc.) é inválida.

## RN-02 · Lista de compras

* A lista é um `Map<String,Integer>`: **SKU → quantidade**.
* **SKU:** três letras maiúsculas ASCII, hífen e quatro dígitos ASCII (ex.:
  `LEI-0001`), casando o texto **inteiro**.
* **Quantidade:** de **1 a 999**.
* A lista deve ter de **1 a 20** itens. Mapa nulo, chave nula ou valor nulo são
  inválidos.
* Cada comprador pode enviar **uma única lista por rodada**; uma segunda lista
  do mesmo comprador na mesma rodada é inválida.
* Entrada inválida lança `EntradaInvalidaException` e **não deixa nenhum
  rastro**: o sistema fica exatamente como estava (inclusive o identificador do
  comprador continua livre).
* **A mensagem da exceção não pode conter o valor rejeitado** (identificador ou
  SKU): ele pode ser um ataque ou um dado sensível. Use mensagens genéricas.
* **A rejeição é registrada em log** com `java.util.logging` (nível `WARNING` ou
  superior), em **uma única linha** e **sem repetir a entrada bruta**. Logging
  por `java.util.logging` é obrigatório: é por ele que a suíte observa os
  registros (ela anexa um *handler* ao logger raiz). `System.out` e `System.err`
  não são logging.
* O mapa recebido **não é confiável**: o chamador pode alterá-lo depois
  (inclusive em outra *thread*) ou ele pode ter uma implementação maliciosa.
  Garanta que **o que foi validado é exatamente o que foi guardado**.

## RN-03 · Lote

O lote é a soma, por SKU, das quantidades de todas as listas pendentes. O lote é
entregue aos mercados como um **mapa imutável** (qualquer tentativa de alteração
lança `UnsupportedOperationException`).

## RN-04 · Cotação (mercado é sistema externo)

O sistema chama, para cada mercado, `cotarPrecosUnitarios(lote)` e depois
`frete(lote)`. A cotação é **válida** somente se **todas** as condições abaixo
forem verdadeiras; caso contrário o mercado é **desqualificado** (e o fato é
registrado em log, em uma linha):

1. `nome()` não é nulo nem em branco;
2. nenhuma chamada lançou `MercadoIndisponivelException` ou qualquer
   `RuntimeException`. **`Error` jamais é capturado** (problema da JVM não é
   "mercado ruim"): deve propagar;
3. o mapa de preços não é nulo e contém, **para cada SKU do lote**, um preço
   **não nulo e ≥ 0,01**. A ausência de um SKU significa "não temos o item".
   Chaves extras são ignoradas. O preço pode ter qualquer número de casas
   decimais;
4. o frete não é nulo e é **≥ 0** (zero é permitido).

Os preços valem **no instante em que o mercado os devolve**: o sistema guarda
uma cópia imediata, e alterações posteriores feitas pelo mercado no próprio mapa
não têm efeito.

## RN-05 · Total de um mercado

```
total = Σ por SKU de arredondar(preço × quantidade do lote)  +  arredondar(frete)
arredondar(x) = x com 2 casas decimais, RoundingMode.HALF_EVEN
```

O arredondamento é feito **linha a linha** (por SKU), não sobre a soma. **Vence
o mercado de menor total.**

## RN-06 · Desempate

Em caso de empate no total (já arredondado), vence o mercado de **menor
`nome()`** (comparação `String.compareTo`). A ordem em que os mercados foram
informados não importa.

## RN-07 · Fracionamento entre os compradores

Cada comprador recebe **exatamente** o que pediu, ao preço do lote. Para não
criar nem perder centavos, use o **método do maior resto** (veja o exemplo no
apêndice):

1. **Valor de cada SKU.** A linha do lote do SKU (`arredondar(preço × quantidade
   do lote)`, em centavos) é repartida entre os compradores **proporcionalmente
   à quantidade** que cada um pediu desse SKU.
2. **Subtotal** do comprador = soma dos seus valores por SKU.
3. **Frete.** O frete do mercado vencedor (em centavos) é repartido
   **proporcionalmente ao subtotal** de cada comprador.
4. **Total** do pedido = subtotal + frete.

**Algoritmo de repartição** de `T` centavos com pesos `p_i` (soma `S`):

* parte inteira de cada um: `floor(T × p_i / S)`; resto: `(T × p_i) mod S`;
* os centavos que sobrarem (`T − Σ parte inteira`) são entregues **um a um**,
  começando por quem tem **maior resto**; em caso de **empate de resto**, o de
  **menor identificador de comprador** (ordem alfabética) é atendido primeiro.

Consequência obrigatória: a soma dos totais dos pedidos é **exatamente** o
`totalLote`, e a soma dos valores de cada SKU é exatamente a linha do lote desse
SKU.

## RN-08 · Compra e *fail-over*

Percorra as cotações válidas **da menor para a maior** (RN-05/RN-06) e chame
`comprar(lote, preços)`:

* a compra **falha** se o mercado lançar `MercadoIndisponivelException` ou
  qualquer `RuntimeException`, ou se devolver protocolo **nulo ou em branco**;
* na **primeira** compra bem-sucedida, pare: **nunca compre de dois mercados**,
  e **nunca tente o mesmo mercado duas vezes**;
* `Error` propaga;
* `lote` e `preços` entregues a `comprar` são **imutáveis**; `preços` contém os
  preços copiados (RN-04), somente dos SKUs do lote;
* se **nenhum** mercado tiver cotação válida: `SemCotacaoValidaException`;
* se houver cotação válida mas **nenhuma compra** for aceita:
  `CompraNaoRealizadaException`;
* nos dois casos de falha **as listas continuam pendentes**, e uma nova chamada
  a `fecharRodada()` pode ser tentada.

## RN-09 · Valores e formato do resultado

* **Todo valor monetário** exposto é `BigDecimal` com **escala exatamente 2**.
  Nunca use `double` ou `float` para dinheiro.
* `Pedido.getId()` é `protocolo + "-" + compradorId`.
* `getItens()`: SKU → quantidade pedida. `getValoresPorSku()`: SKU → valor
  (RN-07). `getSubtotal()` = soma dos valores. `getFrete()`: parte do frete.
  `getTotal()` = subtotal + frete.
* `ResultadoRodada.getTotalLote()` é o total do mercado vencedor (RN-05).
* `ResultadoRodada.getPedidos()` vem **ordenada por identificador de comprador**
  (crescente).

## RN-10 · Encerramento da rodada e falhas de persistência

* Com a compra confirmada, a rodada se **encerra**: as listas são consumidas.
  Chamar `fecharRodada()` **sem listas pendentes** (inclusive logo depois de uma
  rodada bem-sucedida) lança `IllegalStateException`.
* Os pedidos são entregues ao repositório um a um, em ordem crescente de
  comprador. **A falha de um pedido não impede o salvamento dos demais.**
* Se algum pedido falhar, ao final lança-se `PersistenciaException` cuja
  **mensagem contém o protocolo e o nome do mercado** da compra já confirmada
  (para que alguém possa reconciliar). A **causa** é a primeira falha original;
  as demais ficam como exceções *suprimidas*.

## RN-11 · Segurança e logs

* Todo acesso ao banco usa **consultas parametrizadas**. Dados nunca são
  concatenados ao SQL.
* Os dados são gravados e lidos **literalmente**: o nome de um mercado pode
  conter aspas, ponto e vírgula e até comandos SQL, e deve voltar idêntico.
* `buscarPorComprador(id)` com `id` fora do formato RN-01 devolve **lista vazia
  ou lança `EntradaInvalidaException`**. Em nenhuma hipótese devolve pedidos de
  outras pessoas nem altera o banco.
* **Logs** (`java.util.logging`): nunca registre a entrada bruta do usuário;
  nunca permita quebra de linha dentro de uma mensagem de log (*log injection*).
  Valores vindos de sistemas externos (por exemplo, o nome de um mercado) também
  não são confiáveis.

## RN-12 · Robustez e imutabilidade

* Os objetos devolvidos (`getPedidos()`, `getItens()`, `getValoresPorSku()`)
  **não podem ser alterados** por quem os recebe
  (`UnsupportedOperationException`).
* `PedidoRepositorioJdbc`:
  * **não é dono da conexão**: nunca a fecha;
  * `salvar` grava pedido e itens em **uma transação** e devolve a conexão ao
    modo de *autocommit* em que a encontrou, **inclusive quando falha**;
  * toda falha SQL vira `PersistenciaException` com a `SQLException` como
    **causa**; nada é engolido;
  * **todo recurso JDBC** (`Statement`, `PreparedStatement`, `ResultSet`) é
    fechado em qualquer caminho, inclusive o de falha;
  * o construtor cria o esquema se ele não existir.

# 7. O que o grupo deve fazer

O trabalho tem quatro frentes que se sobrepõem. Planeje o grupo para que
**todos** participem de **todas** (a defesa cobrará isso).

**A. Rede de segurança e entendimento do legado.** Faça o projeto compilar e
rodar (seção 10). Estude o código e escreva **testes de caracterização**: testes
que registram o que o legado faz **hoje** (mesmo quando está errado) para que
você refatore sem medo. Registre os *code smells* encontrados.

**B. Refatoração estrutural.** Reorganize o código em passos pequenos, **com
testes verdes entre os passos**, nomeando cada refatoração usada. Espere
encontrar, entre outros: método longo, números e textos mágicos, uso de `double`
para dinheiro, obsessão por primitivos, campos públicos, estado estático, código
duplicado, comentários que mentem, `null` como sinal, exposição de estruturas
internas e responsabilidades misturadas. **Você precisa saber nomear e
justificar cada um.**

**C. TDD das regras.** O legado **descumpre** várias regras da seção 6. Para
cada regra: escreva **primeiro** o teste que falha (vermelho), faça passar com o
mínimo (verde), depois refatore. O histórico do Git deve mostrar isso.

**D. Blindagem.** Aplique e **teste** as técnicas defensivas: barricada na
fronteira, fail fast, pré-condições, asserções (onde fazem sentido), exceções
com contexto, cópias defensivas, imutabilidade, tipos fortes,
`try-with-resources`, consultas parametrizadas, mensagens e logs seguros. **Para
cada defesa importante, escreva um teste que a ataca** (entrada maliciosa,
mercado hostil, falha de banco).

Dicas honestas:

* Você mesmo precisa escrever **dublês** (mercados falsos e repositório em
  memória) para testar sem rede e sem banco real. Faça-os bons: eles serão a
  base de todos os seus testes.
* O H2 em memória é ótimo para testar o repositório JDBC de verdade
  (`jdbc:h2:mem:nome;DB_CLOSE_DELAY=-1`).
* Os mercados fazem coisas desagradáveis. Pense como um atacante e como um
  colega descuidado.

# 8. Entregáveis e evidências

**Repositório Git** do grupo, com a estrutura:

```
src/main/java/supercompras/...     código (o contrato + o que o grupo criar)
src/test/java/supercompras/...     testes do grupo (mantenha o ContratoApiTest)
libs/LEIAME.txt                    (não versionar os .jar)
RELATORIO.md                       relatório (modelo em RELATORIO-modelo.md)
```

**Regras de processo**, que valem como evidência na defesa:

* **Histórico real:** nada de um único commit gigante. O professor lerá o `git
  log`.
* **Todos commitam:** cada integrante com **autoria própria** em commits
  relevantes (programação em par é bem-vinda; use `Co-authored-by`).
* **Mensagens padronizadas:** `test:` (teste novo), `feat:`/`fix:`
  (comportamento), `refactor:` (sem mudar comportamento), `docs:`.
* **Ciclo TDD visível:** para cada regra RN, deve existir um commit `test:`
  **anterior** ao commit que a implementa.
* **Refatoração segura:** commits `refactor:` não alteram testes (a não ser para
  acompanhar uma renomeação).

**RELATORIO.md** (use o modelo): para cada refatoração e para cada técnica
defensiva, onde foi aplicada, por quê, qual teste a protege e o hash do commit.
É o seu "roteiro" para a defesa, mas **ele não substitui o conhecimento de cada
um**.

# 9. Rubrica pública da defesa oral (50 pontos)

| Dimensão | Pontos | O que se espera |
|---|---:|---|
| **Refatoração** | 20 | Nomeia e identifica corretamente os *smells*; escolhe a refatoração adequada; explica por que o comportamento foi preservado (testes de caracterização, passos pequenos); mostra o antes e o depois com critério |
| **Programação defensiva** | 20 | Distingue validação, pré-condição, asserção e exceção; explica barricada, cópia defensiva, `try-with-resources`, injeção, sanitização e logging; sabe **quando não** aplicar (excesso) e quanto cada defesa custa; mostra o teste que ataca cada defesa |
| **TDD e processo** | 10 | Histórico com ciclo vermelho-verde-refatora; testes bem nomeados e independentes; **alteração ao vivo** feita com o teste primeiro |

Critérios transversais: clareza, honestidade ("não sei" é melhor que inventar),
domínio **individual** do código de todo o grupo, e capacidade de apontar
limitações do próprio trabalho.

# 10. Como compilar e testar

1. Baixe os três `.jar` listados em `libs/LEIAME.txt` e coloque-os em `libs/`.
2. Em Linux ou  macOS:

```
./build.sh      # compila main e test (Java 17)
./test.sh       # compila e roda todos os testes *Test (com -ea)
```

3. Em Windows nativo, use o equivalente manual (troque `:` por `;` no classpath):

```
javac --release 17 -encoding UTF-8 -d out\main src\main\java\supercompras\*.java
javac --release 17 -encoding UTF-8 -d out\test -cp "out\main;libs\*" src\test\java\supercompras\*.java
java -ea -cp "out\main;out\test;libs\*" org.junit.runner.JUnitCore supercompras.ContratoApiTest
```

Você pode usar Maven ou Gradle, se preferir, **desde que** mantenha
`src/main/java`, `src/test/java`, o pacote `supercompras` e as versões das
bibliotecas.

# 11. Cronograma sugerido (não avaliado, mas recomendado)

| Data | Marco |
|---|---|
| 18/11 | Repositório criado, build funcionando, primeiros **testes de caracterização** do legado, lista de *smells* |
| 25/11 | Refatoração estrutural avançada com testes verdes; TDD das primeiras regras (RN-01 a RN-05) |
| 02/12 | Todas as RN com testes; blindagem e testes de ataque; rascunho do relatório |
| 06/12 | **Entrega** |

# Apêndice · Exemplo do método do maior resto

Repartir **R$ 10,00** (1000 centavos) de uma linha do lote entre três
compradores que pediram, respectivamente, **1**, **2** e **4** unidades (peso
total 7). Identificadores: `ana`, `bia`, `caio`.

| Comprador | Peso | 1000 × peso | Parte inteira (÷ 7) | Resto |
|---|---:|---:|---:|---:|
| ana | 1 | 1000 | 142 | 6 |
| bia | 2 | 2000 | 285 | 5 |
| caio | 4 | 4000 | 571 | 3 |

Soma das partes inteiras: 998. **Sobram 2 centavos**: vão para os de maior
resto, `ana` (6) e `bia` (5).

Resultado: **ana R$ 1,43 · bia R$ 2,86 · caio R$ 5,71**, somando exatamente R$
10,00.

Se `ana` e `bia` tivessem o **mesmo** resto, o centavo iria primeiro para `ana`
(menor identificador, em ordem alfabética).

O frete é repartido com **o mesmo algoritmo**, usando o subtotal de cada
comprador como peso.
