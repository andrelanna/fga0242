
UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

---

## Aula 6 - Testes unitários, prática 

### **Tópicos da aula**

Últimos tópicos sobre testes unitários: 
  - Testes parametrizados
  - Testes de lançamentos de exceções
  - Categorias de testes

### **Vídeo da aula**
* [Vídeo](https://youtu.be/ZxQP4R08vK4)

### **Código da aula**  
* [Testes](tests/)
* [Excecoes](exception/)
* [Codigo](app/)

### **Exercicios de fixacao**

#### Exercício 1 
Seja um programa que calcule área e perímetro de figuras geométricas planas. As áreas eperímetros são calculadas para as seguintes figuras geométricas: quadrado, retângulo, triângulo e círculo. Para cada uma das figuras geométricas: 
- crie um teste parametrizado para calcular área e perímetro (os dados dos testes estão apresentados em seguida)
- crie testes que verificam a corretude de todas as medidas das figuras geométricas. As medidas não podem ser iguais a zero ou negativas. Nesses casos, o teste deverá verificar que a exceção ```MedidaInvalidaException" foi disparada. 
- Diferencie os testes entre as categorias ```Funcional``` e ```Excecao```
- Agrupe os testes na suite de testes ```SteMedidasPlanas```

Dados para o teste: 
- Quadrado:   
  | Lado | Área esperada | Perímetro esperado | 
  |:-----|:-------------:|:------------------:|
  |  3   |       9       |        12          |
  |  4   |      16       |        16          |
  |  5   |      25       |        20          |

- Retangulo:
  | Lado 1 | Lado 2 | Área esperada | Perímetro esperado | 
  |:-------|:------:|:-------------:|:------------------:|
  |  3     |  5     |      15       |        16          |
  |  5     |  4     |      20       |        18          |
  |  10    |  20    |      200      |        60          |

- Triângulo:
  | Lado | Área esperada | Perímetro esperado | 
  |:-----|:-------------:|:------------------:|
  |  3   |     3,897     |         9          |
  |  4   |     6,928     |         12         |
  |  5   |    10,825     |         15         |
  
- Círculo:
  | Raio | Área esperada | Perímetro esperado | 
  |:-----|:-------------:|:------------------:|
  |  3   |    28,274     |       18,849       |
  |  4   |    50,265     |       25,132       |
  |  5   |    78,539     |       31,415       |

### Exercício 2

Crie uma suite de testes funcionais para o exercício acima que permita informar os valores e as unidades das medidas dos lados, e obtenha como resposta uma string de resposta com o valor e a unidade de resposta. 

Dados para o teste: 
- Quadrado:   
  | Lado | Unidade | Área esperada | Perímetro esperado | 
  |:-----|:-------:|:-------------:|:------------------:|
  |  3   |   mm    |       9 mm2   |        12 mm       |
  |  4   |   M     |      16 M2    |        16 M        |
  |  5   |   cm    |      25 cm2   |        20 cm       |

- Retangulo:
  | Lado 1 | Lado 2 | Unidade | Área esperada | Perímetro esperado | 
  |:-------|:------:|:-------:|:-------------:|:------------------:|
  |  3     |  5     |   cm    |       15 cm2  |        16 cm       |
  |  5     |  4     |   Km    |       20 Km2  |        18 Km       |
  |  10    |  20    |   dm    |      200 dm2  |        60 dm       |

- Triângulo:
  | Lado | Unidade | Área esperada | Perímetro esperado | 
  |:-----|:-------:|:-------------:|:------------------:|
  |  3   |   dm    |     3,897 dm2 |          9 dm      |
  |  4   |   DM    |     6,928 DM2 |         12 DM      |
  |  5   |   Km    |    10,825 Km2 |         15 Km      |
  
- Círculo:
  | Raio | Unidade | Área esperada | Perímetro esperado | 
  |:-----|:-------:|:-------------:|:------------------:|
  |  3   |   DM    |    28,274 DM2 |       18,849 DM    |
  |  4   |   dm    |    50,265 dm2 |       25,132 dm    |
  |  5   |   mm    |    78,539 mm2 |       31,415 mm    |


### Exercício 3: 

Crie uma suíte de testes funcionais que, informados o tipo de sólido e suas medidas, seja capaz de verificar se o tipo do objeto (classe que a instanciou), as medidas de área da superfície e volume estão corretas. Os dados para os sólidos estão apresentados abaixo.

Dados para os testes: 
- Cubo: 
  | Lado | Tipo esperado | Área superf.  | Volume | 
  |:-----|:-------------:|:-------------:|:------:|
  |  3   | Cubo.class    |     54        |  27    |
  |  4   | Cubo.class    |     96        |  64    |
  |  5   | Cubo.class    |    150        |  125   |

- Cubo:
  | Lado 1 | Lado 2 | Altura | TipoEsperado | Volume esper. | Área superf. | 
  |:-------|:------:|:------:|:------------:|:-------------:|:------------:|
  |  3     |  5     |  7     | Cubo.class   |     105       |        142   |
  |  5     |  4     |  6     | Cubo.class   |     120       |        148   |
  |  10    |  20    |  5     | Cubo.class   |     1000      |        700   |

- Piramide:
  | Base     | Lado | Altura | TipoEsperado   | Volume esper. | Área superf. | 
  |:--------:|:-----|:------:|:--------------:|:-------------:|:------------:|
  | Quadrado |  3   |   6    | Piramide.class |    18         |        36    |
  | Quadrado |  4   |   5    | Piramide.class |    26,666     |        40    |
  | Quadrado |  5   |   4    | Piramide.class |    65,333     |        56    |
  
- Esfera:
  | Raio | TipoEsperado | Volume esper. | Área superf. | 
  |:-----|:------------:|:-------------:|:------------:|
  |  3   | Esfera.class | 113,097       |   113,097    |
  |  4   | Esfera.class | 268,082       |   201,061    |
  |  5   | Esfera.class | 523,598       |   314,159    |



### Desafio: 
_Esse problema foi perguntado pela Google_

> Dadas duas strings A e B, retorne se A pode ser deslocada algum número de vezes
> para obter B. 
> 
> Por exemplo, se A é `abcde` e B é `cdeab`, retorne `true`. Se A é `abc` e B é
> `acb`, retorne `falso`.

Crie duas categorias de teste, chamadas `Funcional` e `Excecao`. Os testes
funcionais deverão garantir:

 a) que a solução consegue descobrir quando ocorre o deslocamento da string A
para se obter a string B e   
 b) quando não há deslocamento possível para transformar A em B, deve-se lançar
a exceção `StringsDiferentesException`. 

Quando uma das duas strings A ou B for fazia, deverá ser lançada uma exceção
`StringVaziaException`. Um teste deverá ser escrito para garantir o lançamento
dessa exceção. 

Utilize as seguintes strings para a escrita dos testes. 

| A    | B     |
|------|-------|
|abcde | cdeab |
|gama  | amag  |
|arara | arara |
|mesa  | ames  |
