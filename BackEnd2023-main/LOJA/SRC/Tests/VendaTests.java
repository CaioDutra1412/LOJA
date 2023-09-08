package Tests;
import PROJETO.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class VendaTests {
    @Test
    void deveRetonarObjetoVendaCompleto() {
        // Exemplo de criação de objetos
        Produto produto = new Produto("1", 100.0, "42", "Branco", "Nike", "Running");
        Fornecedor fornecedor = new Fornecedor("123", "Fornecedor ABC", null, "Rua Oscar Vidal", null, "31 9 9876 5432", "fornecedorNike@gmail.com.br", "");
        fornecedor.setCnpj("328193762198");
        fornecedor.setNumeroInscricao(132);
        fornecedor.setNomeFantasia("Nike Jf");
        fornecedor.setDataDeAbertura("04.08.2018");
        fornecedor.setPorte("Pequeno");
        fornecedor.setAtividadeEconomicaPrincipal("Contrabando");
        fornecedor.setSitucaoCadastral("Ok");

        Cliente cliente = new Cliente("1", "João", "987654321", "Rua X", "M", "987654321", "joao@example.com", "Ativo");

        Compra compra = new Compra("1", 10, 900.0, new Date(), produto, fornecedor);
        Venda venda = new Venda("2", 5, 150.0, new Date(), produto, cliente);

        assertEquals("Venda{cliente=João, " +
                "id='2', qtd=5, valor=150.0, produto=PRODUTO{id='1', preco=100.0, " +
                "tamanho='42', cor='Branco', marca='Nike', tipo='Running'}}", venda.toString());
    }
}
