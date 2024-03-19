package assertions;

public class ExemploAssertion2 {
	
	public boolean ehMaior(int x, int y) {
		System.out.println("Entrei no metodo ehMaior()");
		return x > y;
	}

	
	public static void main(String[] args) {
		ExemploAssertion2 e = new ExemploAssertion2();
		
		System.out.println("Habilitando/desabilitando asserção");
		boolean x = e.ehMaior(2, 3);
		assert (x); 
	}
}
