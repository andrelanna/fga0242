package app;

public class Rendimento {

	private String nome;
	private float valor;
	private boolean ehTributavel;

	public Rendimento(String nome, float valor, boolean ehTributavel) {
		this.nome = nome;
		this.valor = valor; 
		this.ehTributavel = ehTributavel;
	}

	public float getValor() {
		return valor;
	}

	public boolean ehTributavel() {
		return ehTributavel;
	}

}
