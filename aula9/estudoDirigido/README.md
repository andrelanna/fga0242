
UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

---

## Estudo Dirigido - Testes Unitários

**Tópicos da aula**
- Exercícios conceituais e práticos sobre o conteúdo de testes unitários. 
- Assuntos abordados: 
  - Testes unitários
  - Frameworks de testes unitários
  - Arquitetura de frameworks de testes unitários
  - Asserções, testes, casos de testes, suítes de testes
  - Independência funcional de testes / condição de corrida em testes
  - Testes simples
  - Testes de exceção
  - Categorias de testes
  - Testes com _timeout_
  - Ignorando testes
  - Testes parametrizados

:warning: Essa lista de exercícios cobre todo o conteúdo de testes unitários e
serve como atividade extra-classe em reposição à aula do dia 06/04/2026.

### **Exercicios de fixação**

#### Parte I: Questões Teóricas (Conceitual)
1. Defina o que são testes unitários e explique a diferença entre testar um
   método isolado e testar um componente de software.

2. Segundo Martin Fowler, qual é a característica principal que define um
   framework em oposição a uma biblioteca? Como o JUnit exemplifica essa
   definição através da "Inversão de Controle"?

3. Explique o conceito de Condição de Corrida (Race Condition) no contexto de
   testes unitários. Por que testes que dependem de estado compartilhado ou
   ordem de execução são considerados um "anti-pattern"?

4. Diferencie os seguintes termos dentro do ecossistema JUnit:

   a) Asserção (Assertion)  
   b) Método de Teste (Test Method)  
   c) Caso de Teste (Test Case)  
   d) Suíte de Testes (Test Suite)  

5. A arquitetura do JUnit 4 é fundamentada em Design Patterns clássicos do GoF.
   Explique como o padrão Composite é utilizado na organização de suítes de
   testes e como o padrão Template Method se relaciona com a execução de métodos
   marcados com @Test.

6. Como desenvolvedores, de que forma "complementamos" a implementação do
   framework JUnit para que ele execute nossa lógica de negócio? Relacione sua
   resposta com o conceito de Hooks (ganchos).

7. Explique o funcionamento dos Testes Parametrizados. Em qual cenário eles são
   mais eficientes do que escrever múltiplos métodos de teste individuais?

8. O JUnit 4 permite o uso de Categories. Qual a utilidade prática de
   categorizar testes em um ambiente de Integração Contínua (CI/CD)?

#### Parte II: Questões Práticas (Raciocínio e Implementação)
9. Analise o código abaixo e identifique o erro de lógica ou de anotação que
   impedirá o teste de validar corretamente a exceção esperada:

```Java
@Test
public void testeDivisaoPorZero() {
    Calculadora calc = new Calculadora();
    int resultado = calc.dividir(10, 0);
    // O método dividir lança ArithmeticException
}
```

Como você corrigiria este teste para que ele passasse apenas se a exceção for
lançada, utilizando os recursos nativos do JUnit 4?

10. Escreva uma classe de teste em Junit4 chamada `StringUtilTest`. Implemente
    um método que verifique se o método `converterParaMaiusculo(String input)`
    de uma classe `StringUtil` funciona corretamente. Utilize pelo menos duas
    asserções diferentes (ex: `assertEquals` e `assertNotNull`).

11. Considere um sistema de banco de dados onde o desenvolvedor escreveu o
    seguinte teste:

```Java
public class BancoTest {
    private static Conexao conn = new Conexao();

    @Test
    public void inserirUsuario() {
        conn.executar("INSERT INTO usuarios...");
        assertEquals(1, conn.totalUsuarios());
    }

    @Test
    public void deletarUsuario() {
        conn.executar("DELETE FROM usuarios...");
        assertEquals(0, conn.totalUsuarios());
    }
}
```

Por que esse teste é vulnerável a condições de corrida ou falhas intermitentes?
O que deve ser feito para isolar o estado entre os testes?

12. Crie um exemplo de Teste com Timeout. Imagine um método `processarLote()`
    que não pode levar mais de 500 milissegundos para ser executado. Escreva a
    estrutura do teste utilizando a anotação apropriada.

13. Dado o código abaixo, explique qual será o resultado da execução deste teste
    se o método calcularDesconto retornar 10.00001 para um valor esperado de
    10.0.

```Java
@Test
public void testePreco() {
    double esperado = 10.0;
    double atual = produto.calcularDesconto();
    assertEquals(esperado, atual, 0.001);
}
```

O teste passará ou falhará? Justifique baseando-se no conceito de "delta" em
asserções de ponto flutuante.

14. Demonstre a criação de uma Suíte de Testes (TestSuite) que agrupe duas
    classes hipotéticas: LoginTest.class e CadastroTest.class. Utilize as
    anotações @RunWith e @SuiteClasses.

15. Escreva o esqueleto de um Teste Parametrizado para validar um método
    `ehPar(int n)`. Você deve definir:

    a) O Runner específico para parâmetros.  
    b) O método estático que fornece os dados (ex: 2 -> true, 3 -> false).  
    c) O construtor da classe de teste para receber esses dados.  
