package app;

import exceptions.CaractereInvalidoException;

public class Forca {

	private String palavraOculta;
	private char[] palavraRevelada;

	public Forca(String palavraOculta) {
		this.palavraOculta = palavraOculta;
		this.palavraRevelada = new char[palavraOculta.length()];
		for (int i=0; i<palavraRevelada.length; i++) {
			palavraRevelada[i] = '*';
		}
		
	}

	public int adivinhar(char c) throws CaractereInvalidoException{
		if (c == '\0') {
			throw new CaractereInvalidoException();
		}
		
		int caracteresRevelados = 0 ;
		for (int i=0; i<palavraOculta.length(); i++) {
			if (palavraOculta.charAt(i) == c) {
				palavraRevelada[i] = c;
				caracteresRevelados++;
			}
		}
		return caracteresRevelados;
	}

	public char[] getPalavraRevelada() {
		return palavraRevelada;
	}

}
