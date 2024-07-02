package app;

public class Palindromo {

	protected String sentenca;

	public Palindromo() {
		super();
	}

	public Palindromo(String str) {
		this.sentenca = str;
	}

	public boolean ehPalindromo() {
		boolean resposta = true; 
		char[] str = sentenca.toCharArray();
		resposta = testeEquivalencia(resposta, str);
		return resposta;
	}
	
	protected boolean testeEquivalencia(boolean resposta, char[] str) {
		int j = str.length-1;
		for (int i=0; i<str.length/2; i++) {
			if (str[i] == ' ') {
				do {
					i++;
				} while (str[i] == ' ');
			}
			if (str[j] == ' ') {
				do {
					j--;
				} while (str[j] == ' ');
			}
			if (comparar(str, j, i))
				resposta = false;
			j--;
		}
		return resposta;
	}

	private boolean comparar(char[] str, int j, int i) {
		return (Character.toUpperCase(str[i]) != 
				Character.toUpperCase(str[j]));
	}

}