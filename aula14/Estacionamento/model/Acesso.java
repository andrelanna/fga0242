package model;

/**
 * Registra a entrada e saída de um veículo.
 * Esta é a entidade central para o cálculo da tarifa.
 */
public class Acesso {

    private String placa;
    
    // Usamos 'long' (primitivo) para armazenar os timestamps (epoch millis)
    private long dataHoraEntrada;
    private long dataHoraSaida;

    private double valorPago;

    // Relacionamento: Se nulo, o acesso é AVULSO.
    // Se preenchido, é Proprietario ou Mensalista.
    private Cliente cliente;

    // Construtores, Getters e Setters

    public Acesso() {
    }
    
    public Acesso(String placa, long dataHoraEntrada, Cliente cliente) {
        this.placa = placa;
        this.dataHoraEntrada = dataHoraEntrada;
        this.cliente = cliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public long getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(long dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public long getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(long dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}