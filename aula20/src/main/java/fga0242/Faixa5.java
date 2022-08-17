package main.java.fga0242;

public class Faixa5 extends Imposto{


	public float getOcupacaoFaixa(IRPF irpf) {
		float ocupacao5aFaixa = 0;
		if (irpf.getBaseDeCalculo() > Faixa1.TAMANHO1AFAIXA + Faixa2.TAMANHO2AFAIXA + Faixa3.TAMANHO3AFAIXA + Faixa4.TAMANHO4AFAIXA) { //avancou pela 5a faixa
			ocupacao5aFaixa = irpf.getBaseDeCalculo() - (Faixa1.TAMANHO1AFAIXA + Faixa2.TAMANHO2AFAIXA + Faixa3.TAMANHO3AFAIXA + Faixa4.TAMANHO4AFAIXA);
		}
		return ocupacao5aFaixa;
	}

}
