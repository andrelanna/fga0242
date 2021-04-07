package estacionamento;

public class Acesso {

	public static final float VALOR_FRACAO = (float) 2.0;
	public static final float VALOR_HORA = (float) 7.0;
	public static final float VALOR_DIARIA = (float) 30.0;
	
	public String placa;
	public int dia, mes, ano;
	public int horaEntrada, 
	           minutosEntrada;
	public int horaSaida, 
			   minutosSaida;
	


	public Acesso() {}

	
	public Acesso(int dia, int mes, int ano, int horaEntrada, int minutosEntrada) { 
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.horaEntrada = horaEntrada;
		this.minutosEntrada = minutosEntrada;
	}
	
	
	public float calcularValor() { 
		int quantidadeHoras = calcularNumeroHoras(); 
		int quantidadeMinutos; 
		
		if (horaSaida == horaEntrada)
			quantidadeMinutos = calcularFracao();
		else if (ehHoraSaidaMaiorQueHoraEntrada() && minutosEntrada == minutosSaida){
			quantidadeMinutos = 0;
			quantidadeHoras = calcularNumeroHoras();
		}
		else if (ehHoraSaidaMaiorQueHoraEntrada() && ehMinutosEntradaMaiorQueMinutosSaida())
			quantidadeMinutos = calcularFracao();
		else if (ehHoraSaidaMaiorQueHoraEntrada() && ehMinutosEntradaMaiorQueMinutosSaida()){
			quantidadeMinutos = minutosSaida + (60 - minutosEntrada);
			quantidadeHoras = calcularNumeroHoras() - 1;
		}
		else {
			quantidadeHoras = 0;
			quantidadeMinutos = 0;
		}
		
		float valorTotal = calcularValorTotal(quantidadeHoras, quantidadeMinutos);		
		
		return retornarValorTotal(quantidadeHoras, valorTotal);
	}


	private float retornarValorTotal(int quantidadeHoras, float valorTotal) {
		if (quantidadeHoras >=9)
			return VALOR_DIARIA;
		else 
			return valorTotal;
	}


	private float calcularValorTotal(int quantidadeHoras, int quantidadeMinutos) {
		float valorTotal = 0; 
		valorTotal += quantidadeHoras * VALOR_HORA;
		valorTotal += Math.ceil(quantidadeMinutos / 15.0) * VALOR_FRACAO;
		return valorTotal;
	}


	private int calcularFracao() {
		int quantidadeMinutos;
		quantidadeMinutos = calcularNumeroDeMinutos();
		return quantidadeMinutos;
	}


	private boolean ehHoraSaidaMaiorQueHoraEntrada() {
		return horaSaida > horaEntrada;
	}


	private int calcularNumeroDeMinutos() {
		return minutosSaida - minutosEntrada;
	}


	private int calcularNumeroHoras() {
		return horaSaida - horaEntrada;
	}


	private boolean ehMinutosEntradaMaiorQueMinutosSaida() {
		return minutosEntrada > minutosSaida;
	}


	public void setHoraSaida(int horaSaida) {
		this.horaSaida = horaSaida;
	}


	public void setMinutosSaida(int minutosSaida) {
		this.minutosSaida = minutosSaida;
	}
	
	
	
}
