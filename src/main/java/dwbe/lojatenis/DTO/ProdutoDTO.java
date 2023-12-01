package dwbe.lojatenis.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private double preco;
    private String tamanho;
    private String cor;
    private String marca;
    private String tipo;
    private int fornecedorId;
}
