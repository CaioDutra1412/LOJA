package dwbe.lojatenis.Model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Produto> produtos;
    private List<Fornecedor> fornecedores;
    private List<Cliente> clientes;

    public Banco() {
        produtos = new ArrayList<>();
        fornecedores = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public void excluirProduto(String id) {
        Produto produtoEncontrado = produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findAny()
                .orElse(null);

        if (produtoEncontrado != null) {
            this.produtos.remove(produtoEncontrado);
            System.out.println("Produto " + produtoEncontrado + " excluido");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void cadastrarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public List<Fornecedor> listarFornecedores() {
        return fornecedores;
    }

    public void excluirFornecedor(String id) {
        Fornecedor fornecedorEncontrado = fornecedores.stream()
                .filter(fornecedor -> fornecedor.getId().equals(id))
                .findAny()
                .orElse(null);

        if (fornecedorEncontrado != null) {
            this.fornecedores.remove(fornecedorEncontrado);
            System.out.println("Fornecedor " + fornecedorEncontrado + " excluido");
        } else {
            System.out.println("Fornecedor não encontrado.");
        }
    }
    public void cadastrarClinte(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public void excluirCliente(String id) {
        Cliente clienteEncontrado = clientes.stream()
                .filter(cliente -> cliente.getId().equals(id))
                .findAny()
                .orElse(null);

        if (clienteEncontrado != null) {
            this.clientes.remove(clienteEncontrado);
            System.out.println("Cliente " + clienteEncontrado + " excluido");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}