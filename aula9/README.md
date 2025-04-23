
UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

---

## Aula 9 - Aula Prática de TDD

**Tópicos da aula**
- Exercício sobre TDD, utilizando testes parametrizados.


**Recursos da aula**
- Junto a essa pasta está o arquivo `.zip` com o código desenvolvido em aula.


**Exercicios de fixacao**   
Uma árvore genealógica representa várias pessoas e suas relações de parentesco. Essas relações podem ser do tipo descendência - quando uma pessoa é filha, neta, bisneta, sobrinha, etc...- de outras pessoas, ou do tipo conjugal o que ocorre quando pessoas se unem distintas famílias por meio do matrimônio. Cada pessoa é descrita por seu primeiro nome e sobrenome familiar.

Dado esse cenário, faça o que se pede, utilizando TDD como forma de desenvolvimento. Para cada item, desenvolva um teste parametrizado para a unidade que implementa a funcionalidade. 

1. Criar uma pessoa com seu nome e sobrenome. Sugestão: crie um Factory Method para a instanciação de objetos do tipo Pessoa
2. Associar uma pessoa à outra por meio de descendência direta (relação filial).
3. Associar uma pessoa à outra por meio de matrimônio. 
4. Remover algum nodo da árvore e, consequentemente, todos os nodos descendentes.
5. Para uma determinada pessoa, listar os nomes das pessoas que são seus irmãos. 
6. Para uma determinada pessoa, listar os nomes das pessoas que são seus tios. 

Todos os testes acima deverão ser Parametrizados e rotulados com a categoria `Funcional`.

7. No caso de uma pessoa não possuir irmãos, a exceção `NaoTemIrmaoException` deve ser lançada. Rotule esse teste como `Excecao`

8. Crie uma suite de testes que execute todos os testes de uma vez. 

