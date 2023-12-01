package dwbe.lojatenis.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {
    private int qtd;
    private double preco;
    private Date data;
    private int produtoId;
    private int fornecedorId;
}
