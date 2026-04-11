package testesParametrizados.app;

public class Calculadora {
	
	private int op1;
	private int op2;
	private int resultado;
	private float resultadoFloat; 

	public Calculadora(int op1, int op2) {
		this.op1 = op1; 
		this.op2 = op2; 
	}
	
	public Calculadora() {
	}

	public Calculadora(int op1) {
		this.op1 = op1;
	}

	public int soma() {
		resultado = op1 + op2; 
		return resultado; 
	}
	
	public int subtracao() {
		resultado = op1 - op2;
		return resultado;
	}
	
	public float raizQuadrada() {
		resultadoFloat = (float)Math.sqrt(op1);
		return resultadoFloat;
	}

	public void setOperando1(int i) {
		this.op1 = i;
	}

	public void setOperando2(int i) {
		this.op2 = i;
	}
}
