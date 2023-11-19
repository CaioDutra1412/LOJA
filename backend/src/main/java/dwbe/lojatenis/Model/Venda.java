package dwbe.lojatenis.Model;

import java.util.Date;

public class Venda extends EntradaSaida {
    private Cliente cliente;

    public Venda(String id, int qtd, double valor, Date data, Produto produto, Cliente cliente) {
        super(id, qtd, valor, data, produto);
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean realizarVenda(int quantidade, Estoque estoque) {
        if (quantidade > 0 && estoque != null) {
            if (quantidade <= estoque.getQtd()) {
                estoque.setQtd(estoque.getQtd() - quantidade);
                this.cliente.adicionarVenda(this);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "cliente=" + cliente.getNome() +
                ", id='" + getId() + '\'' +
                ", qtd=" + getQtd() +
                ", valor=" + getValor() +
                ", produto=" + getProduto() +
                '}';
    }
}
