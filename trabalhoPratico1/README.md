**UnB - Universidade de Brasilia**  
**FCTE - Faculdade de Ciência e Tecnologia em Engenharias**  
**FGA0242 - Técnicas de Programação para Plataformas Emergentes**  
**Prof. André Lanna**  

---

# Trabalho prático 1

## O algoritmo Árvore-B

O algoritmo Árvore-B é uma estrutura de dados de árvore balanceada projetada
para otimizar o acesso a grandes volumes de dados. Ele é empregado com muita
freqüência por sistemas gerenciadores de banco de dados (SGBS) e sistemas de
arquivos (_File Systems_) para realizar acesso a dados armazenados em
dispositivos de memória secundária (como discos rígidos). De modo bastante
resumido, esse algoritmo armazena em sua estrutura interna (nós internos) as
chaves para indexação dos conteúdos e, em sua estrutura externa (nós folhas), as
referências para os conteúdos indexados. 

Esse algoritmo tem como características fundamentais: 
* Árvore balanceada: todos os nós folha estão no mesmo nível;
* Nós com multiplas chaves e filhos: os nós não são binários pois armazenam
  várias chaves ordenadas e possuem múltiplos filhos; 
* As árvores possuem uma ordem $t$ que define os limites de sua estrutura: 
  * Ordem $t$:
    * Cada nó tem, no mínimo, $t-1$ chaves (exceto a raiz); 
    * Cada nó tem, no máximo, $2\cdot t-1$ chaves (incluindo a raiz); 
    * Cada nó tem entre $t$ e $2\cdot t$ filhos
    * Se um nó é interno, deve ter exatamente $(número\ de\ chaves + 1)$ filhos, o
      número de filhos deve estar entre $t$ e $2\cdot t$;
    * Se um nó é folha, então não tem filhos (número de filhos = 0).
* Propriedades de ordenação: 
  * as chaves de cada nó estão sempre ordenadas em
  ordem crescente e, 
  * para cada chave $k$ em um nó, todas as chaves na subárvore à esquerda são
    menores do que $k$ e à direita são maiores do que $k$.
* Propriedades hierárquicas (ou de partição): 
  * Para um nó com $m$ chaves e $m+1$ filhos: 
    - Subárvore esquerda do filho $i$: todas as chaves são menores que a chave
      $k_i$ do nó atual;
    - Subárvore direita do filho $i$: todas as chaves são maiores que a chave
      $k_i$ do nó atual;
* Condições especiais para o nó raiz: 
  * A raiz pode ter menos do que $t-1$ chaves (pode ter, até mesmo, 1 chave
    apenas)
  * Quando a raiz é dividida, um novo nó raiz é criado (único caso em que a
    altura cresce)
  * Se a raiz tiver mais de $2\cdot t -1$ chaves, ela é dividida e a árvore
    aumenta sua altura;
* As árvores são auto-balanceadas, ou seja, elas mantêm seu balanceamento
  automaticamente, sem necessidade de reorganização manual.

Exemplo de Árvore-B, de ordem $t=3$: 
```
                                      [Raiz: 40]
                           |----------/         \-----|
                          [20]                     [60, 80]
                   |-----/    \-|            |-----/   |  \----------|
                [10, 15]       [30]        [50]       [70]       [90, 95]
               /   |   \       /   \       /   \      /   \      /   |   \
            [5,7] [12] [18] [25] [35]  [45]    [55] [65] [75]  [85] [92] [98, 99]
```
Note que essa árvore satisfaz todas as propriedades apresentadas anteriormente.
Sugestão: avalie cada uma das propriedades e verifique se estão sendo, de fato,
atendidas. 


Em linhas gerais, a Árvore-B está definida em termo de três operações primárias
e três operações auxiliares (para manutenção das invariantes). As operações
primárias são: 
- Inserção: para adicionar um elemento na árvore, mantendo seu balanceamento;
- Remoção: para remover um elemento da árvore, mantendo seu balanceamento; 
- Busca: encontra uma chave na árvore, percorrendo os nós desde a raiz até o
  local em que ele se encontra. 

As operações auxiliares são as seguintes: 
- Divisão: quando um nó atinge $2 \cdot t$ chaves (_overflow_)
- Fusão: quando um nó atinge $t-2$ chaves (_underflow_)
- Redistribuição: quando um nó "irmão" tem $\leq t$ chaves.

Para detalhes de implementação dos algoritmos mencionados acima, recomenda-se as
leituras das seguintes referências bibliográficas:
- CORMEN, Thomas H.; LEISERSON, Charles E.; Ronald L. Rivest; et al.
  **Algoritmos.** 4. ed. Rio de Janeiro: GEN LTC, 2024. _E-book_. p.350. ISBN
9788595159914. Disponível em: https://integrada.minhabiblioteca.com.br/reader/books/9788595159914/. 
- SZWARCFITER, Jayme L.; MARKENZON, Lilian. **Estruturas de Dados e Seus
  Algoritmos**. 3. ed. Rio de Janeiro: LTC, 2010. _E-book_. p.139. ISBN
978-85-216-2995-5. Disponível em:
https://integrada.minhabiblioteca.com.br/reader/books/978-85-216-2995-5/.
- ZIVIANI, Nivio. **Projeto de Algoritmos: com Implementações em Pascal e C – 3ª
  edição revista e ampliada**. 3. ed. Porto Alegre: +A Educação - Cengage
Learning Brasil, 2018. _E-book_. p.250. ISBN 9788522126590. Disponível em:
https://integrada.minhabiblioteca.com.br/reader/books/9788522126590/.

## Enunciado

Esse trabalho consiste na implementação da estrutura de dados Árvore-B e seus
algoritmos, principais e auxiliares, com a utilização das técnicas de
programação por contratos (Design by Contracts). 

:warning::warning::warning: Toda a estrutura da Árvore-B e suas operações
deverão ser implementadas pelos grupos, utilizando o paradigma de orientação por
objetos em seu desenvolvimento. Não serão aceitos trabalhos que utilize
implementações de Árvore-B já disponibilizadas por bibliotecas. 

Os trabalhos deverão ser desenvolvidos em Python3, com a utilização da
biblioteca
[icontract](https://icontract.readthedocs.io/en/latest/introduction.html) para
implementação dos contratos. Os contratos a serem implementados, descritos em
termos de invariantes e pré- e pós-condições, estão apresentados na seção
`Pontuação e critérios de correção`, apresentada em seguida. 

Os elementos a serem inseridos na árvore são valores inteiros. Os grupos podem
usar os valores apresentados no exemplo desse trabalho para que possam avaliar a
implementação.


## Pontuação e critérios de correção

Esse trabalho vale 40 pontos no cálculo final de menção. A pontuação está
distribuída conforme tabela apresentada abaixo.

| Inv./ Pre- / Pos-cond. | Descricao | Valor |
|:---|:---|:--:|
| Invariante | Todos os nós folhas estão no mesmo nível? | 5 pontos |
| Invariante | Para os nós internos, as chaves estão em ordem crescente? | 5 pontos |
| Invariante | Para os nós folhas, todos os valores estão em ordem crescente? | 5 pontos |
| Pré | Chave a ser inserida não existe na árvore | 5 pontos |
| Pré | Chave a ser removida existe na árvore | 5 pontos |
| Pós | Para nó-raiz, $1 \leq numChaves \leq 2 \cdot 1$, para nós internos, $t-1 \leq numChaves \leq 2 \cdot 1$ | 5 pontos |
| Pós | Para nó raiz, o número de filhos é $2 \leq numFilhos \leq 2\cdot t$, para nós internos, o número de filhos é $t \leq numFilhos \leq 2\cdot t$ | 5 pontos |
| Pós | Para a raiz, após operação de divisão, nível da árvore aumenta em uma unidade, após operação de fusão, nível da árvore diminui em uma unidade. | 5 pontos |
| **TOTAL:** | | 40 pontos |

:warning::warning::warning: **Penalidades**: :warning::warning::warning:
- Trabalhos que utilizaram implementações de bibliotecas e não implementaram a
  estrutura de Arvore-B: -100% da nota. 
- Trabalhos que não utilizaram conceitos de orientação por objetos na
  implementação dos componentes da Árvore-B: -80% da nota. 
- Trabalhos que utilizaram outro framework de projeto por contratos, diferente
  do icontract: -50% da nota. 


## Formação de grupos e entrega do trabalho
- Os trabalhos poderão ser realizados por grupos de até 5 integrantes. 
- Os grupos deverão informar seus componentes (nome e matrícula), através do
  formulário disponível em [https://docs.google.com/forms/d/e/1FAIpQLSeg_Efu9SdflB7ThbYyfVknui42gjSJV8tRQ_hGVquZtxvIKQ/viewform?usp=dialog](https://docs.google.com/forms/d/e/1FAIpQLSeg_Efu9SdflB7ThbYyfVknui42gjSJV8tRQ_hGVquZtxvIKQ/viewform?usp=dialog).
- O prazo final para entrega do trabalho é **18:00hs, do dia 23/06/2025**. 
- A entrega será realizada através da página da disciplina no Moodle. 

## Referências bibliográficas
- iContract: biblioteca para DBC em Python. Disponível em:
  [https://icontract.readthedocs.io/en/latest/introduction.html](https://icontract.readthedocs.io/en/latest/introduction.html)
- CORMEN, Thomas H.; LEISERSON, Charles E.; Ronald L. Rivest; et al.
  **Algoritmos.** 4. ed. Rio de Janeiro: GEN LTC, 2024. _E-book_. p.350. ISBN
9788595159914. Disponível em: [https://integrada.minhabiblioteca.com.br/reader/books/9788595159914/](https://integrada.minhabiblioteca.com.br/reader/books/9788595159914/). 
- SZWARCFITER, Jayme L.; MARKENZON, Lilian. **Estruturas de Dados e Seus
  Algoritmos**. 3. ed. Rio de Janeiro: LTC, 2010. _E-book_. p.139. ISBN
978-85-216-2995-5. Disponível em:
[https://integrada.minhabiblioteca.com.br/reader/books/978-85-216-2995-5/](https://integrada.minhabiblioteca.com.br/reader/books/978-85-216-2995-5/).
- ZIVIANI, Nivio. **Projeto de Algoritmos: com Implementações em Pascal e C – 3ª
  edição revista e ampliada**. 3. ed. Porto Alegre: +A Educação - Cengage
Learning Brasil, 2018. _E-book_. p.250. ISBN 9788522126590. Disponível em:
[https://integrada.minhabiblioteca.com.br/reader/books/9788522126590/](https://integrada.minhabiblioteca.com.br/reader/books/9788522126590/).
