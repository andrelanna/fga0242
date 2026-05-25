package fga0242;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.List;

import exceptions.CampoEmBrancoOuNuloException;

class Declaracao implements IDeclaracao{
	
	private String nome;
	private String cpf;
	
	private List<Rendimento> rendimentos;
	private float totalRendimentos;
	private float totalRendimentosTributaveis;
	private float totalRendimentosIsentos;
	
	private List<Dependente> dependentes;
	private List<Deducao> deducoes;
	
	private float baseDeCalculo;
	private float[] imposto;

	Declaracao(String nome, String cpf) {
		this.nome = nome; 
		this.cpf = cpf;
		
		rendimentos = new LinkedList<Rendimento>();
		dependentes = new LinkedList<Dependente>();
		
		deducoes = new LinkedList<Deducao>();
		
		imposto = new float[5];
	}

	public String getCPF() {
		return cpf;
	}

	public boolean cadastrarRendimento(String nomeRendimento, float valor) {
		Rendimento r = null;
		if (ehSalario(nomeRendimento)) {
			r = new Salario(valor);
			somarEmTributavel(r);
		}
		if (ehAluguel(nomeRendimento)) {
			r = new Aluguel(valor); 
			somarEmTributavel(r);
		} 
		if (ehRendimentoTributavel(nomeRendimento)) {
			r = new RendimentoTributavel(valor);
			somarEmTributavel(r);
		} 
		if (ehBolsaDeEstudo(nomeRendimento)) {
			r = new BolsaDeEstudo(valor);
			somarEmIsentos(r);
		} 
		if (ehRendimentoIsento(nomeRendimento)) {
			r = new RendimentoIsento(valor);
			somarEmIsentos(r);
		}
		totalRendimentos += r.getValor();
		return rendimentos.add(r);
		
	}

	private boolean ehRendimentoIsento(String nomeRendimento) {
		return nomeRendimento.equalsIgnoreCase(Constantes.RENDIMENTO_ISENTO);
	}

	private boolean ehBolsaDeEstudo(String nomeRendimento) {
		return nomeRendimento.equalsIgnoreCase(Constantes.BOLSA_DE_ESTUDO);
	}

	private boolean ehRendimentoTributavel(String nomeRendimento) {
		return nomeRendimento.equalsIgnoreCase(Constantes.RENDIMENTO_TRIBUTÁVEL);
	}

	private boolean ehAluguel(String nomeRendimento) {
		return nomeRendimento.equalsIgnoreCase(Constantes.ALUGUEL);
	}

	private boolean ehSalario(String nomeRendimento) {
		return nomeRendimento.equalsIgnoreCase(Constantes.SALÁRIO);
	}
	
	private boolean ehIgual(String nomeRendimento, String rendimento) {
		return nomeRendimento.equalsIgnoreCase(rendimento);
	}

	private void somarEmIsentos(Rendimento r) {
		totalRendimentosIsentos += r.getValor();
	}

	private void somarEmTributavel(Rendimento r) {
		totalRendimentosTributaveis += r.getValor();
	}

	public float totalRendimentos() {
		return totalRendimentos;
	}

	public float totalRendimentosTributaveis() {
		return totalRendimentosTributaveis;
	}

	public float totalRendimentosIsentos() {
		return totalRendimentosIsentos;
	}

	public List<Rendimento> pesquisarRendimento(String nomeRendimento) {
		List<Rendimento> resposta = new LinkedList<Rendimento>();
		for (Rendimento r : rendimentos) {
			if (r.getNome().equalsIgnoreCase(nomeRendimento) ) {
				resposta.add(r);
			}
		}
		return resposta;
	}

	public boolean cadastrarDependente(String nome, String cpf) throws CampoEmBrancoOuNuloException {
		if (nome == null || nome.isBlank() || nome.isEmpty()) {
			throw new CampoEmBrancoOuNuloException("nome");
		} else if (cpf == null || cpf.isBlank() || cpf.isEmpty()) {
			throw new CampoEmBrancoOuNuloException("cpf");
		} 
		
		Dependente dep = pesquisarDependenteCPF(cpf);
		if (dep != null) {
			return false; 
		}
		
		dep = new Dependente(nome, cpf);
		return dependentes.add(dep);
	}

	public int numDependentes() {
		return dependentes.size();
	}

	public float totalDeducoesDependentes() {
		return dependentes.size() * 189.59f;
	}

	public Dependente pesquisarDependenteCPF(String cpf) {
		Dependente resposta = null; 
		for (Dependente d : dependentes) {
			if (cpf.equalsIgnoreCase(d.getCPF())) {
				resposta = d;
				break;
			}
		}
		return resposta;
	}

	public boolean cadastrarDeducao(String nomeDeducao, float valorDeducao) {
		Deducao d = new Deducao(nomeDeducao, valorDeducao);
		
		return deducoes.add(d);
	}

	public float totalDeducoes() {
		float totalDeducoes = 0;
		totalDeducoes += totalDeducoesDependentes();
		for (Deducao d : deducoes) {
			totalDeducoes += d.getValorDeducao();
		}
		return totalDeducoes;
	}

	public float baseDeCalculo() {
		baseDeCalculo = totalRendimentos();
		baseDeCalculo -= totalRendimentosIsentos();
		baseDeCalculo -= totalDeducoes();
		return baseDeCalculo;
	}

	public float calcularImposto() {
		float restante = baseDeCalculo();
		
		if (restante > 4664.68f) {
			float imposto5aFaixa = (restante - 4664.68f) * 0.275f;
			BigDecimal bd = new BigDecimal(Float.toString(imposto5aFaixa));
			bd = bd.setScale(2, RoundingMode.HALF_EVEN);
			imposto[4] = bd.floatValue(); 
			restante -= (restante - 4664.68f) ;
		} 
		if (restante > 3751.05f) {
			float imposto4aFaixa = (restante - 3751.05f) * 0.225f;
			BigDecimal bd = new BigDecimal(Float.toString(imposto4aFaixa));
			bd = bd.setScale(2, RoundingMode.HALF_EVEN);
			imposto[3] = bd.floatValue(); 
			restante -= (restante - 3751.05f);
		}
		if (restante > 2826.65f) {
			float imposto3aFaixa = (restante - 2826.65f) * 0.15f;
			BigDecimal bd = new BigDecimal(Float.toString(imposto3aFaixa));
			bd.setScale(2, RoundingMode.HALF_EVEN);
			imposto[2] = bd.floatValue(); 
			restante -= (restante - 2826.65f); 
		}
		if (restante >= 2428.80f) {
			float imposto2aFaixa = (restante - 2428.80f) * 0.075f;
			BigDecimal bd = new BigDecimal(Float.toString(imposto2aFaixa));
			bd = bd.setScale(2, RoundingMode.HALF_EVEN);
			imposto[1] = bd.floatValue();
			restante -= (restante - 2428.80f);
		}
		if (restante > 0) {
			float imposto1aFaixa = (restante) * 0f;
			imposto[0] = imposto1aFaixa;
			restante = 0;
		}
		
		float valorImposto = 0; 
		for (float i : imposto) {
			valorImposto += i; 
		}
		BigDecimal bd = new BigDecimal(Float.toString(valorImposto));
		bd = bd.setScale(2, RoundingMode.HALF_EVEN);
		return bd.floatValue();
	}

	public float impostoFaixa(int f) {
		return imposto[f-1];
	}

	

}
