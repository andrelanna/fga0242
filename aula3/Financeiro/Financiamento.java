package Financeiro;

import financeiroExceptions.PrestacaoMaiorQueMargemException;

public class Financiamento {
	private float pv;
	private int n;
	private float margem;
	private Modalidade[] simulacoes = new Modalidade[0];

	static Financiamento[] financiamentos = new Financiamento[0];
	
	private Financiamento (float pv, int n, float margem) {
		this.pv = pv;
		this.n = n;
		this.margem = margem;
	}

	public static Financiamento criarFinanciamento (float pv, int n, float margem) throws PrestacaoMaiorQueMargemException {
		Financiamento resposta = null;
		
		//se o valor da prestacao for maior do que a margem, nao deve ser gerado financiamento
		if ((pv/n) > margem) { 
			throw new PrestacaoMaiorQueMargemException(pv/n, margem);
		} else { 
			resposta = new Financiamento(pv, n, margem);
		}
		
		return resposta;
	}

	public boolean adicionarSimulacao(Modalidade mod) {
		Modalidade[] temp = new Modalidade[simulacoes.length + 1];
		
		for (int i = 0; i < simulacoes.length ; i++) {
			temp[i] = simulacoes[i];
		}
		
		temp[simulacoes.length] = mod;
		
		simulacoes = temp;
		return true;
	}

	public float getPv() {
		return pv;
	}

	

	public int getN() {
		return n;
	}
}
