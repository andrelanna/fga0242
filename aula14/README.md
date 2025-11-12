
UnB - Universidade de Brasilia  
FGA - Faculdade do Gama  
FGA0242 - Técnicas de Programação para Plataformas Emergentes

---

## Aula 14 - Refatoração Substituir Método por objeto-método

**Tópicos da aula**
- Refatoração "Substituir Método por objeto-método"

**Slides da aula**
* [Grupo de refatorações - Compondo Métodos](Catalogo_Refatoracao_Compondo_metodos.pdf)

**Exercicios de fixacao**

1. Aplicar "Extrair Método" em IRPF::criarRendimento(), de modo a fatorar o
    método em etapas e/ou eliminar eventuais duplicidades de código. 

2. Aplicar "Substituir método por objeto-método" em IRPF::cadastrarDependente().  
   2.1 Fatorar o método computar no objeto-método, de modo a eliminar
duplicidades de código. 


**Exercício de refatoração da aplicaçao de estacionamento**

Considere um sistema de software para uma empresa que administra estacionamentos
de parceiros terceirizados, como condomínios empresariais. A finalidade do
sistema é gerenciar as operações de múltiplos estacionamentos, controlando o
acesso de veículos e aplicando as regras de tarifação adequadas para diferentes
perfis de usuários, garantindo a correta cobrança e o controle de vagas. Cada
estacionamento parceiro possui características próprias, como localização e
horários de funcionamento específicos para dias úteis e fins de semana/feriados.

As entidades centrais do sistema incluem o ``Parceiro``, que representa o
cliente contratante (dono do estacionamento), e o ``Estacionamento``, que
armazena dados como localização, horários de funcionamento e o número total de
vagas, detalhando também quantas são privativas (reservadas a proprietários) e
quantas são de mensalistas. Para gerenciar os usuários cadastrados, existe uma
entidade ``Cliente`` (com dados como nome e CPF), que se especializa em
``Proprietario`` (controlando o acesso às vagas privativas) e ``Mensalista``
(controlando o pagamento do valor mensal). A entidade transacional chave é o
``Acesso``, que registra a placa, data/hora de entrada e saída, e o valor pago;
esta entidade deve possuir métodos importantes como ``calcularMinutos()`` e,
principalmente, ``calcularValorPagar()``.  O ``Estacionamento``, por sua vez,
teria métodos como ``registrarEntrada()`` e ``registrarSaida(``) para gerenciar
o fluxo de veículos.

As regras de negócio definem três tipos de acesso: o acesso privativo (para
``Proprietarios``) e o acesso de ``Mensalistas`` não sofrem tarifação direta,
mas exigem cadastro e controle (no caso do mensalista, a verificação da
adimplência do seu contrato). O terceiro tipo, o acesso avulso (rotativo), é o
foco da tarifação. O cálculo é baseado em frações de 15 minutos, custando R\$
2,00 cada. Uma regra de desconto estipula que a cada 4 frações completas
(equivalente a uma hora), concede-se um desconto de R\$ 0,50 sobre o total. Por
fim, existe uma regra de teto: se a permanência ultrapassar 30 frações (ou seja,
a partir da 31ª fração, que corresponde a 7 horas e 31 minutos), o cálculo por
frações é descartado e cobra-se o valor fixo da diária de R\$ 55,00.

Para garantir a corretude da lógica de tarifação, os testes unitários devem
focar exaustivamente o método ``calcularValorPagar()`` da classe ``Acesso``.
Conceitualmente, deve-se criar casos de teste que validem os limites da regra:
um teste para uma permanência curta (ex: 30 minutos, 2 frações, resultando em R\$
4,00); um teste que atinja exatamente o primeiro desconto (ex: 60 minutos, 4
frações, resultando em R\$ 7,50); um teste com frações excedentes ao desconto
(ex: 70 minutos, 5 frações, R\$ 9,50); um teste crucial no limite da diária (ex:
450 minutos, 30 frações, R\$ 56,50); e o teste da aplicação da diária (ex: 451
minutos, 31 frações, R\$ 55,00). Adicionalmente, testes devem validar que acessos
vinculados a Proprietarios e Mensalistas adimplentes resultem em valor zero.

Considerando o cenário descrito acima e a implementação da aplicação e testes
presentes na pasta ``Estacionamento'', aplique as seguintes operações de
refatoração nas classes/métodos apresentados abaixo: 

| Classe / método | Operação de refatoração                    |
|:---------------:|:-------------------------------------------|
| CalculadoraTarifa::calcularTarifaAvulsa | Extrair método                             |
| CalculadoraTarifa::finalizarAcesso      | Substituir método por objeto método        |
| CalculadoraTarifa::finalizarAcesso      | Simplificar condicional                    |
