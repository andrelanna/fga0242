package model;

/**
 * Representa a empresa (condomínio, etc.) que contrata o serviço de gestão.
 */
public class Parceiro {

    private String razaoSocial;
    private String cnpj;

    // Construtores, Getters e Setters
    
    public Parceiro() {
    }

    public Parceiro(String razaoSocial, String cnpj) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}