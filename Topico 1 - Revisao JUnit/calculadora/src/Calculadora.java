/**
 * The type Calculadora.
 *
 * @author amanda
 */
public class Calculadora {
	
	/**
	 * Calcula short.
	 *
	 * @param operacao the operacao
	 * @return the short
	 */
	
	private static final short limiteInferior = -32768;
	private static final short limiteSuperior = 32767;
	
	public static short calcula(Operacao operacao) throws OperacaoInvalida, LimiteSuperiorExtrapoladoException,
	                                                      LimiteInferiorExtrapoladoException {
		
		if (operacao.getOperacaoTipo() == null) {
			throw new OperacaoInvalida("Operacao não pode ser null");
		}
		
		if (operacao.getOperacaoTipo().equals(OperacaoTipo.SUBTRACAO)) {
			return subtracao(operacao.getValor1(), operacao.getValor2());
		} else {
			return adicao(operacao.getValor1(), operacao.getValor2());
		}
		
	}
	
	private static short subtracao(short valor1, short valor2) {
		
		int temp1 = valor1;
		int temp2 = valor2;
		
		if (temp1 - temp2 > limiteSuperior) {
			throw new LimiteSuperiorExtrapoladoException("Limite Superior Excedido");
		}
		
		if (temp1 - temp2 < limiteInferior) {
			throw new LimiteInferiorExtrapoladoException("Limite inferior Excedido");
		}
		
		return (short) (valor1 - valor2);
	}
	
	private static short adicao(short valor1, short valor2) throws LimiteSuperiorExtrapoladoException,
	                                                               LimiteInferiorExtrapoladoException {
		
		short resultado = (short) (valor1 + valor2);
		
		if (valor1 > 0 && valor2 > 0 && resultado < 0) {
			throw new LimiteSuperiorExtrapoladoException("Limite superior extrapolado");
		}
		
		if (valor1 < 0 && valor2 < 0 && resultado > 0) {
			throw new LimiteInferiorExtrapoladoException("Limite inferior extrapolado");
		}
		
		return resultado;
	}
	
}
