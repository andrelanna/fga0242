package main.java.fga0242;

public class Faixa2 extends Imposto{

	protected static final float TAMANHO2AFAIXA = 922.67f;

	public float getOcupacaoFaixa(IRPF irpf) {
		float ocupacao2aFaixa = 0;
		if (irpf.getBaseDeCalculo() > Faixa1.TAMANHO1AFAIXA + Faixa2.TAMANHO2AFAIXA) { //ocupou 2a faixa inteira 
			ocupacao2aFaixa = Faixa2.TAMANHO2AFAIXA;
		} else {
			if (irpf.getBaseDeCalculo() > Faixa1.TAMANHO1AFAIXA) { //ocupou parte da 2a faixa; 
				ocupacao2aFaixa = irpf.getBaseDeCalculo() - Faixa1.TAMANHO1AFAIXA;
			}
		}
		return ocupacao2aFaixa;
	}


	

	
}
