package assertions;

public class ExemploAssertion {

	public static void main(String[] args) {
		int x; 
		x = Calculadora.divisao(5, 3);
		System.out.println(x);
		
		x = Calculadora.divisao(5, 0);
		System.out.println(x);
	}

}
