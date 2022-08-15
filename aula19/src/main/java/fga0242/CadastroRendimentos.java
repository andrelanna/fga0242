package main.java.fga0242;

public class CadastroRendimentos {
	private String[] nomeRendimento;
	private float[] valor;
	private float valorTotalRendimentos;

	public CadastroRendimentos() {
		nomeRendimento = new String[0];
		valor = new float[0];
	}

	public String[] getNomeRendimento() {
		return nomeRendimento;
	}

	public void setNomeRendimento(String[] nomeRendimento) {
		this.nomeRendimento = nomeRendimento;
	}

	public float[] getValor() {
		return valor;
	}

	public void setValor(float[] valor) {
		this.valor = valor;
	}

	public float getValorTotalRendimentos() {
		return valorTotalRendimentos;
	}

	public void setValorTotalRendimentos(float valorTotalRendimentos) {
		this.valorTotalRendimentos = valorTotalRendimentos;
	}

	/**
	 * @param irpf TODO
	 * @param nome
	 * @param v
	 * @return
	 */
	float cadastrarRendimento(String nome, float v) {
		String[] tempRendimento = new String[numeroRendimentos() + 1];
		float[] tempValorRendimento = new float[numeroRendimentos() + 1];
		
		for (int i=0; i<numeroRendimentos(); i++) {
			tempRendimento[i] = getNomeRendimento()[i];
			tempValorRendimento[i] = getValor()[i];
		}
		tempRendimento[numeroRendimentos()] = nome;
		tempValorRendimento[numeroRendimentos()] = v;
		
		setNomeRendimento(tempRendimento);
		setValor(tempValorRendimento);
		
		
		setValorTotalRendimentos(valorTotalRendimentos + v); 
		return valorTotalRendimentos;
	}

	/**
	 * @return
	 */
	int numeroRendimentos() {
		return nomeRendimento.length;
	}
}