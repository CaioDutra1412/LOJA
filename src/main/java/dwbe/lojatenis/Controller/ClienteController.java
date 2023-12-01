package dwbe.lojatenis.Controller;

import dwbe.lojatenis.DAO.ClienteDAO;
import dwbe.lojatenis.DTO.ClienteDTO;
import dwbe.lojatenis.Model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    @PostMapping("/cadastrarCliente")
    public void cadastrarCliente(@RequestBody ClienteDTO clienteDTO) {
        var cliente = new Cliente(
                clienteDTO.getNome(),
                clienteDTO.getCpf(),
                clienteDTO.getEndereco(),
                clienteDTO.getSexo(),
                clienteDTO.getTelefone(),
                clienteDTO.getEmail(),
                clienteDTO.getStatus()
        );
        clienteDAO.cadastrarCliente(cliente);
    }

    @GetMapping("/listarClientes")
    public List<Cliente> listarClientes() {
        return clienteDAO.listarClientes();
    }

    @GetMapping("/buscarCliente/{id}")
    public Cliente buscarCliente(@PathVariable int id) {
        return clienteDAO.buscarCliente(id);
    }

    @GetMapping("/excluirCliente/{id}")
    public void excluirCliente(@PathVariable int id) {
        clienteDAO.excluirCliente(id);
    }
}