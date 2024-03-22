package calculadora.app;


public class Calculadora {

	private int operando1;
	private int operando2;
	private int soma;
	private float operando1f;
	private float operando2f;

	public void setOperando1(int i) {
		this.operando1 = i;
	}

	public void setOperando2(int i) {
		this.operando2 = i;
	}

	public int  soma() {
		this.soma = operando1 + operando2; 
		return soma;
	}

	public int subtracao() {
		return operando1 - operando2;
	}

	public void setOperando1(float f) {
		this.operando1f = f;
	}

	public void setOperando2(float f) {
		this.operando2f = f; 
	}

	public float somaf() {
		return operando1f + operando2f;
	}

}
