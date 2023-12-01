package dwbe.lojatenis.Model;

import dwbe.lojatenis.DAO.ClienteDAO;
import dwbe.lojatenis.DAO.ProdutoDAO;

import java.util.Date;

public class Venda extends EntradaSaida {
    private int clienteId;
    ClienteDAO clienteDao;
    ProdutoDAO produtoDao;

    public Venda(int qtd, double valor, Date data, int produtoId, int clienteId) {
        super(qtd, valor, data, produtoId);
        this.clienteId = clienteId;
        clienteDao = new ClienteDAO();
        produtoDao = new ProdutoDAO();
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setCliente(int clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "cliente=" + clienteDao.buscarCliente(this.clienteId) +
                ", id='" + getId() + '\'' +
                ", qtd=" + getQtd() +
                ", valor=" + getValor() +
                ", produto=" + produtoDao.buscarProduto(super.getProdutoId()) +
                '}';
    }
}
