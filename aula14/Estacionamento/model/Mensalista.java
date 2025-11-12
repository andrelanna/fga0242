package model;

/**
 * Representa o cliente que paga um valor fixo mensal.
 * Herda de Cliente.
 */
public class Mensalista extends Cliente {

    private double valorMensal;
    
    // Usamos 'long' (primitivo) para armazenar o timestamp (epoch millis) do vencimento
    private long dataVencimento; 

    /**
     * Verifica se o mensalista está adimplente na data/hora atual.
     * @param horaAtualTimestamp O timestamp (epoch millis) do momento da verificação.
     * @return true se o pagamento estiver em dia, false caso contrário.
     */
    public boolean isAdimplente(long horaAtualTimestamp) {
        // A data de vencimento deve ser maior ou igual à data/hora atual.
        return this.dataVencimento >= horaAtualTimestamp;
    }

    // Getters e Setters

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public long getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(long dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}