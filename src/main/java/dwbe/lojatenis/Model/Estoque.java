package dwbe.lojatenis.Model;

import dwbe.lojatenis.DAO.ProdutoDAO;

public class Estoque {
    private int id;
    private int qtd;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private int produtoId;
    ProdutoDAO produtoDao;

    public Estoque(int qtd, int estoqueMinimo, int estoqueMaximo, int produtoId) {
        this.qtd = qtd;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
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

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(int estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public int getProdutoId() {
        return this.produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id='" + id + '\'' +
                ", qtd=" + qtd +
                ", produto=" + produtoDao.buscarProduto(this.produtoId) +
                '}';
    }
}
