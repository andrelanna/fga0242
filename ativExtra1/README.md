UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  

### Técnicas de Programação em Plataformas Emergentes

---

### Atividade extra-classe, em substituição à aula no. 8.

Uma subsequência é definida como sendo uma string obtida ao remover zero ou mais
characteres de uma string de entrada. 

A maior subsequencia comum (_Longest Common Subsequence_ - LCS) é uma
subsequencia de comprimento máximo entre duas ou mais strings.   

Exemplos: 

As sequencias "1234" e "1224533324" possuem a LCS "1234":   
><u>1234</u>  
><u>12</u>245<u>3</u>332<u>4</u>

><u>t</u>hi<u>si</u>sa<u>test</u>  
><u>t</u>e<u>s</u>t<u>i</u>ng123<u>test</u>ing

Fonte: rosettacode.org

Utilizando as técnicas de falsificação, duplicação e triangulação, desenvolva
através de TDD um programa que seja capaz de calcular a LCS para dadas duas
strings de entrada. 
