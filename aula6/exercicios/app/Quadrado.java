package exercicios.app;

public class Quadrado {

	private float lado;

	public Quadrado(float lado) {
		this.lado = lado; 
	}

	public float calcularArea() {
		return lado * lado;
	}

	public float calcularPerimetro() {
		return 4 * lado;
	}
	
}
