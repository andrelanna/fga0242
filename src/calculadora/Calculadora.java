package calculadora;

import exceptions.LimiteInferiorExtrapoladoException;
import exceptions.LimiteSuperiorExtrapoladoException;
import exceptions.LimiteSuperiorExtrapoladoException;

public class Calculadora {
	private short numero1;
	private short numero2;
	
	public Calculadora(short numero1, short numero2) {
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	
	
	public int adicao() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException
	{
		int resultado = this.numero1 + this.numero2;
		
		if(resultado < -32768) {
			throw new 	LimiteSuperiorExtrapoladoException();
		}
		else if(resultado > 32767) {
			throw new LimiteInferiorExtrapoladoException();
		}
		
		return resultado;
		}
	


	public int subtracao() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException
	{
		int resultado = this.numero1 - this.numero2;
		
		if(resultado < -32768) {
			throw new 	LimiteSuperiorExtrapoladoException();
		}
		else if(resultado > 32767) {
			throw new LimiteInferiorExtrapoladoException();
		}
		
		return resultado;
	}

}
	
	

