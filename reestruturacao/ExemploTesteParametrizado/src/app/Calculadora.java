package app;

public class Calculadora {
	int op1, op2; 
	int resultado; 
	
	public Calculadora(int op1, int op2) {
		this.op1 = op1;
		this.op2 = op2; 
	}
	
	public int soma() {
		resultado = op1 + op2;
		return resultado;
	}
	
	
	public int subtracao() {
		resultado = op1 - op2;
		return resultado;
	}
	
	public int multiplicacao() {
		resultado = op1 * op2;
		return resultado;
	}
	
	public float divisao() {
		float resultado = (float)op1 / (float)op2;
		return resultado;
	}
}













