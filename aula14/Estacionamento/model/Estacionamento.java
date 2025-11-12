package model;

/**
 * Representa o local físico a ser gerenciado.
 */
public class Estacionamento {

    private String localizacao;
    private String horarioUtil;
    private String horarioFDS;
    private int totalVagas;
    private int vagasPrivativas;
    private int vagasMensalistas;

    // Relacionamento: Um estacionamento pertence a um parceiro
    private Parceiro parceiro;

    // Construtores, Getters e Setters

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getHorarioUtil() {
        return horarioUtil;
    }

    public void setHorarioUtil(String horarioUtil) {
        this.horarioUtil = horarioUtil;
    }

    public String getHorarioFDS() {
        return horarioFDS;
    }

    public void setHorarioFDS(String horarioFDS) {
        this.horarioFDS = horarioFDS;
    }

    public int getTotalVagas() {
        return totalVagas;
    }

    public void setTotalVagas(int totalVagas) {
        this.totalVagas = totalVagas;
    }

    public int getVagasPrivativas() {
        return vagasPrivativas;
    }

    public void setVagasPrivativas(int vagasPrivativas) {
        this.vagasPrivativas = vagasPrivativas;
    }

    public int getVagasMensalistas() {
        return vagasMensalistas;
    }

    public void setVagasMensalistas(int vagasMensalistas) {
        this.vagasMensalistas = vagasMensalistas;
    }

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }
}