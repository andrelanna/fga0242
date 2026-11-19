
public class Calculadora {
	
	private int v1;
	private int v2;

	public Calculadora(int v1, int v2) {
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public int soma() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		int soma = v1 + v2;
		
		return conferirLimites(soma);
	}
	
	public int subtracao() throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		int subtracao = v1 - v2;
		
		return conferirLimites(subtracao);
	}
	
	private int conferirLimites(int valor) throws LimiteInferiorExtrapoladoException, LimiteSuperiorExtrapoladoException {
		if(valor < -32768) {
			throw new LimiteInferiorExtrapoladoException("Limite inferior extrapolado");
		}
		
		if(valor >= 32768) {
			throw new LimiteSuperiorExtrapoladoException("Limite superior extrapolado");
		}
		
		return valor;
	}
}
