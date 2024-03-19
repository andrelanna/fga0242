package app;

import exception.DivisaoPorZeroException;

public class Calculadora {

	private int op1;
	private int op2;
	private int soma;
	private int diferenca;
	private int produto;
	private int quociente;

	public void setOp1(int op1) {
		this.op1 = op1;
	}

	public void setOp2(int op2) {
		this.op2 = op2;
	}

	public int soma() {
		this.soma = op1 + op2; 
		return soma;
	}

	public int subtracao() {
		this.diferenca = op1 - op2;  
		return diferenca;
	}

	public int multiplicacao() {
		this.produto = op1 * op2;
		return produto;
	}

	public int divisao() throws DivisaoPorZeroException {
		if (op2 == 0) {
			throw new DivisaoPorZeroException("O denominador eh nulo!");
		}
		this.quociente = op1 / op2;
		return quociente;
	}

}
