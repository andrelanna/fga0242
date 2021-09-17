package app;

import excecoes.*;

public class Calculadora {
	private short i;
	private short j;
	
	public Calculadora(short i, short j) {
		this.i = i;
		this.j = j;
	}
	
	public int subtracao() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		
		if(this.i - this.j < -32768) {
			System.out.println("Inferior");
			throw new 	LimiteSuperiorExtrapoladoException();
		} else if (this.i - this.j > 32767) {
			System.out.println("Superior");
			throw new LimiteInferiorExtrapoladoException();
		}
		
		System.out.println("No intervalo");
		return this.i - this.j;
	}
	
	public int soma() throws LimiteSuperiorExtrapoladoException, LimiteInferiorExtrapoladoException {
		
		if(this.i + this.j < -32768) {
			System.out.println("Inferior");
			throw new 	LimiteSuperiorExtrapoladoException();
		} else if (this.i + this.j > 32767) {
			System.out.println("Superior");
			throw new LimiteInferiorExtrapoladoException();
		}
		
		System.out.println("No intervalo");
		
		return this.i + this.j;
	}
	
}
