package dwbe.lojatenis.Controller;

import dwbe.lojatenis.DAO.EntradaSaidaDAO;
import dwbe.lojatenis.DAO.EstoqueDAO;
import dwbe.lojatenis.DTO.EntradaSaidaDTO;
import dwbe.lojatenis.Model.EntradaSaida;
import dwbe.lojatenis.Model.Estoque;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/entradaSaida")
public class EntradaSaidaController {
    private EntradaSaidaDAO entradaSaidaDAO;

    public EntradaSaidaController() {
        this.entradaSaidaDAO = new EntradaSaidaDAO();
    }
    @PostMapping("/cadastrarEntradaSaida")
    public void cadastrarEstoque(@RequestBody EntradaSaidaDTO EntradaSaidaDTO) {
        var entradaSaida = new EntradaSaida(
                EntradaSaidaDTO.getQtd(),
                EntradaSaidaDTO.getValor(),
                EntradaSaidaDTO.getData(),
                EntradaSaidaDTO.getProdutoId()
        );
        entradaSaidaDAO.cadastrarEntradaSaida(entradaSaida);
    }
}