package calculadora;

import exceptions.LimiteInferiorExtrapoladoException;
import exceptions.LimiteSuperiorExtrapoladoException;

public class calculadora {
	
	
	
	public static int add(int a, int b) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException{
		int sum;
		
		sum = a + b;
		
		if (sum > 32768) {
			throw new LimiteSuperiorExtrapoladoException();
		}
		
		if (sum < -32768) {
			throw new LimiteInferiorExtrapoladoException();
		}
		return sum;
	}

	public static int sub(int a, int b) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException{
		return a - b;
	}

	
}

