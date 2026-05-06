
UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

---

## Aula 9 - Aula Prática de TDD

Objetivo dessa aula é apresentar, de maneira prática e através de um exemplo, a
construção de uma aplicação utilizando TDD e suas técnicas de falsificação,
duplicação e triangulação. 


**Tópicos da aula**
- Test-Driven Development
- Falsificação
- Duplicação
- Triangulação
- Exercício sobre TDD, utilizando testes parametrizados.


**Recursos da aula**
- Junto a essa pasta está o arquivo `.zip` com o código desenvolvido em aula.


**Vídeos da aula**
* [Vídeo turma 1](https://youtu.be/0KfKg4cf5Hc)
* [Vídeo turma 2](https://youtu.be/psdemfLrcBI)


O exemplo utilizado para essa aula é a Calculador de IRPF da Receita Federal,
disponível no endereço
[https://www27.receita.fazenda.gov.br/simulador-irpf/](https://www27.receita.fazenda.gov.br/simulador-irpf/)

**Exemplo desenvolvido em sala de aula**  
[Exemplo](calculadoraIRPF/)

--------------------------------------------------------------------------------

### **Exercicios de fixacao**   

#### Exercício 1 - Árvore genealógica

Uma árvore genealógica representa várias pessoas e suas relações de parentesco.
Essas relações podem ser do tipo descendência - quando uma pessoa é filha, neta,
bisneta, sobrinha, etc...- de outras pessoas, ou do tipo conjugal o que ocorre
quando pessoas se unem distintas famílias por meio do matrimônio. Cada pessoa é
descrita por seu primeiro nome e sobrenome familiar.

Dado esse cenário, faça o que se pede, utilizando TDD como forma de
desenvolvimento. Para cada item, desenvolva um teste parametrizado para a
unidade que implementa a funcionalidade. 

1. Criar uma pessoa com seu nome e sobrenome. Sugestão: crie um Factory Method
   para a instanciação de objetos do tipo Pessoa
2. Associar uma pessoa à outra por meio de descendência direta (relação filial).
3. Associar uma pessoa à outra por meio de matrimônio. 
4. Remover algum nodo da árvore e, consequentemente, todos os nodos
   descendentes.
5. Para uma determinada pessoa, listar os nomes das pessoas que são seus irmãos. 
6. Para uma determinada pessoa, listar os nomes das pessoas que são seus tios. 

Todos os testes acima deverão ser Parametrizados e rotulados com a categoria
`Funcional`.

7. No caso de uma pessoa não possuir irmãos, a exceção `NaoTemIrmaoException`
   deve ser lançada. Rotule esse teste como `Excecao`

8. Crie uma suite de testes que execute todos os testes de uma vez. 


#### Exercício 2 - Balanceamento de strings 

Desenvolva, utilizando as técnicas de TDD, o seguinte problema abaixo: 

Dada uma _string_ formada por combinações de abre- e fecha-parênteses, colchetes
e chaves. Retorne se a _string_ é balanceada (bem-formada). 

Por exemplo, dada a string `([])[]({})`, deve retornar `true`.   Dadas as
strings `([)]` ou `((()`, deve retornar `false`.


(_Esse problema foi questionado pelo **Facebook**_)


