package exercicios.app;

public class Triangulo {

	private float lado;

	public Triangulo(float lado) {
		this.lado = lado;
	}

	public float calcularArea() {
		return (float)(lado * lado * Math.sqrt(3) / 4);
	}

	public float calcularPerimetro() {
		return 3 * lado;
	}
}
