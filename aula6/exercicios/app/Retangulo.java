package exercicios.app;

public class Retangulo {

	private float base;
	private float altura;

	public Retangulo(float base, float altura) {
		this.base = base; 
		this.altura = altura;
	}

	public float calcularArea() {
		return base * altura;
	}

	public float calcularPerimetro() {
		return 2 * base + 2 * altura;
	}
}
