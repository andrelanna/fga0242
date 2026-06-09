package fga0242.figurasGeometricas;

public class Medida {

	private int valor;
	private String unidade;

	public Medida(int valor, String unidade) {
		this.valor = valor;
		this.unidade = unidade;
	}

	public static Medida getMedida(int valor, String unidade) {
		assert(valor > 0);
		assert(unidade != null && !unidade.isBlank() && !unidade.isEmpty()); 
		
		Medida m = new Medida(valor, unidade);
		
		return m;
	}

	public int getValor() {
		return valor;
	}

	public String getUnidade() {
		return unidade;
	}

}
