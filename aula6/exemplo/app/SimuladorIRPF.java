package exemplo.app;

import java.util.LinkedList;
import java.util.List;

public class SimuladorIRPF {

	private float totalRendimentos;
	private List<Rendimento> rendimentos;
	private float[] previdenciaOficial;
	private String[] descricaoPrevidenciaOficial;
	
	public SimuladorIRPF() {
		rendimentos = new LinkedList<Rendimento>();
		previdenciaOficial = new float[0];
		descricaoPrevidenciaOficial = new String[0];
	}

	public void cadastrarRendimento(String descricao, float valorRendimento) {
		Rendimento r = new Rendimento(descricao, valorRendimento);
		this.rendimentos.add(r);
		
		this.totalRendimentos += valorRendimento;
	}

	public float getTotalRendimentos() {
		return totalRendimentos;
	}

	public void cadastrarPrevidenciaOficial(String descricaoPrevidenciaOficial, float valor) {
		
		float tempValor[] = new float[previdenciaOficial.length + 1]; 
		String tempDescricao[] = new String[descricaoPrevidenciaOficial.length() + 1];
		
		for (int i=0; i<previdenciaOficial.length; i++) {
			tempValor[i] = this.previdenciaOficial[i];
			tempDescricao[i] = this.descricaoPrevidenciaOficial[i];
		}
		
		tempValor[previdenciaOficial.length] = valor; 
		tempDescricao[previdenciaOficial.length] = descricaoPrevidenciaOficial;
		
		this.previdenciaOficial = tempValor;
		this.descricaoPrevidenciaOficial = tempDescricao;
	}

	public float getTotalDeducaoPrevidenciaOficial() {
		float soma = 0; 
		
		for (float f : previdenciaOficial) {
			soma += f;
		}
		return soma;  
 	}

}






