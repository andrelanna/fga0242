package exemplo;

public class Calculadora {

	int op1, op2, resultado;
	
	public int divisao(int i, int j) throws DivisaoPorZeroException, InterruptedException{
		op1 = i; 
		op2 = j;
		
		if (op2 == 0) { 
			throw new DivisaoPorZeroException();
		}		
		
		resultado = op1 / op2;
		
		Thread.sleep(1300);
		
		return resultado;
	}

	public int  raiz(int i, int j) throws InterruptedException {
		op1 = i; 
		op2 = j;
		
		if (op1 < 0 && (op2 %2 == 0 ? true : false ))
			throw new RaizDeNegativoException();
		
		resultado = (int)Math.pow(op1, ((float)1/op2));
		
		Thread.sleep(2000);
		
		return resultado;
	}

}
