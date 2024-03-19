package exercicio2;

public class Triangulo {
	int l1, l2, l3; 
	
	public Triangulo(int l1, int l2, int l3) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
	}
	
	boolean ehTriangulo() {
		boolean resposta = 
				((l1 > Math.abs(l2 - l3)) && (l1 < l2 + l3)) &&
				((l2 > Math.abs(l1 - l3)) && (l2 < l1 + l3)) &&
				((l3 > Math.abs(l1 - l2)) && (l3 < l1 + l2));
		return resposta; 
	}
}
