package app;

import exceptions.NaoEhTrianguloException;

public class Triangulo {

	private int a;
	private int b;
	private int c;

	public Triangulo(int a, int b, int c) {
		this.a = a; 
		this.b = b; 
		this.c = c;
	}

	public int calcularArea() {
		return a * b / 2 ;
	}

	public int calcularPerimetro() {
		return a + b + c;
	}

	public boolean ehTriangulo() throws NaoEhTrianguloException {
		boolean ehTriangulo = (a >= Math.abs(b-c) && a <= Math.abs(b+c)) &&
						   (b >= Math.abs(a-c) && b <= Math.abs(a+c)) &&
						   (c >= Math.abs(a-b) && c <= Math.abs(a+b));
		if (!ehTriangulo)
			throw new NaoEhTrianguloException();
		return ehTriangulo;
	}

}
