package dwbe.lojatenis.Model;

import java.util.Date;

public class EntradaSaida {
    private String id;
    private int qtd;
    private double valor;
    private Date data;
    private Produto produto;

    public EntradaSaida(String id, int qtd, double valor, Date data, Produto produto) {
        this.id = id;
        this.qtd = qtd;
        this.valor = valor;
        this.data = data;
        this.produto = produto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "EntradaSaida{" +
                "id='" + id + '\'' +
                ", qtd=" + qtd +
                ", valor=" + valor +
                ", data=" + data +
                ", produto=" + produto +
                '}';
    }
}
