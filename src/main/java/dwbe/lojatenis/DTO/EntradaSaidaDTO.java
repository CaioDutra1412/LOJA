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
public class EntradaSaidaDTO {
    private int qtd;
    private double valor;
    private Date data;
    private int produtoId;
}