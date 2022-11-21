package app;

import exception.MedidaInvalidaException;
import exception.TrianguloInvalidoException;

public class Triangulo {

	int a, b, c; //lados do triangulo
	
	
	public Triangulo(int a, int b, int c) throws MedidaInvalidaException {
		if (a <= 0 || b <= 0 || c <= 0) {
			throw new MedidaInvalidaException();
		}
		this.a = a; 
		this.b = b; 
		this.c = c; 
	}


	public boolean ehTriangulo() throws TrianguloInvalidoException {
		boolean resposta = false; 
		
		//teste da propriedade do triangulo
		resposta = a > Math.abs(b - c) && a < Math.abs(b + c);
		resposta = b > Math.abs(a - c) && b < Math.abs(a + c) && resposta;
		resposta = c > Math.abs(b - a) && c < Math.abs(b + a) && resposta;
		
		if (resposta == false) {
			throw new TrianguloInvalidoException();
		}
		return resposta;
	}

}
