package dwbe.lojatenis.Model;

import dwbe.lojatenis.DAO.FornecedorDAO;
import dwbe.lojatenis.DAO.ProdutoDAO;

import java.util.Date;

public class Compra extends EntradaSaida {
    private int fornecedorId;
    private ProdutoDAO produtoDao;
    private FornecedorDAO fornecedorDao;

    public Compra(int qtd, double valor, Date data, int produtoId, int fornecedorId) {
        super(qtd, valor, data, produtoId);
        this.fornecedorId = fornecedorId;
        this.produtoDao = new ProdutoDAO();
        this.fornecedorDao = new FornecedorDAO();
    }

    public int getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(int fornecedor) {
        this.fornecedorId = fornecedor;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "fornecedor=" + fornecedorDao +
                ", id='" + getId() + '\'' +
                ", qtd=" + getQtd() +
                ", valor=" + getValor() +
                ", data=" + getData() +
                ", produto=" + produtoDao.buscarProduto(super.getProdutoId()) +
                '}';
    }
}
