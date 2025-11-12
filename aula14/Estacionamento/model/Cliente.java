package model;

/**
 * Classe base abstrata para usuários cadastrados no estacionamento.
 */
public abstract class Cliente {

    private String nome;
    private String cpf;

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}