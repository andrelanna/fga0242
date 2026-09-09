package fga0242.model;

public class Produto {

    private final String id;
    private final String nome;
    private final String categoria; // "HORTIFRUTI", "GRAOS", "LATICINIOS", "INSUMOS"
    private final double precoUnitario;
    private final double pesoKg;

    public Produto(String id, String nome, String categoria, double precoUnitario, double pesoKg) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.precoUnitario = precoUnitario;
        this.pesoKg = pesoKg;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getPesoKg() {
        return pesoKg;
    }
}
