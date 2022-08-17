package main.java.fga0242;

public class Faixa1 extends Imposto{

	/* Constantes extraídas a partir do código, através da 
	 * operação de refatoração "Extrair Constante". 
	 * 
	 * Todas as ocorrências dos valores foram alteradas para 
	 * utilização das novas constantes. 
	 */
	protected static final float TAMANHO1AFAIXA = 1903.98f;

	
	
	public float getOcupacaoFaixa(IRPF irpf) {
		if (irpf.getBaseDeCalculo() <= Faixa1.TAMANHO1AFAIXA) {
			return irpf.getBaseDeCalculo();
		}
		return Faixa1.TAMANHO1AFAIXA; //por falsificacao
	}


	

	

}
