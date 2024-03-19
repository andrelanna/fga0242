package app;

public class CadastroRendimento {
	Rendimento[] rendimentos;

	public CadastroRendimento() {
	}

	public boolean cadastrarRendimento(String nome, float valor, boolean ehTributavel) {
		
		return new MetodoObjeto(nome, valor, ehTributavel, this).computar();
	}

	int numRendimentos() {
		return rendimentos.length;
	}

}