package PROJETO;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Exemplo de criação de objetos
        Produto produto = new Produto("1", 100.0, "42", "Branco", "Nike", "Running");
        Fornecedor fornecedor = new Fornecedor("123", "Fornecedor ABC", null, "Rua Oscar Vidal", null, "31 9 9876 5432", "fornecedorNike@gmail.com.br", "");
        fornecedor.setCnpj("328193762198");
        Cliente cliente = new Cliente("1", "João", "987654321", "Rua X", "M", "987654321", "joao@example.com", "Ativo");

        Compra compra = new Compra("1", 10, 900.0, new Date(), produto, fornecedor);
        Venda venda = new Venda("2", 5, 150.0, new Date(), produto, cliente);

        System.out.println("Detalhes da Compra:");
        System.out.println(compra);

        System.out.println("\nDetalhes da Venda:");
        System.out.println(venda);
    }
}
