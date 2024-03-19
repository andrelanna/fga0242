package exercicio3;

import java.util.LinkedList;
import java.util.List;

public class EditorTexto {

	private String texto;
	private String comando;
	private String argumento;

	public EditorTexto(String texto, String comando, String argumento) {
		this.texto = texto; 
		this.comando = comando;
		this.argumento = argumento;
	}

	public List<String> computar() {
		List<String> resposta = new LinkedList<String>();
		if (comando.equals("5l")) {
			int posicao = Integer.parseInt(argumento);
			String retorno = texto.substring(posicao, 5);
			resposta.add(retorno);
		} else if (comando.equals("split")) {
			String[] retorno = texto.split(argumento);
			for (String r: retorno)
				resposta.add(r);
		}
		return resposta;
	}

}
