package calculadora;

public class Calculadora {
	private static short limiteInferior = -32768;
	private static short limiteSuperior = 32767;
	
	
	public static short soma(int op1, int op2) throws LimiteinferiorException, LimiteSuperiorException {
		int sum = op1 + op2;
		if(sum>limiteSuperior) {
			throw new LimiteSuperiorException();
		}
		if (sum<limiteInferior) {
			throw new LimiteinferiorException();
		}
		return (short) sum;
	}


public static short subtracao(int a, int b) throws LimiteinferiorException, LimiteSuperiorException {
	int sum = a - b;
	if(sum>limiteSuperior) {
		throw new LimiteSuperiorException();
	}
	if (sum<limiteInferior) {
		throw new LimiteinferiorException();
	}
	return (short) sum;
}

}
