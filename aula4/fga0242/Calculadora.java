
package fga0242;

public class Calculadora {

	private int op1;
	private int op2;
	private int resultado;

	public int subtracao(int op1, int op2) {
		this.op1 = op1; 
		this.op2 = op2;
		this.resultado = op1 - op2; 
		
		return this.resultado;
	}

	public int soma(int op1, int op2) {
		this.op1 = op1; 
		this.op2 = op2; 
		this.resultado = op1 + op2;
		
		return this.resultado;
	}

}
