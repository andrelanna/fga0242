
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
operação de refatoração para a eliminar (ou pelo menos diminuir) o mau cheiro.

Cada grupo deverá realizar três operações de refatoração no projeto, a citar a)
Extrair método, b) Substituir método por método objeto e c) Extrair constante.
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
seguinte [link](https://docs.google.com/spreadsheets/d/1uDTIRgDQ4Lg-apSzUI7ILPOmlXXpYqQkzsbTA5vX1HU/edit?usp=sharing).

---

**Grupos de alunos**

|  **GRUPO**  |   **Operação de Refatoração**  |   **Local a ser refatorado**  |
|:-----------:|:-------------------------------|:------------------------------|
|      1      | Extrair método                 | Simulador_IRPF.cadastrar      |
|             |Substituir método p/ met. objeto| Simulador_IRPF.calcular5aFaixa|
|             | Extrair constante              | Em todos os métodos de Simulador_IRPF|
|             |                                |                               |
|      2      | Extrair método                 | IRPF.addDeducao               |
|             |Substituir método p/ met. objeto| IRPF.calculateTax             |
|             | Extrair constante              | IRPF.calculateTax             |
|             |                                |                               |
|      3      | Extrair método                 | SimuladorIRPF.getTotalTodasDeducoes |
|             |Substituir método p/ met. objeto| SimuladorIRPF.getValorImposto |
|             | Extrair constante              | Metodo-objeto extraido acima  |
|             |                                |                               |
|      4      | Extrair método                 | Deducao.deducao               |
|             |Substituir método p/ met. objeto| AliquotaP.calculoAliquota     |
|             | Extrair constante              | Metodo-objeto extraido acima  |
|             |                                |                               |
|      5      | Extrair método                 | Simulador.cadastrarPrevidenciaOficial|
|             |Substituir método p/ met. objeto| Simulador.apuracaoImposto     |
|             | Extrair constante              | Método-objeto extraído acima  |
|             |                                |                               |
|      6      | Extrair método                 | CalculoIRPF.cadastrarRendimento|
|             |Substituir método p/ met. objeto| Imposto.calculaImposto        |
|             | Extrair constante              | Método-objeto extraído acima  |
|             |                                |                               |
|      7      | Extrair método                 | Deducoes.cadastrarPrevidenciaOficial|
|             |Substituir método p/ met. objeto| Imposto.calcularImposto       |
|             | Extrair constante              | Método-objeto extraído acima  |
|             |                                |                               |
|      8      | Extrair método                 | IRPF.cadastrarRendimento      |
|             |Substituir método p/ met. objeto| IRPF.calcularImposto()        |
|             | Extrair constante              | Método-objeto extraído acima. |
|             |                                |                               |
|      9      | Extrair método                 | IRRF.register_deduction       |
|             |Substituir método p/ met. objeto| IRRF.calculate_tax            |
|             | Extrair constante              | Método-objeto extraido acima  |
|             |                                |                               |
|     10      | Extrair método                 | Aliquota_efetiva.normal_round |
|             |Substituir método p/ met. objeto| Faixas_de_imposto.calcular_imposto|
|             | Extrair constante              | Faixas_de_imposto.\_\_post_init\_\_|


**Entrega do trabalho**

Os trabalhos deverão ser entregues através dos repositórios do GitHub utilizados
na primeira entrega do trabalho, até as 23:59:59hs do dia 25 de abril de 2022,
impreterivelmente. 

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
