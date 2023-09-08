package Tests;

import PROJETO.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTests {
    @Test
    void deveRetonarObjetoProdutoCompleto() {
        // Exemplo de criação de objetos
        Produto produto = new Produto("1", 100.0, "42", "Branco", "Nike", "Running");

        assertEquals("PRODUTO{id='1', preco=100.0, tamanho='42', " +
                "cor='Branco', marca='Nike', tipo='Running'}", produto.toString());
    }
}
