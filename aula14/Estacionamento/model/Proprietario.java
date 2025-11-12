package model;

/**
 * Representa o dono de uma unidade com vaga privativa.
 * Herda de Cliente.
 */
public class Proprietario extends Cliente {

    private String unidadeCondominio;

    // Getters e Setters

    public String getUnidadeCondominio() {
        return unidadeCondominio;
    }

    public void setUnidadeCondominio(String unidadeCondominio) {
        this.unidadeCondominio = unidadeCondominio;
    }
}
