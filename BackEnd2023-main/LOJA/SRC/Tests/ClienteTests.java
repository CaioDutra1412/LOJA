package Tests;

import PROJETO.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTests {@Test
void deveRetonarObjetoClienteCompleto() {
    Cliente cliente = new Cliente("1", "João", "987654321", "Rua X", "M", "987654321", "joao@example.com", "Ativo");

    assertEquals("Venda{cliente=João, " +
            "id='2', qtd=5, valor=150.0, produto=PRODUTO{id='1', preco=100.0, " +
            "tamanho='42', cor='Branco', marca='Nike', tipo='Running'}}", cliente.toString());
}
}
