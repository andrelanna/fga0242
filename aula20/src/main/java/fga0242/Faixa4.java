package main.java.fga0242;

public class Faixa4 extends Imposto{

	protected static final float TAMANHO4AFAIXA = 913.63f;

	public float getOcupacaoFaixa(IRPF irpf) {
		float ocupacao4aFaixa = 0; 
		if (irpf.getBaseDeCalculo() > Faixa1.TAMANHO1AFAIXA + Faixa2.TAMANHO2AFAIXA + Faixa3.TAMANHO3AFAIXA + Faixa4.TAMANHO4AFAIXA) { //ocupou a 4a faixa inteira
			ocupacao4aFaixa = Faixa4.TAMANHO4AFAIXA;
		} else {
			if (irpf.getBaseDeCalculo() > Faixa1.TAMANHO1AFAIXA + Faixa2.TAMANHO2AFAIXA + Faixa3.TAMANHO3AFAIXA) { //ocupou parte da 4a faixa
				ocupacao4aFaixa = irpf.getBaseDeCalculo() - (Faixa1.TAMANHO1AFAIXA + Faixa2.TAMANHO2AFAIXA + Faixa3.TAMANHO3AFAIXA);
			}
		}
		return ocupacao4aFaixa;
	}


}
