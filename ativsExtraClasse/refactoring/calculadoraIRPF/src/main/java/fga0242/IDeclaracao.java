package fga0242;

import java.util.List;

import exceptions.CampoEmBrancoOuNuloException;

public interface IDeclaracao {

	boolean cadastrarRendimento(String nomeRendimento, float valor);

	float totalRendimentos();
	float totalRendimentosTributaveis();
	float totalRendimentosIsentos();
	List<Rendimento> pesquisarRendimento(String string);

	boolean cadastrarDependente(String nome, String cpf) throws CampoEmBrancoOuNuloException ;
	int numDependentes();
	float totalDeducoesDependentes();
	Dependente pesquisarDependenteCPF(String cpf);

	boolean cadastrarDeducao(String nomeDeducao, float valorDeducao);

	float totalDeducoes();

	float baseDeCalculo();

	float calcularImposto();
	float impostoFaixa(int f);
	
	
}
