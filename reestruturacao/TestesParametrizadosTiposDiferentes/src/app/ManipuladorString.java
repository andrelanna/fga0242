package app;

public class ManipuladorString {

	private String fonte;

	public ManipuladorString(String fonte) {
		this.fonte = fonte; 
	}

	public String executar(int qtde, char op) {
		String resposta = "";
		if (op == 'y') {
			for (int i=0; i<qtde; i++) {
				resposta += fonte; 
			}
		} else if (op == 'x') {
			resposta = fonte.substring(qtde);
		}
		return resposta;
	}

}
