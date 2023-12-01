package dwbe.lojatenis.Model;

public class Produto {
    private int id;
    private double preco;
    private String tamanho;
    private String cor;
    private String marca;
    private String tipo;
    private int fornecedorId;

    public Produto(double preco, String tamanho, String cor, String marca, String tipo, int fornecedorId) {
        this.preco = preco;
        this.tamanho = tamanho;
        this.cor = cor;
        this.marca = marca;
        this.tipo = tipo;
        this.fornecedorId = fornecedorId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
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

    public int getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public boolean vender(int quantidade, Estoque estoque) {
        if (quantidade > 0 && estoque != null) {
            if (quantidade <= estoque.getQtd()) {
                estoque.setQtd(estoque.getQtd() - quantidade);
                return true;
            }
        }
        return false;
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
