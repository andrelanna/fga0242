
public class Ordenacao {

	String fonte;
	private String novo; 
	
	public Ordenacao(String original) {
		fonte = original;
	}

	public int ordenar() {
		
		char[] fonte = this.fonte.toCharArray();
		char[] novo = fonte.clone();
		
		for (int i=0; i < fonte.length; i++) {
			char atual = fonte[i];
			int j; 
			for (j=i+1; j< fonte.length; j++) {
				char proximo = fonte[j];
				if (atual != proximo) {
					novo[i] = fonte[j];
					novo[j] = fonte[i];
					i = j; 
					break; 
				}
			}
		}
		
		int iguais = 0; 
		for (int i=0; i< fonte.length; i++) {
			if (fonte[i] == novo[i]) {
				iguais++;
			}
		}
		
		return iguais;
		 
	}

}
