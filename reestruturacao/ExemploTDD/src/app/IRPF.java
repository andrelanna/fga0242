package app;

import java.util.Date;
import java.util.HashMap;

public class IRPF {

	CadastroRendimento data = new CadastroRendimento();
	private float previdenciaOficial;
	PessoaFisica[] dependentes; 
	HashMap<PessoaFisica, Float> pensaoAlimenticia; 
	
	public IRPF() {
		data.rendimentos = new Rendimento[0];
		previdenciaOficial = 0; 
		dependentes = new PessoaFisica[0];
		pensaoAlimenticia = new HashMap<PessoaFisica, Float>();
	}
	
	public boolean cadastrarRendimento(String nome, float valor, boolean ehTributavel) {
		return data.cadastrarRendimento(nome, valor, ehTributavel);
	}

	public float getTotalRendimentosTributaveis() {
		float resposta = 0;
		for (Rendimento r: data.rendimentos) {
			if (r.ehTributavel())
				resposta += r.getValor();
		}
		return resposta;
	}

	public float getTotalRendimentos() {
		float resposta = 0;
		for (Rendimento r: data.rendimentos) {
			resposta += r.getValor();
		}
		return resposta;
	}

	public boolean cadastrarPrevidenciaOficial(float f) {
		previdenciaOficial += f; 
		return true;
	}

	public float getTotalPrevidenciaOficial() {
		return previdenciaOficial;
	}

	public boolean cadastrarDependente(String nome, Date nascimento) {
		PessoaFisica pf = new PessoaFisica(nome, nascimento);
		
		//alocar pf no cadastro de dependentes
		PessoaFisica[] temp = new PessoaFisica[dependentes.length + 1];
		for (int i=0; i<dependentes.length; i++) {
			temp[i] = dependentes[i];
		}
		temp[temp.length-1] = pf; 
		
		dependentes = temp; 
		
		if (dependentes[dependentes.length - 1] == pf) {
			return true;
		} else { 
			return false; 
		}
		
	}

	public int getNumDependentes() {
		return dependentes.length;
	}

	public float getDeducaoDependentes() {
		return dependentes.length * 189.59f;
	}

	public PessoaFisica getDependente(String nome) {
		for (PessoaFisica pf : dependentes) {
			if (pf.getNome().equalsIgnoreCase(nome))
				return pf;
		}
		return null;
	}

	public boolean cadastrarPensaoAlimenticia(PessoaFisica alimentando, float f) {
		if (alimentando == null) {
			return false;
		}
		Float p = pensaoAlimenticia.get(alimentando);
		if (p == null) {
			p = new Float(f);
		} else {
			p += f; 
		}
		System.out.println(pensaoAlimenticia.put(alimentando, p));
		System.out.println(pensaoAlimenticia.size());
		return true; 
	}

	public float getPensaoDependente(String alimentando) {
		PessoaFisica a = getDependente(alimentando);
		Float x = pensaoAlimenticia.get(a);
		if (x != null) {
			return pensaoAlimenticia.get(a);
		} else {
			return 0;
		}
	}

	public Float getTotalPensaoAlimenticia() {
		float totalPenAlimenticia = 0; 
		for (PessoaFisica pf : pensaoAlimenticia.keySet()) {
			totalPenAlimenticia += pensaoAlimenticia.get(pf);
		}
		return totalPenAlimenticia;
	}

	public float baseCalculo() {
		float totalRendimentos = 0;
		float totalDeducoes = 0; 
		float baseCalculo; 
		
		for (Rendimento r : data.rendimentos) {
			totalRendimentos += r.getValor();
		}
		
		totalDeducoes += previdenciaOficial;
		for (PessoaFisica d : dependentes) {
			totalDeducoes += 189.59f;
		}
		
		baseCalculo = totalRendimentos - totalDeducoes;
		return baseCalculo;
	}

}






