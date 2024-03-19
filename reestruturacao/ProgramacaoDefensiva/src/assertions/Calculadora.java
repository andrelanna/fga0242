package assertions;

public class Calculadora {
	
	public static int divisao(int a, int b) {
		assert b != 0 : "Denominador igual a zero.";
		
		return a/b;
	}
}
