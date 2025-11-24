
UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

---

## Aula 16 - Programação Defensiva

**Tópicos da aula**
- Assertivas
- Programação por contratos
- Pré-condições
- Pós-condições
- Invariantes

**Slides da aula**
* [Slides](https://docs.google.com/presentation/d/1Lb2U03PWaVXR37uUwfBRIXyZQXEkiAtK/edit?usp=sharing&ouid=112746484255766107555&rtpof=true&sd=true)  

Os exemplos abaixo estão disponibilizados em um [notebook](Exemplo_DBC.ipynb).  

## Exemplo 1: Medida e Figuras Geometricas

### Classe Medida
Pré-condições: 
- Valor da medida deve ser sempre positivo
- Unidade da medida não pode ser nula



```python
import icontract

class Medida:
    valor: float
    unidade: str

    @icontract.require(lambda valor : valor > 0)
    @icontract.require(lambda unidade : unidade != None)
    def __init__(self, valor: float, unidade: str):
        self.valor = valor
        self.unidade = unidade
```

### Classe FiguraPlana
Pós-condições: 
- Valores de área e perímetro não podem nunca serem negativas ou nulas

Observações:
- Embora a classe `FiguraPlana` seja abstrata, é possível especificar cláusulas (no caso de pós-condições) para as operações `calcularArea()`e `calcularPerimetro()`.
- Essas cláusulas permanecerão válidas para as subclasses de `FiguraPlana`. 


```python
from abc import abstractmethod
class FiguraPlana: 
    area: Medida
    perimetro: Medida
    
    @abstractmethod
    @icontract.ensure(lambda self: self.area.valor > 0)
    def calcularArea(self) -> Medida:
        pass

    @abstractmethod
    @icontract.ensure(lambda result: result.valor > 0)
    def calcularPerimetro(self) -> Medida:
        pass
```

A classe `Circulo` é uma subclasse de `FiguraPlana` e, por esse motivo, herda os métodos *e contratos* de `calcularArea()`e `calcularPerimetro()`. Além disso, adiciona uma clásula de pré-condição ao método construtor, que estabelece que exista um objeto `Medida`atribuido à raio. 


```python
class Circulo(FiguraPlana): 
    raio: Medida

    @icontract.require(lambda raio: raio != None)
    def __init__(self, raio:Medida): 
        self.raio = raio
        
    def calcularArea(self) -> Medida:
        v = 3.1415 * self.raio.valor * self.raio.valor
        u = self.raio.unidade + '2'
        self.area = Medida(valor=v, unidade=u)
        return self.area

    def calcularPerimetro(self) -> Medida: 
        v = 2 * 3.1415 * self.raio.valor
        u = self.raio.unidade
        self.perimetro = Medida(valor=v, unidade=u)
        return self.perimetro

r = Medida (valor=10, unidade='cm')
c = Circulo(raio=r)
print (r.valor)
print (c.calcularArea().valor)
print (c.calcularPerimetro().valor)
```


### Classe Triângulo

Classe `Triangulo` é subclasse de `FiguraPlana`, que herda os métodos `calcularArea()` e `calcularPerimetro()` e seus contratos. Além disso estabelece, via contratos, que as medidas `a`, `b` e `c` não são nulas e garantem que as medidas satisfazem à condição de existência de um triângulo. 


```python
class Triangulo(FiguraPlana):
    a: Medida
    b: Medida
    c: Medida

    @icontract.ensure(lambda a: a != None)
    @icontract.ensure(lambda b: b != None)
    @icontract.ensure(lambda c: c != None)
    def __init__(self, a:Medida, b:Medida, c:Medida): 
        self.a = a
        self.b = b
        self.c = c

    @icontract.require(lambda self: self.a.valor >= abs(self.b.valor - self.c.valor))
    @icontract.require(lambda self: self.b.valor >= abs(self.a.valor - self.c.valor))
    @icontract.require(lambda self: self.c.valor >= abs(self.a.valor - self.b.valor))
    def calcularArea(self) -> Medida: 
        v = self.a.valor * self.b.valor / 2
        u = self.a.unidade + '2'
        self.area = Medida(valor=v, unidade=u)
        return self.area

t1 = Triangulo(a = Medida(3, 'cm'), b = Medida(4, 'cm'), c = Medida (5, 'cm'))
print(t1.calcularArea().valor, t1.calcularArea().unidade)
```



```python
r = Medida(valor=10, unidade='cm')
c = Circulo(raio=r)
print(c.calcularArea().valor)
print(c.calcularPerimetro().valor)
```


---


## Exemplo 2: Aluno e Turma

### Classe Aluno

Classe `Aluno` possui uma cláusula **invariant** que estabelece que, em momento algum, o aluno terá sua matricula inválida com um valor menor ou igual a zero. Desse modo, qualquer alteração no campo matricula de um objeto, essa condição será sempre verificada. 

Além disso, a classe `Aluno`também impede, pela cláusula de pré-condição no construtor, que seja instanciado um objeto com nome igual a nulo. 


```python
import icontract

@icontract.invariant(lambda self: self.matricula > 0)
class Aluno: 
    nome: str
    matricula: int
    telefone: str
    email: str

    @icontract.require(lambda nome: nome != None)
    def __init__(self, nome, matricula):
        self.nome = nome
        self.matricula = matricula
        self.telefone = ''
        self.email = ''
        

    def imprimir(self) -> str:
        str = '';
        str = str + 'Nome: ' + self.nome + '\n'
        return str


```

### Classe Turma
Classe `Turma` estabele como **invariante** que nunca haverá uma turma com número de alunos inválido (negativo).  
Além disso, estabelece como **pré-condição** para realizar a matrícula de um aluno, que seu nome não seja nulo.  
Ela ainda garante ao final da matrícula (**pós-condição**) que o número de alunos da turma aumentou em uma unidade. 


```python
@icontract.invariant(lambda self: len(self.alunos) >= 0)
class Turma:
    disciplina: str
    codigo: int

    def __init__(self, disciplina, codigo): 
        self.disciplina = disciplina
        self.codigo = codigo
        self.alunos = []


    @icontract.snapshot(lambda self: self.alunos)
    @icontract.require(lambda aluno: aluno.nome != None)
    @icontract.ensure(lambda self, OLD: len(self.alunos) == len(OLD.alunos) + 1)
    def matricular(self, aluno): 
        print(len(self.alunos))
        self.alunos.append(aluno)


    def imprimir(self) -> str: 
        str = ''
        str = str + self.disciplina + ' - ' + 'Turma: ' + self.codigo + '\n'
        for a in self.alunos: 
            str = str + a.imprimir() + '\n'
        return str
            

def __main__():
    a = Aluno(nome='andre', matricula=13)
    b = Aluno(nome='luiz', matricula=14)
    # c = Aluno(nome=None)
    
    t = Turma(disciplina='Orientacao por Objetos', codigo='1')
    t.matricular(aluno=a)
    t.matricular(aluno=b)
    # t.matricular(aluno=c)
    print(t.imprimir())
    
    # b = Aluno(nome='luiz')
    # b.nome = 'Luiz'
    # print (b.imprimir())

__main__()
```

**Exercicios de fixacao**
