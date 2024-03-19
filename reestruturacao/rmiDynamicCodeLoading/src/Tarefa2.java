import java.io.Serializable;

public class Tarefa2 implements Task<Integer[]>, Serializable{

	private static final long serialVersionUID = -8289864776811668225L;
	private Integer[] inteiros;

	public Tarefa2() {
		inteiros = new Integer[] {2, 5, 3, 1, 9, 7, 4, 10, 7, 8, 6};
	}
	
	@Override
	public Integer[] execute() {
		Integer[] resposta = sort(); 
		return resposta;
	}

	private Integer[] sort() {
		System.out.println("Iniciando sort");
		System.out.println("Vetor original: ");
		for (Integer i : inteiros) {
			System.out.print(i + ", ");
		}
		Integer[] buffer = inteiros.clone();
		for (int i=0; i<buffer.length; i++) {
			for (int j=i+1; j<buffer.length; j++) {
				if (buffer[i] > buffer[j]) {
					Integer t = buffer[i];
					buffer[i] = buffer[j];
					buffer[j] = t;
				}
			}
		}
		return buffer;
	}

}
