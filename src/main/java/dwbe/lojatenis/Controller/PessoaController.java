package dwbe.lojatenis.Controller;

import dwbe.lojatenis.DAO.PessoaDAO;
import dwbe.lojatenis.DTO.PessoaDTO;
import dwbe.lojatenis.Model.Pessoa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private PessoaDAO pessoaDAO;

    public PessoaController() {
        this.pessoaDAO = new PessoaDAO();
    }

    @PostMapping("/cadastrarPessoa")
    public void cadastrarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        var pessoa = new Pessoa(
                pessoaDTO.getNome(),
                pessoaDTO.getCpf(),
                pessoaDTO.getEndereco(),
                pessoaDTO.getSexo(),
                pessoaDTO.getTelefone(),
                pessoaDTO.getEmail()
        );
        pessoaDAO.cadastrarPessoa(pessoa);
    }

    @GetMapping("/listarPessoa")
    public List<Pessoa> listarPessoa() {
        return pessoaDAO.listarPessoa();
    }

    @GetMapping("/excluirPessoa/{id}")
    public void excluirPessoa(@PathVariable int id) {
        pessoaDAO.excluirPessoa(id);
    }
}