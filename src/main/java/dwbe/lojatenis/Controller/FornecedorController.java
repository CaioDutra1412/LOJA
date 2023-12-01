package dwbe.lojatenis.Controller;

import dwbe.lojatenis.DAO.FornecedorDAO;
import dwbe.lojatenis.DTO.FornecedorDTO;
import dwbe.lojatenis.Model.Fornecedor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    private FornecedorDAO fornecedorDAO;

    public FornecedorController() {
        this.fornecedorDAO = new FornecedorDAO();
    }

    @PostMapping("/cadastrarFornecedor")
    public void cadastrarFornecedor(@RequestBody FornecedorDTO fornecedorDTO) {
        var fornecedor = new Fornecedor(
                fornecedorDTO.getNome(),
                fornecedorDTO.getCpf(),
                fornecedorDTO.getEndereco(),
                fornecedorDTO.getSexo(),
                fornecedorDTO.getTelefone(),
                fornecedorDTO.getEmail(),
                fornecedorDTO.getCnpj(),
                fornecedorDTO.getNumeroInscricao(),
                fornecedorDTO.getNomeFantasia(),
                fornecedorDTO.getDataDeAbertura(),
                fornecedorDTO.getPorte(),
                fornecedorDTO.getAtividadeEconomicaPrincipal(),
                fornecedorDTO.getSituacaoCadastral()
        );
        fornecedorDAO.cadastrarFornecedor(fornecedor);
    }

    @RequestMapping("/listarFornecedores")
    public List<Fornecedor> listarFornecedores() {
        return fornecedorDAO.listarFornecedores();
    }


    @GetMapping("/buscarFornecedor/{fornecedorId}")
    public Fornecedor buscarFornecedor(@PathVariable int fornecedorId) {
        return fornecedorDAO.buscarFornecedor(fornecedorId);
    }


    @GetMapping("/excluirFornecedor/{id}")
    public ResponseEntity<String> excluirFornecedor(@PathVariable int id) {
        boolean result = fornecedorDAO.excluirFornecedor(id);
        if (result) {
            return ResponseEntity.ok("true");
        } else {
            return ResponseEntity.ok("false");
        }
    }
}
