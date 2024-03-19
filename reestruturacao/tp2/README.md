UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
TPPE - Técnicas de Programação para Plataformas Emergentes  

### Trabalho Prático 2 - _Refactoring_

---

**Enunciado do trabalho** 

O trabalho prático 2 tem como intuito exercitar o conteúdo de _Refactoring_
através da aplicações de algumas de suas operações no projeto apresentado no
trabalho prático 1. Espera-se ao final desse trabalho que os componentes do
grupo sejam capazes de identificar os maus cheiros de código e aplicar a
operação de refatoração para eliminar (ou pelo menos diminuir) o mau cheiro.

Cada grupo deverá realizar três operações de refatoração no projeto, a citar a)
Extrair Método, b) Substituir método por método objeto e c) Extrair constante.
As operações de refatoração deverão ser aplicadas na ordem apresentada
anteriormente e cada operação deverá ser apresentada em um _commit_ específico.

A mensagem de cada _commit_ terá o seguinte formato: 
```
Refactoring: <nome da operação>
Mau(s) cheiro(s) identificado(s): <mc1>, <mc2>, ...
Descrição da refatoração: <breve relato da operação realizada>
Classes/métodos/atributos afetados: <nome da classe>, <nome do método>, <nome do
atributo> 
```

Exemplo: 
```
Refactoring: extrair método
Mau-cheiro identificado: código duplicado, método inchado
Descrição da refatoração: aplicou-se a refatoração para extrair código duplicado
no método e para dividir o método original em 4 novos métodos, cada um com maior
coesão. 
Classes/métodos/atributos afetados: 
* Método X foi dividido nos métodos k, l, m e n
* Método y foi extraido a partir do metodo X para eliminar código duplicado.
```

As operações de refatoração e os locais a serem aplicadas estão definidas
conforme a tabela apresentada na seção Grupo de Alunos. O número do grupo
corresponde ao número apresentado na tabela de notas da disciplina publicada no
seguinte [link](https://docs.google.com/spreadsheets/d/1CyAeaEKlNzQ4SsSnTw0rYcr8s7oWJicMwrppxvZEyXE/edit?usp=sharing).

[Catálogo Refactoring - Compondo métodos](https://github.com/andrelanna/andrelanna.github.io/blob/master/lectures/das/Catalogo_Refatoracao_Compondo_metodos.pdf)

---

**Grupos de alunos**

|  **GRUPO**  |   **Operação de Refatoração**  |   **Local a ser refatorado**  |
|:-----------:|:-------------------------------|:------------------------------|
|      1      | Extrair método                 |Todas ocorrências isLimiteValido|
|             |Substituir método p/ met. objeto|CadastrarContribuicao.add()    |
|             | Extrair constante              |ContribuicaoPrevidenciaria, Deducao, Pensao, Rendimento.|
|             |                                |                               |
|      2      | Extrair método                 |IRPF.calculateBasis()          |
|             |Substituir método p/ met. objeto|IRPF.registerIncome()          |
|             | Extrair constante              |Não há como aplicar essa refatoração|
|             |                                |                               |
|      3      | Extrair método                 |IRPF.calculaTaxas              |
|             |Substituir método p/ met. objeto|No método resultante da refatoração acima|
|             | Extrair constante              |Em toda a classe IRPF classe objeto-método extraída|
|             |                                |                               |
|      4      | Extrair método                 |value == null || value < 0     |
|             |Substituir método p/ met. objeto|get totalDeducoes()            |
|             | Extrair constante              |get imposto(), todos métodos getImpostoFaixaX()|
|             |                                |                               |
|      5      | Extrair método                 |CalculadoraIRPF.calculoImposto()|
|             |Substituir método p/ met. objeto|Método calculoImposto() resultante da refatoração acima|
|             | Extrair constante              |Todas as constantes presentes nos métodos refatorados à partir de calculoImposto() original|
|             |                                |                               |
|      6      | Extrair método                 |functions.calcula_valor_importo|
|             |Substituir método p/ met. objeto|Método resultante da refatoração anterior|
|             | Extrair constante              |Métodos refatorados pelas refatorações anteriores|
|             |                                |                               |
|      7      | Extrair método                 |calc.calculateBaseValuePerRange|
|             |Substituir método p/ met. objeto|deductionsRegister.createDeduction|
|             | Extrair constante              |calc.ts                        |
|             |                                |                               |
|      8      | Extrair método                 |Todas ocorrências de ```descricao == None or descricao == ""``` e ```valor <= 0 or valor == None```
|             |Substituir método p/ met. objeto|Deducao.calculoValorTotalDeducoes()|
|             | Extrair constante              |Objeto método resultante da operação anterior|
|             |                                |                               |
|      9      | Extrair método                 |CalculadoraIRPF.getValorImposto|
|             |Substituir método p/ met. objeto|Método resultante da refatoração anterior|
|             | Extrair constante              |Métodos refatorados pelas refatorações anteriores|
|             |                                |                               |
|     10      | Extrair método                 |Calculo.calculaImposto()       |
|             |Substituir método p/ met. objeto|Método calculaImposto resultante da refatoração anterior|
|             | Extrair constante              |Objeto-método resultante da refatoração anterior|
|             |                                |                               |
|     11      | Extrair método                 |SimuladorIRPF.getImposto       |
|             |Substituir método p/ met. objeto|Método resultante da refatoração anterior|
|             | Extrair constante              |Métodos refatorados pelas refatorações anteriores|
|             |                                |                               |
|     12      | Extrair método                 | SimuladorIRPF.calcularValorBaseFaixa|
|             |Substituir método p/ met. objeto|SimuladorIRPF.cadastrarDeducao |
|             | Extrair constante              |SimuladorIRPF.calcularValorBaseFaixa|
|             |                                |                               |
|     13      | Extrair método                 |SimuladorIRPF.calcula_faixas() |
|             |Substituir método p/ met. objeto|Método resultante da refatoração anterior|
|             | Extrair constante              |Métodos refatorados pelas refatorações anteriores|
|             |                                |                               |
|     14      | Extrair método                 |SimuladorIRFP.calculaImposto() |
|             |Substituir método p/ met. objeto|Método resultante da refatoração anterior|
|             | Extrair constante              |Métodos refatorados pelas refatorações anteriores|
|             |                                |                               |
|     15      | Extrair método                 |SimuladorIRPF.calculaIRPF()    |
|             |Substituir método p/ met. objeto|Método resultante da refatoração anterior|
|             | Extrair constante              |Métodos refatorados pelas refatorações anteriores|
|             |                                |                               |
|     16      | Extrair método                 |Simulacao.get_valor_imposto()  |
|             |Substituir método p/ met. objeto|Método resultante da refatoração anterior|
|             | Extrair constante              |main.py                        |
|             |                                |                               |
|     17      | Extrair método                 |CalculadoraIRPF.getTotalImposto|
|             |Substituir método p/ met. objeto|Método resultante da refatoração anterior|
|             | Extrair constante              |Métodos refatorados pelas refatorações anteriores|
|             |                                |                               |
|     18      | Extrair método                 |Faixa.calcular_imposto()       |
|             |Substituir método p/ met. objeto|Método resultante da refatoração anterior|
|             | Extrair constante              |Métodos refatorados pelas refatorações anteriores|
|             |                                |                               |
|     19      | Extrair método                 |IncomeTaxCalculator.getEffectiveRate()
|             |Substituir método p/ met. objeto|Método resultante da refatoração anterior|
|             | Extrair constante              |Métodos refatorados pelas refatorações anteriores|
|             |                                |                               |
|     20      | Extrair método                 |Nas expressoes aritmeticas que realizam calculos da base de calculo considerando os valores de cada faixa|
|             |Substituir método p/ met.  objeto|SimuladorIRPF.calcula_total_imposto()|
|             | Extrair constante              |Em toda classe SimuladorIRPF   |


**Entrega do trabalho**

Os trabalhos deverão ser entregues através dos repositórios do GitHub utilizados
na primeira entrega do trabalho, **até as 23:59:59hs do dia 1 de fevereiro de
2023, impreterivelmente**. 

Recomenda-se utilizar uma branch específica para realizar as operações de
refatoração, criada a partir da última versão do código (aquela utilizada para
correção do TP1). 


**Valor do trabalho**

30 pontos distribuídos da seguinte forma: 
- Extrair método: 10 pontos.
- Substituir método por método-objeto: 15 pontos. 
- Extrair constante: 5 pontos.

**Forma de avaliação**

Os trabalhos serão avaliados através:

- da corretude dos testes das unidades refatoradas;
- da corretude dos refatorações aplicadas avaliadas se : 
    - as alterações no projeto são condizentes com os passos da refatoração;
    - o(s) mau(s) cheiro(s) foram eliminados ou diminuidos.




