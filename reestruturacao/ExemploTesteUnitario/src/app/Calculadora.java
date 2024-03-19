package app;

public class Calculadora {

	private boolean adicionou;

	public int soma(int i, int j) {
		return i+j;
	}

	public int subtracao(int i, int j) {
		return i-j;
	}

	public void adicionou(boolean b) {
		adicionou = b;
	}

	public boolean getAdicionou() {
		return adicionou;
	}

}
