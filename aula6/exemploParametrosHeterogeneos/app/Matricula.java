package exemploParametrosHeterogeneos.app;

public class Matricula {

	private int ano;
	private int semestre;
	private int sequencial;

	public Matricula(int ano, int semestre, int sequencial) {
		this.ano = ano; 
		this.semestre = semestre; 
		this.sequencial = sequencial;
	}

	public String getTxt() {
		return "" + ano + "/" + semestre + sequencial;
	}

}
