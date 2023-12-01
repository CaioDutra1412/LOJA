package dwbe.lojatenis.Model;

import dwbe.lojatenis.DAO.ProdutoDAO;

import java.util.Date;

public class EntradaSaida {
    private int id;
    private int qtd;
    private double valor;
    private Date data;
    private int produtoId;
    ProdutoDAO produtoDao;

    public EntradaSaida(int qtd, double valor, Date data, int produtoId) {
        this.qtd = qtd;
        this.valor = valor;
        this.data = data;
        this.produtoId = produtoId;
        produtoDao = new ProdutoDAO();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getProdutoId() {
        return produtoId;
    }

    public void setProduto(int produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public String toString() {
        return "EntradaSaida{" +
                "id='" + id + '\'' +
                ", qtd=" + qtd +
                ", valor=" + valor +
                ", data=" + data +
                ", produto=" + produtoDao.buscarProduto(this.produtoId) +
                '}';
    }
}
