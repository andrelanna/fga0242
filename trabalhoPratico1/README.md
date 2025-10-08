UnB - Universidade de Brasilia  
FCTE - Faculdade de Ciencias e Tecnologias em Engenharias  
TPPE - Técnicas de Programação para Plataformas Emergentes  
---

Trabalho Prático - Valor 40 pontos. 

Enunciado Geral 

* Os trabalho prático será realizado em 3 etapas, com os conteúdos distribuídos
  da seguinte maneira: 
  - Etapa 1: TDD
  - Etapa 2: Refactoring
  - Etapa 3: Design by Contracts (DbC)

* O trabalho deverá ser realizado em grupos de 3 a 5 alunos. 
* Os grupos deverão ser informados através do formulário presente em [link](xxxx).
* A divisão dos pontos do trabalho será a seguinte: 
  - Etapa 1 (TDD): 10 pontos
  - Etapa 2 (Refactoring): 15 pontos
  - Etapa 3 (DbC): 15 pontos

* O trabalho pode ser desenvolvido na linguagem que o grupo desejar, desde que
  haja 

# Cenário da aplicação

O Campeonato Brasileiro Série A de 2025 é disputado por 20 clubes em sistema de pontos corridos, com 38 rodadas ao longo da temporada. Cada rodada representa uma jornada em que todos os clubes jogam uma partida, enfrentando os demais em turno e returno — ou seja, cada equipe joga contra todas as outras duas vezes, uma em casa e outra fora. Ao final das 38 rodadas, o clube que acumular o maior número de pontos será declarado campeão brasileiro.

A pontuação dos times é definida com base no resultado de cada partida: uma vitória concede 3 pontos ao vencedor, um empate concede 1 ponto a cada equipe, e uma derrota não concede nenhum ponto. A soma desses pontos ao longo das rodadas determina a posição de cada clube na tabela de classificação. Além da pontuação, outros indicadores são fundamentais para definir o desempenho e, em casos de empate, o desempate entre os clubes.

O número de vitórias corresponde à quantidade de jogos em que o clube saiu vencedor. Esse critério é o primeiro a ser considerado em caso de empate na pontuação entre dois ou mais clubes. O saldo de gols é calculado subtraindo o número de gols sofridos do número de gols marcados. Por exemplo, se um time marcou 45 gols e sofreu 30, seu saldo de gols é +15. Esse saldo é o segundo critério de desempate. O número de gols marcados, por sua vez, é a soma total de todos os gols que o clube fez ao longo do campeonato, independentemente dos gols sofridos. Esse indicador é usado como terceiro critério de desempate.

Se ainda houver igualdade após esses três critérios, o confronto direto entre os clubes empatados é considerado, mas apenas quando o empate envolve dois clubes. Caso o empate persista, são analisados os cartões vermelhos recebidos (menor número favorece o clube), depois os cartões amarelos, e, por fim, se necessário, realiza-se um sorteio na sede da Confederação Brasileira de Futebol (CBF).

Esses critérios não apenas definem o campeão, mas também determinam os clubes classificados para competições internacionais e os rebaixados para a Série B. Os seis primeiros colocados garantem vaga na Copa Libertadores da América do ano seguinte, enquanto os clubes entre a sétima e a décima segunda posição se classificam para a Copa Sul-Americana. Já os quatro últimos colocados ao final da 38ª rodada são rebaixados para a Série B de 2026.

Assim, a pontuação, o número de vitórias, o saldo de gols e os gols marcados são elementos centrais que não apenas refletem o desempenho esportivo dos clubes, mas também influenciam diretamente seus destinos na temporada.


# Enunciado do Trabalho Prático 1

Considerando o cenário descrito acima, os grupos deverão desenvolver umaa
aplicação que seja capaz de: 
1)  realizar os sorteios de jogos de cada rodada; 
2)  garantir que não existam dois jogos iguais ao longo de todas as rodadas (por
  jogos iguais entenda jogos com os mesmos times como mandantes e visitantes). 
3)  calcular a pontuação dos times e a classificação a cada rodada, conforme os
  critérios de pontuação apresentados no enunciado (vitória - 3 pontos, empate -
1 ponto, derrota - 0 pontos). 
4)  calcular os números de  vitórias, gols marcados, gols sofridos, e saldos de
gols com base nos resultados dos jogos de cada rodada. 
5)  aplicar o critério de desempate pelo número de vitórias. 

Cada uma dessas funcionalidades deve ser desenvolvida em seu caso de teste
próprio. O conjunto final contendo todos os casos de testes deve ser executado
de uma só vez, através da suíte de testes ``AllTests``.

# Critérios de correção:


# Data de entrega: 

- 22/10/2025, 23:59hs, via moodle da disciplina. 

