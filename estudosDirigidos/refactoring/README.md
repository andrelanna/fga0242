
UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

### Estudo dirigido - Refatoração 
---

### Orientações

- Responda com suas palavras e **sempre justifique**. Nas questões de código,
  cite o trecho em que você se baseia (o método, a expressão, o campo).
- Ao nomear refatorações, use os nomes do catálogo visto em aula (quadro
  abaixo).
- Ao falar de princípios de projeto, diga qual é o princípio (quadro abaixo) e
  **por que** ele deixou de ser atendido naquele código.
- Em "antes e depois", o comportamento observável do programa é o que importa:
  compare o que o código **faz**, não só como ele está escrito.

**Princípios de projeto**

| Princípio | Em poucas palavras |
|----------------|----------------------------------------|
| Responsabilidade única (SRP) | Uma classe (ou um método) deve ter **uma única razão para mudar**: cuida de uma responsabilidade bem definida. |
| Aberto/Fechado (OCP) | O código deve estar **aberto para extensão** e **fechado para modificação**: acrescentar um novo caso deve exigir código novo, e não edição de código que já funciona. |
| Encapsulamento (ocultação de informação) | Os dados de uma classe ficam escondidos atrás de sua interface; só a própria classe decide como eles são lidos e alterados, e assim protege suas regras. |
| DRY (não se repita) | Cada conhecimento ou regra deve ter **uma única representação** no código; repeti-la obriga a alterá-la em vários lugares. |
| Alta coesão e baixo acoplamento | Os elementos de um módulo devem estar **fortemente relacionados** entre si (coesão), e os módulos devem **depender pouco** uns dos outros (acoplamento). Comportamento fica junto dos dados que usa. |

**Catálogo de refatorações (slides dos grupos 1 a 4)**

| Grupo | Refatorações |
|--------|------------------------|
| 1 -- Composição de Métodos | Extract Method (Extrair Método), Extract Variable (Extrair Variável), Split Temporary Variable (Dividir Variável) |
| 2 -- Movendo Recursos entre Objetos | Move Method (Mover Método), Move Field (Mover Campo), Extract Class (Extrair Classe), Introduce Foreign Method (Método Estrangeiro) |
| 3 -- Organizando Dados | Encapsular Campo, Substituir Array por Objeto, Substituir Tipo Código por Classes, Trocar Associação Bidirecional por Unidirecional |
| 4 -- Simplificando Expressões Condicionais | Consolidar Expressão Condicional, Substituir Condicionais Aninhadas por Cláusulas-Guarda, Substituir Condicional por Polimorfismo |

---
### Parte 1 -- Questões conceituais

###### Questão 1

a) Defina refatoração com suas palavras. O que **necessariamente** permanece
igual depois de uma refatoração, e o que pode mudar?

b) Defina mau-cheiro de código. Um mau-cheiro é um defeito (um *bug*)?
Justifique.

c) Para cada alteração abaixo, diga se ela é uma refatoração e justifique em uma
ou duas frases.

   1. Renomear o método `calc()` para `calcularTotal()`, atualizando todas as
      chamadas.
   2. Corrigir o cálculo de desconto, que aplicava 5% quando a regra de negócio
      diz 10%.
   3. Acrescentar uma nova forma de pagamento (por exemplo, Pix).
   4. Extrair um trecho de 8 linhas de um método para um novo método privado,
      sem alterar o que o método faz.

###### Questão 2

a) Explique a metáfora dos dois chapéus (desenvolvedor de funcionalidades e
refatorador): o que se faz, e o que **não** se faz, com cada chapéu? Por que não
é recomendável vestir os dois ao mesmo tempo?

b) Marina vai acrescentar uma nova regra de negócio a um método existente. Ela
faz o seguinte, nesta ordem:

   1. Roda a suíte de testes: tudo passa.
   2. Percebe que o método tem 70 linhas e dificulta o acréscimo da regra.
      Extrai um trecho para um método próprio e, "já que estava ali", corrige um
      defeito nesse trecho: um arredondamento que estava truncando os centavos.
   3. Escreve um teste para a nova regra (o teste falha) e implementa a regra
      até ele passar.
   4. Renomeia uma variável de nome pouco claro (`x2`) para um nome que expressa
      seu significado e roda os testes de novo.

   Para cada passo, diga qual chapéu Marina está usando e justifique. Em qual
passo ela misturou os chapéus? O que ela deveria ter feito?

c) Explique a "regra dos três" para decidir quando refatorar e dê um exemplo de
situação em que vale a pena refatorar **antes** de acrescentar uma
funcionalidade.


###### Questão 3


a) Complete a tabela. Para cada mau-cheiro, indique o princípio de projeto que
ele sugere não estar sendo atendido, **justifique** em uma ou duas frases e
indique uma refatoração do catálogo que o trata.

| Mau-cheiro | Princípio sugerido | Justificativa | Refatoração |
|--------|---------|--------------|----------|
| Long Method | | | |
| Switch/if em cadeia repetido por tipo | | | |
| Campo público | | | |
| Classe que faz demais | | | |
| Feature Envy | | | |
| Duplicação (mesma expressão em vários pontos) | | | |

b) Escolha **uma** linha da tabela e conte a "história de manutenção": qual é a
causa (princípio), qual é o sintoma (mau-cheiro) e qual é o tratamento
(refatoração)? 

c) Por que se diz que um mau-cheiro é um **indício**, e não uma prova, de
projeto ruim? Dê um exemplo de mau-cheiro que, em um certo contexto, **não**
justifica refatoração e diga que informação do contexto mudaria a sua decisão.

###### Questão 4


Para cada caso, conclua se a equipe deve **refatorar agora**, **refatorar com
cuidados específicos** ou **não refatorar agora**, e justifique.

**Caso A -- interfaces públicas e publicadas.** Uma equipe mantém dois módulos
que oferecem o método público `calcular(...)`: o módulo `core`, usado apenas por
projetos da própria equipe, no mesmo repositório; e a biblioteca `api.jar`,
baixada por dezenas de equipes de outras empresas. Em ambos, o método será
renomeado para `calcularTotal(...)`.

   1. Diferencie interface **pública** de interface **publicada**.
   2. Classifique os dois módulos.
   3. Como a renomeação deve ser conduzida em cada um?

**Caso B -- refatoração e desempenho.** Um colega recusa extrair um método do
laço que processa 50 mil registros, "porque chamadas de método deixam o código
mais lento". Avalie o argumento. A refatoração pode piorar o desempenho? O que a
equipe deve fazer? Existe contexto em que o desempenho deveria pesar mais?

**Caso C -- refatoração e banco de dados.** A equipe quer aplicar Extract Class
em `Cliente`, movendo os campos de endereço para uma classe `Endereco`, e
dividir também a tabela `cliente` em duas (`cliente` e `endereco`), já com dados
em produção e relatórios de outros sistemas lendo a tabela. Por que refatorar o
banco é mais difícil do que refatorar o código? Que cuidados a equipe precisa
tomar?

**Caso D -- quando não refatorar.** (1) Um módulo tem tantos defeitos que "quase
nada funciona como deveria". (2) Outro módulo funciona, mas não tem nenhum teste
automatizado, e a entrega é amanhã. Discuta cada situação.

### Parte 2 -- Questões de código

###### Questão 5

**Tarefa:** identificar o mau-cheiro e o princípio não atendido.

Considere as classes abaixo.

**Produtor.java**

```java
public class Produtor {
    public String nome;
    public String cpf;
    public double saldoAReceber;
}
```

**FechamentoMensal.java**

```java
public class FechamentoMensal {

    public void creditarVenda(Produtor produtor, double valorLiquido) {
        produtor.saldoAReceber = produtor.saldoAReceber + valorLiquido;
    }

    public void registrarPagamento(Produtor produtor, double valorPago) {
        produtor.saldoAReceber = produtor.saldoAReceber - valorPago;
    }
}
```

**ExtratoProdutor.java**

```java
public class ExtratoProdutor {

    public String linha(Produtor produtor) {
        return produtor.nome + " - saldo a receber: R$ " + produtor.saldoAReceber;
    }
}
```

a) Qual é o principal mau-cheiro presente? Justifique citando trechos do código.

b) Que princípio de projeto não foi atendido? Justifique com um cenário: a
cooperativa decide que o `saldoAReceber` **nunca** pode ficar negativo. Em
quantos pontos do código essa regra teria de ser implementada hoje, e o que
impede um novo desenvolvedor de burlá-la?

c) Qual refatoração do catálogo trata o problema? Descreva o primeiro passo da
sua aplicação.

###### Questão 6

**Tarefa:** comparar antes e depois e identificar a refatoração.

**Antes**

```java
import java.util.List;

public class RelatorioColheita {

    // cada linha: {produto, quantidade em kg, preço por kg}
    public double totalGeral(List<String[]> colheitas) {
        double total = 0;
        for (String[] c : colheitas) {
            total += Double.parseDouble(c[1]) * Double.parseDouble(c[2]);
        }
        return total;
    }

    public String maiorColheita(List<String[]> colheitas) {
        String nome = null;
        double maior = 0;
        for (String[] c : colheitas) {
            double valor = Double.parseDouble(c[1]) * Double.parseDouble(c[2]);
            if (valor > maior) {
                maior = valor;
                nome = c[0];
            }
        }
        return nome;
    }
}
```

**Depois**

**Colheita.java**

```java
public class Colheita {
    private final String produto;
    private final double quantidadeKg;
    private final double precoPorKg;

    public Colheita(String produto, double quantidadeKg, double precoPorKg) {
        this.produto = produto;
        this.quantidadeKg = quantidadeKg;
        this.precoPorKg = precoPorKg;
    }

    public String getProduto() {
        return produto;
    }

    public double valorTotal() {
        return quantidadeKg * precoPorKg;
    }
}
```

**RelatorioColheita.java**

```java
import java.util.List;

public class RelatorioColheita {

    public double totalGeral(List<Colheita> colheitas) {
        double total = 0;
        for (Colheita c : colheitas) {
            total += c.valorTotal();
        }
        return total;
    }

    public String maiorColheita(List<Colheita> colheitas) {
        String nome = null;
        double maior = 0;
        for (Colheita c : colheitas) {
            if (c.valorTotal() > maior) {
                maior = c.valorTotal();
                nome = c.getProduto();
            }
        }
        return nome;
    }
}
```

a) Qual refatoração do catálogo foi aplicada? Justifique com **pelo menos três**
evidências retiradas dos dois códigos.

b) No "antes", o cálculo `quantidade × preço` aparecia duas vezes. Onde ele está
agora? Que outra operação de refatoração (mais simples) o código "depois" também
exibe?

c) No "antes", dê um exemplo de entrada que o compilador aceita, mas que quebra
o programa em tempo de execução. Por que isso deixa de ser possível no "depois"?

###### Questão 7

**Tarefa:** identificar maus-cheiros, justificar, relacionar a princípios e
escolher refatorações.

Considere o método abaixo. Presuma que `Produtor` tem `isAtivo()` e que `Venda`
tem `getQuantidade()` e `getPrecoUnitario()`.

```java
import java.util.List;

public class CalculadoraRepasse {

    public double calcularRepasse(Produtor p, List<Venda> vendas, boolean temDap) {
        double valor = 0;
        for (Venda v : vendas) {
            valor += v.getQuantidade() * v.getPrecoUnitario();
        }
        // desconta a taxa da cooperativa
        valor = valor - valor * 0.08;
        double resultado;
        if (p != null) {
            if (p.isAtivo()) {
                if (valor > 0) {
                    resultado = valor;
                    // bônus para produtor com DAP e volume alto de vendas
                    if (temDap) {
                        if (vendas.size() > 10) {
                            resultado = resultado + resultado * 0.05;
                        }
                    }
                } else {
                    resultado = 0;
                }
            } else {
                resultado = 0;
            }
        } else {
            resultado = 0;
        }
        valor = Math.round(resultado * 100.0) / 100.0;
        return valor;
    }
}
```

a) Identifique **pelo menos quatro** maus-cheiros distintos. Para cada um,
preencha: trecho do código, mau-cheiro, justificativa, princípio de projeto não
atendido e refatoração do catálogo adequada.

| Trecho | Mau-cheiro | Justificativa | Princípio | Refatoração |
|----------|--------|-------------|--------|----------|
| | | | | |
| | | | | |
| | | | | |
| | | | | |

b) A variável `valor` é usada de uma forma problemática. Que valores, com
significados diferentes, ela recebe ao longo do método? Que problema isso causa
para quem lê (e para quem altera) o código?

c) O par `if (temDap) { if (vendas.size() > 10) { ... } }` pede qual das
refatorações do grupo 4? Mostre como ficaria a condição resultante.

d) Em que ordem você aplicaria as refatorações que citou? Justifique a
**primeira** escolhida.

###### Questão 8

**Tarefa:** comparar antes e depois, identificar a refatoração e reconhecer o
que **não** é refatoração.

**Antes**

```java
public class Produtor {
    private final String nome;
    private final String logradouro;
    private final String numero;
    private final String cidade;
    private final String uf;
    private final String cep;
    private double saldoAReceber;

    public Produtor(String nome, String logradouro, String numero,
                    String cidade, String uf, String cep) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldoAReceber() {
        return saldoAReceber;
    }

    public void creditar(double valor) {
        saldoAReceber += valor;
    }

    public String enderecoFormatado() {
        return logradouro + ", " + numero + " - " + cidade + "/" + uf
                + " (CEP " + cep + ")";
    }

    public boolean estaNaRotaDeEntregaDf() {
        return uf.equals("DF") || cidade.equals("Cristalina");
    }
}
```

**Depois**

**Endereco.java**

```java
public class Endereco {
    private final String logradouro;
    private final String numero;
    private final String cidade;
    private final String uf;
    private final String cep;

    public Endereco(String logradouro, String numero,
                    String cidade, String uf, String cep) {
        if (cep.length() != 8) {
            throw new IllegalArgumentException("CEP deve ter 8 dígitos: " + cep);
        }
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public String formatado() {
        return logradouro + ", " + numero + " - " + cidade + "/" + uf
                + " (CEP " + cep + ")";
    }

    public boolean estaNaRotaDeEntregaDf() {
        return uf.equals("DF") || cidade.equals("Cristalina");
    }
}
```

**Produtor.java**

```java
public class Produtor {
    private final String nome;
    private final Endereco endereco;
    private double saldoAReceber;

    public Produtor(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldoAReceber() {
        return saldoAReceber;
    }

    public void creditar(double valor) {
        saldoAReceber += valor;
    }

    public String enderecoFormatado() {
        return endereco.formatado();
    }

    public boolean estaNaRotaDeEntregaDf() {
        return endereco.estaNaRotaDeEntregaDf();
    }
}
```

a) Que mau-cheiro e que princípio de projeto não atendido justificam a mudança?
Relacione sua resposta aos campos `logradouro`, `numero`, `cidade`, `uf` e `cep`
e aos métodos `enderecoFormatado` e `estaNaRotaDeEntregaDf`.

b) Qual é a refatoração principal aplicada? Que refatorações menores do catálogo
a compõem? Justifique com evidências retiradas dos dois códigos.

c) Existe, no "depois", uma alteração que **não** é refatoração? Identifique-a,
dê uma entrada para a qual o "antes" e o "depois" se comportam de forma
diferente e explique o que o desenvolvedor deveria ter feito.

###### Questão 9

**Tarefa:** identificar maus-cheiros, o princípio violado e a sequência de
refatorações.

**Produto.java**

```java
public class Produto {
    public static final int HORTIFRUTI = 0;
    public static final int GRAOS = 1;
    public static final int LATICINIOS = 2;

    private final String nome;
    private final int tipo;

    public Produto(String nome, int tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getTipo() {
        return tipo;
    }

    public int prazoValidadeDias() {
        switch (tipo) {
            case HORTIFRUTI: return 5;
            case GRAOS:      return 180;
            case LATICINIOS: return 15;
            default: throw new IllegalStateException("Tipo inválido: " + tipo);
        }
    }

    public boolean exigeRefrigeracao() {
        switch (tipo) {
            case HORTIFRUTI: return false;
            case GRAOS:      return false;
            case LATICINIOS: return true;
            default: throw new IllegalStateException("Tipo inválido: " + tipo);
        }
    }

    public double taxaCooperativa() {
        switch (tipo) {
            case HORTIFRUTI: return 0.06;
            case GRAOS:      return 0.04;
            case LATICINIOS: return 0.09;
            default: throw new IllegalStateException("Tipo inválido: " + tipo);
        }
    }
}
```

**PlanejadorTransporte.java**

```java
public class PlanejadorTransporte {

    public String escolherVeiculo(Produto produto) {
        if (produto.getTipo() == Produto.LATICINIOS) {
            return "caminhão refrigerado";
        }
        if (produto.getTipo() == Produto.HORTIFRUTI) {
            return "caminhonete";
        }
        return "caminhão baú";
    }
}
```

a) Identifique os maus-cheiros presentes e justifique. Há mais de um, e eles se
reforçam mutuamente.

b) Que princípio de projeto não foi atendido? Justifique com um cenário: a
cooperativa passa a vender `PESCADO`. Liste **tudo** o que precisaria ser
alterado e diga o que acontece (e quando o erro aparece) se o desenvolvedor
esquecer um desses pontos.

c) Indique a **sequência** de refatorações do catálogo que você aplicaria e
explique por que a ordem importa. Mostre, em linhas gerais, como ficaria o
código no final.

d) Em que situação **não** valeria a pena aplicar a última refatoração da sua
sequência? Justifique.

###### Questão 10

**Tarefa:** comparar antes e depois e identificar duas refatorações distintas.

**Antes**

**Cooperativa.java**

```java
import java.util.ArrayList;
import java.util.List;

public class Cooperativa {
    private final String nome;
    private final double taxaAdministrativa;
    private final List<Produtor> cooperados = new ArrayList<>();

    public Cooperativa(String nome, double taxaAdministrativa) {
        this.nome = nome;
        this.taxaAdministrativa = taxaAdministrativa;
    }

    public void filiar(Produtor produtor) {
        cooperados.add(produtor);
        produtor.setCooperativa(this);
    }

    public double getTaxaAdministrativa() {
        return taxaAdministrativa;
    }

    public void registrarVenda(Produtor produtor, double valorBruto) {
        produtor.creditar(produtor.liquidoDaVenda(valorBruto));
    }
}
```

**Produtor.java**

```java
public class Produtor {
    private final String nome;
    private Cooperativa cooperativa;
    private double saldoAReceber;

    public Produtor(String nome) {
        this.nome = nome;
    }

    void setCooperativa(Cooperativa cooperativa) {
        this.cooperativa = cooperativa;
    }

    public double liquidoDaVenda(double valorBruto) {
        if (cooperativa == null) {
            throw new IllegalStateException("Produtor não filiado");
        }
        return valorBruto - valorBruto * cooperativa.getTaxaAdministrativa();
    }

    public void creditar(double valor) {
        saldoAReceber += valor;
    }

    public double getSaldoAReceber() {
        return saldoAReceber;
    }
}
```

**Fechamento.java**

```java
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Fechamento {

    public LocalDate dataPagamento(LocalDate fechamento) {
        LocalDate d = fechamento.plusDays(5);
        if (d.getDayOfWeek() == DayOfWeek.SATURDAY) {
            d = d.plusDays(2);
        } else if (d.getDayOfWeek() == DayOfWeek.SUNDAY) {
            d = d.plusDays(1);
        }
        return d;
    }

    public LocalDate dataRepasseDap(LocalDate fechamento) {
        LocalDate d = fechamento.plusDays(10);
        if (d.getDayOfWeek() == DayOfWeek.SATURDAY) {
            d = d.plusDays(2);
        } else if (d.getDayOfWeek() == DayOfWeek.SUNDAY) {
            d = d.plusDays(1);
        }
        return d;
    }
}
```

**Depois**

**Cooperativa.java**

```java
import java.util.ArrayList;
import java.util.List;

public class Cooperativa {
    private final String nome;
    private final double taxaAdministrativa;
    private final List<Produtor> cooperados = new ArrayList<>();

    public Cooperativa(String nome, double taxaAdministrativa) {
        this.nome = nome;
        this.taxaAdministrativa = taxaAdministrativa;
    }

    public void filiar(Produtor produtor) {
        cooperados.add(produtor);
    }

    public double getTaxaAdministrativa() {
        return taxaAdministrativa;
    }

    public void registrarVenda(Produtor produtor, double valorBruto) {
        if (!cooperados.contains(produtor)) {
            throw new IllegalStateException("Produtor não filiado");
        }
        produtor.creditar(produtor.liquidoDaVenda(valorBruto, taxaAdministrativa));
    }
}
```

**Produtor.java**

```java
public class Produtor {
    private final String nome;
    private double saldoAReceber;

    public Produtor(String nome) {
        this.nome = nome;
    }

    public double liquidoDaVenda(double valorBruto, double taxaAdministrativa) {
        return valorBruto - valorBruto * taxaAdministrativa;
    }

    public void creditar(double valor) {
        saldoAReceber += valor;
    }

    public double getSaldoAReceber() {
        return saldoAReceber;
    }
}
```

**Fechamento.java**

```java
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Fechamento {

    public LocalDate dataPagamento(LocalDate fechamento) {
        return proximoDiaUtil(fechamento.plusDays(5));
    }

    public LocalDate dataRepasseDap(LocalDate fechamento) {
        return proximoDiaUtil(fechamento.plusDays(10));
    }

    // Método estrangeiro: deveria estar em LocalDate, que não podemos alterar
    private LocalDate proximoDiaUtil(LocalDate data) {
        if (data.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return data.plusDays(2);
        }
        if (data.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return data.plusDays(1);
        }
        return data;
    }
}
```

a) Que problemas de projeto existiam no "antes" (cite pelo menos dois, em
classes diferentes) e que princípios eles violavam?

b) Duas refatorações **distintas** do catálogo foram aplicadas. Identifique cada
uma e justifique com evidências do código.

c) A segunda refatoração poderia ser confundida com Extract Method. Por que o
catálogo a trata como Introduce Foreign Method? O que o comentário no método
novo indica?

d) No "depois", a verificação de produtor não filiado mudou de lugar: do
`Produtor` para `Cooperativa.registrarVenda`. Por que essa mudança foi
necessária para que a alteração continuasse sendo uma refatoração?
