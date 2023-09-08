package PROJETO;

public class Produto {
    private String id;
    private double preco;
    private String tamanho;
    private String cor;
    private String marca;
    private String tipo;

    public Produto(String id, double preco, String tamanho, String cor, String marca, String tipo) {
        this.id = id;
        this.preco = preco;
        this.tamanho = tamanho;
        this.cor = cor;
        this.marca = marca;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "PRODUTO{" +
                "id='" + id + '\'' +
                ", preco=" + preco +
                ", tamanho='" + tamanho + '\'' +
                ", cor='" + cor + '\'' +
                ", marca='" + marca + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
