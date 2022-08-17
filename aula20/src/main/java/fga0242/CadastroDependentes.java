package main.java.fga0242;

public class CadastroDependentes {
	public String[] dependentes;
	static final float DEDUCAODEPENDENTE = 189.59f;

	public CadastroDependentes() {
		dependentes = new String[0];
	}

	public boolean cadastrarDependente(String dependente) {
		//Criar um vetor com uma posicao adicional
		String tempDependentes[] = new String[dependentes.length + 1];
		
		//Copiar vetor
		for (int i=0; i<dependentes.length; i++) {
			tempDependentes[i] = dependentes[i];
		}
		
		//Adicionar dependente
		for (String d : dependentes) {
			if (d.equalsIgnoreCase(dependente)) {
				return false;
			}
		}
		
		tempDependentes[dependentes.length] = dependente;
		
		//atualizar referencia
		dependentes = tempDependentes;
		return true;
	}

	public boolean possuiDependente(String dependente) {
		for (String d: dependentes) {
			if (d.equalsIgnoreCase(dependente)) {
				return true;
			}
		}
		return false;
	}

	public float getDeducaoDependentes() {
		int numeroDependentes = dependentes.length;
		return numeroDependentes * CadastroDependentes.DEDUCAODEPENDENTE;
	}
}