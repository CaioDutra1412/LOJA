package dwbe.lojatenis.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDTO {
    private int qtd;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private int produtoId;
}