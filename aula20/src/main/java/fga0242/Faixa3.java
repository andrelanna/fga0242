package main.java.fga0242;

public class Faixa3 extends Imposto{

	protected static final float TAMANHO3AFAIXA = 924.40f;

	public float getOcupacaoFaixa(IRPF irpf) {
		float ocupacao3afaixa = 0 ;
		if (irpf.getBaseDeCalculo() > Faixa1.TAMANHO1AFAIXA + Faixa2.TAMANHO2AFAIXA + Faixa3.TAMANHO3AFAIXA) { //ocupou a 3a faixa inteira
			ocupacao3afaixa = Faixa3.TAMANHO3AFAIXA;
		} else {
			if (irpf.getBaseDeCalculo() > Faixa1.TAMANHO1AFAIXA + Faixa2.TAMANHO2AFAIXA) { //ocupou parte da 3a faixa
				ocupacao3afaixa = irpf.getBaseDeCalculo() - (Faixa1.TAMANHO1AFAIXA + Faixa2.TAMANHO2AFAIXA);
			}
		}
		return ocupacao3afaixa;
	}


}
