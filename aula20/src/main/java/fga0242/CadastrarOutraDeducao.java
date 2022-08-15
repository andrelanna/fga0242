package main.java.fga0242;

public class CadastrarOutraDeducao {
	
	IRPF fonte; 
	String nome; 
	int valor; 
	String[] tempOutraDeducao;
	int[] tempValorOutraDeducao;
	
	public CadastrarOutraDeducao(IRPF f, String n, int v) {
		fonte = f; 
		nome = n; 
		valor = v; 
	}
	
	public void computar() {
		criarNovoVetorDeDeducoes();

		copiarVetores();
		adicionarNovaDeducao();

		//atualizar as referencias
		atualizarVetores();
	}

	/**
	 * 
	 */
	private void atualizarVetores() {
		fonte.outraDeducao = tempOutraDeducao;
		fonte.valorOutraDeducao = tempValorOutraDeducao;
	}

	/**
	 * 
	 */
	private void adicionarNovaDeducao() {
		//adicionar cadastro nos vetores temporarios
		tempOutraDeducao[fonte.outraDeducao.length] = nome;
		tempValorOutraDeducao[fonte.valorOutraDeducao.length] = valor;
	}

	/**
	 * 
	 */
	private void copiarVetores() {
		//copiar um vetor para o outro;
		for (int i=0; i<fonte.outraDeducao.length; i++) {
			tempOutraDeducao[i] = fonte.outraDeducao[i];
			tempValorOutraDeducao[i] = fonte.valorOutraDeducao[i];
		}
	}

	/**
	 * 
	 */
	private void criarNovoVetorDeDeducoes() {
		//Adicionar uma posicao nova nos vetores de nome e valor
		tempOutraDeducao = new String[fonte.outraDeducao.length + 1];
		tempValorOutraDeducao = new int[fonte.valorOutraDeducao.length + 1];
	}
}
