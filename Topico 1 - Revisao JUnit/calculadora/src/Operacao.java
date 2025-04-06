/**
 * The type Operacao.
 */
public class Operacao {
	
	private short valor1;
	private short valor2;
	private OperacaoTipo operacaoTipo;
	
	/**
	 * Instantiates a new Operacao.
	 *
	 * @param valor1       the valor 1
	 * @param valor2       the valor 2
	 * @param operacaoTipo the operacao tipo
	 */
	public Operacao(final short valor1, final short valor2, final OperacaoTipo operacaoTipo) {
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.operacaoTipo = operacaoTipo;
	}
	
	/**
	 * Gets valor 1.
	 *
	 * @return the valor 1
	 */
	short getValor1() {
		return valor1;
	}
	
	/**
	 * Sets valor 1.
	 *
	 * @param valor1 the valor 1
	 */
	void setValor1(final short valor1) {
		this.valor1 = valor1;
	}
	
	/**
	 * Gets valor 2.
	 *
	 * @return the valor 2
	 */
	short getValor2() {
		return valor2;
	}
	
	/**
	 * Sets valor 2.
	 *
	 * @param valor2 the valor 2
	 */
	void setValor2(final short valor2) {
		this.valor2 = valor2;
	}
	
	/**
	 * Gets operacao tipo.
	 *
	 * @return the operacao tipo
	 */
	OperacaoTipo getOperacaoTipo() {
		return operacaoTipo;
	}
	
	/**
	 * Sets operacao tipo.
	 *
	 * @param operacaoTipo the operacao tipo
	 */
	void setOperacaoTipo(final OperacaoTipo operacaoTipo) {
		this.operacaoTipo = operacaoTipo;
	}
	
}
