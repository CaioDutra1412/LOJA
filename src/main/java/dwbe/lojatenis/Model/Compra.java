package dwbe.lojatenis.Model;

import java.util.Date;

public class Compra extends EntradaSaida {
    private Fornecedor fornecedor;

    public Compra(String id, int qtd, double valor, Date data, Produto produto, Fornecedor fornecedor) {
        super(id, qtd, valor, data, produto);
        this.fornecedor = fornecedor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "fornecedor=" + fornecedor +
                ", id='" + getId() + '\'' +
                ", qtd=" + getQtd() +
                ", valor=" + getValor() +
                ", data=" + getData() +
                ", produto=" + getProduto() +
                '}';
    }
}
