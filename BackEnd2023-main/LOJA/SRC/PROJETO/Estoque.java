package PROJETO;

public class Estoque {
    private String id;
    private int qtd;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private Produto produto;

    public Estoque(String id, int qtd, int estoqueMinimo, int estoqueMaximo, Produto produto) {
        this.id = id;
        this.qtd = qtd;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id='" + id + '\'' +
                ", qtd=" + qtd +
                ", estoqueMinimo=" + estoqueMinimo +
                ", estoqueMaximo=" + estoqueMaximo +
                ", produto=" + produto +
                '}';
    }
}
