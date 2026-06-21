package Classes;

import Exceptions.LimiteInferiorExtrapoladoException;
import Exceptions.LimiteSuperiorExtrapoladoException;

public class Calculadora {
	
	public static int Soma(int a, int b)throws LimiteSuperiorExtrapoladoException{  
		int valor  =   a + b;
		if(valor > 32767) {
			throw new LimiteSuperiorExtrapoladoException();
		}
		if(valor <-32768) {
			throw new LimiteInferiorExtrapoladoException();
		}
		return valor;	
	}
	
	public static int Subtracao(int a, int b)throws LimiteInferiorExtrapoladoException{  
		int valor  =   a - b;
		
		if(valor > 32767) {
			throw new LimiteSuperiorExtrapoladoException();
		}
		if(valor <-32768) {
			throw new LimiteInferiorExtrapoladoException();
		}
		return valor;
	}
}
