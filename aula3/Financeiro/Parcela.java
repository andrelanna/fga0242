package Financeiro;

public class Parcela {
	
	float pmt; 
	float juros; 
	float amortizacao;
	
	public Parcela(float pmt, float juros, float amortizacao) {
		this.pmt = pmt;
		this.juros = juros;
		this.amortizacao = amortizacao;
	}

	public float getJuros() {
		return juros;
	}
}
