package cliente2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tarefa3 implements Task<List<String>>, Serializable{

	private static final long serialVersionUID = 6104019407564735160L;
	private List<String> listaNomes;

	public Tarefa3() {
		listaNomes = new ArrayList<String>();
	}
	
	
	public List<String> execute() {
		List<String> listaOrdenada = ordenar();
		return listaOrdenada;
	}
	
	public boolean adicionarNome(String nome) {
		System.out.println("Adicionando " + nome + "na lista de nomes");
		return listaNomes.add(nome);
	}

	private List<String> ordenar() {
		System.out.println("Iniciando a ordenação de nomes em " + this);
		List<String> ListaOrdenada = new ArrayList<String>();
		
		ListaOrdenada.add(0, listaNomes.get(0));
		
		for (int i=0; i < listaNomes.size(); i++) {
			String nome = listaNomes.get(i);
			
			for (int j=0; j<i; j++) {
				if (nome.compareToIgnoreCase(ListaOrdenada.get(j)) < 0) {
					ListaOrdenada.add(j, nome);
				}
			}
		}
		return ListaOrdenada;
	}
	
	

}
