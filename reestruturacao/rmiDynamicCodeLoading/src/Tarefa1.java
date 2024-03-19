import java.io.Serializable;
import java.math.BigDecimal;

public class Tarefa1 implements Task<BigDecimal>, Serializable{

	private static final long serialVersionUID = 3878762419520439283L;

	@Override
	public BigDecimal execute() {
		// TODO Auto-generated method stub
		return computarNumero(5);
	}

	private BigDecimal computarNumero(int i) {
		System.out.println("Vou retornar " + i + " como um BigDecimal.");
		return new BigDecimal(i);
	}
	

}
