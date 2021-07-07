package Financeiro;

import financeiroExceptions.PrestacaoMaiorQueMargemException;
import financeiroExceptions.TaxaDeJurosInvalidaException;

public abstract class Modalidade {

	String banco;
	float i;
    Financiamento fin;
    Parcela[] parcelas;

	Modalidade(String banco, float i) {
		this.banco = banco;
		this.i = i;
	}
	
	public static Modalidade criarSimulacao(String modalidade, String banco, float i) throws TaxaDeJurosInvalidaException {
		Modalidade resposta = null;
		if (i == 0.0f) {
			throw new TaxaDeJurosInvalidaException();
		}
		
		if (modalidade.equalsIgnoreCase("Price"))
			resposta = new Price(banco, i);
		else 
			resposta = null;
		return resposta;
	}

	public abstract float calcularPrestacoes() ;

	public void adicionarFinanciamento(Financiamento fin) {
		this.fin = fin;
	}

	public float calcularTotalJuros() {
		float juros = 0;
		System.out.println(parcelas.length);
		for (Parcela p : parcelas) {
			juros += p.getJuros();
		}
		return juros;
	}
	
}
