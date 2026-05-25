package fga0242;

abstract class Rendimento {
	
	private String nome;
	private String tipo;
	private float valor;

	public Rendimento(String nome, String tipo, float valor) {
		this.nome = nome; 
		this.tipo = tipo; 
		this.valor = valor;
	}

	public String getNome() {
		return nome; 
	}

	public String getTipo() {
		return tipo;
	}

	public float getValor() {
		return valor;
	}
}
