package dwbe.lojatenis.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private String nome;
    private String cpf;
    private String endereco;
    private String sexo;
    private String telefone;
    private String email;
    private String status;
}
