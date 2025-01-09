UnB - Universidade de Brasilia  
FCTE - Faculdade de Ciência e Tecnologia em Engenharias  
TPPE - Técnicas de Programação para Plataformas Emergentes  

---

#### Contextualização: 

O QuickSort é um método de ordenação que consiste em, a cada iteração, determinar um valor como pivô e ordenar os elementos restantes de modo que valores menores que ele fiquem à sua esquerda e os valores maiores fiquem à sua direita. O método é repetido com a porção anterior e posterior ao pivô. 

Em sua versão mais simples, o pivô é determinado pelo primeiro elemento do vetor e, em seguida, aplica-se as ordenações nos sub-vetores. 

O método de particionamento pode ser dividido em três partes, sendo:  
1) inicialização: inicializar a variável que realiza a troca de elementos e determinação do pivô; 
2) varredura do vetor, em busca de elementos menores do que o pivô, realizando as trocas necessárias; 
3) troca do pivô, de modo a alocá-lo em sua posição definitiva. 


#### Problema: 

O código presente junto a esse enunciado possui, na classe QuickSort, um método chamado ```particionamento```. Não é possível aplicar a refatoração **Extrair Método** em seu conteúdo, de modo a dividi-lo nas partes apresentadas anteriormente, pois as variáveis temporárias da primeira parte tornam ambíguas o retorno do método que seria criado. 

Desse modo, para eliminar as variáveis temporárias, é necessário aplicar a operação de refatoração **Substituir método por objeto-método**. Na classe resultante dessa refatoração, deve ser possível a divisão do método de particionamento em suas três partes com a aplicação da refatoração **Extrair Método**. 


#### Enunciado: 

1) Aplique a operação de refatoração ***Substituir método por objeto-método*** no método ```particionamento``` da classe QuickSort. 
2) Na classe resultante, aplique a operação ***Extrair Método*** para dividir o método que realizar o particionamento em suas três partes. 

### Observação: 

Essa atividade deve ser realizada como atividade extra-classe, em substituição à aula do dia 06/01/2025. A entrega da atividade deverá ser realizada através de e-mail para o professor da disciplina até o dia 13/01/2025.


