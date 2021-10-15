package code;


public class Calculadora {
	private short op1;
	private short op2;

	public Calculadora( short op1, short op2){
		op1 = this.op1;
		op2 = this.op2;
	}
	
	public short subtracao () throws LimiteException {
		short res = (short) (op1 - op2);
		if( op1>0 && -op2>0 && res < 0) 
			throw new LimiteSuperiorExtrapoladoException();
		else if (op1< 0 && -op2<0 && res>0)
			throw new LimiteInferiorExtrapoladoException();
		return res;
	}
	
	public short adicao () throws LimiteException {
		short res = (short) (op1 + op2);
		if( op1>0 && op2>0 && res < 0) 
			throw new LimiteSuperiorExtrapoladoException();
		else if (op1< 0 && op2<0 && res>0)
			throw new LimiteInferiorExtrapoladoException();
		return res;
	}
}
