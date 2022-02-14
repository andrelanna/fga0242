package app;

import java.util.LinkedList;
import java.util.List;

public class SimuladorIRPF {

	private float totalRendimentos;
	private List<Rendimento> rendimentos;
	
	public SimuladorIRPF() {
		rendimentos = new LinkedList<Rendimento>();
	}

	public void cadastrarRendimento(String descricao, float valorRendimento) {
		Rendimento r = new Rendimento(descricao, valorRendimento);
		this.rendimentos.add(r);
		
		this.totalRendimentos += valorRendimento;
	}

	public float getTotalRendimentos() {
		return totalRendimentos;
	}

}
