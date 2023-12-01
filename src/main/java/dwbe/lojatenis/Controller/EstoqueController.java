package dwbe.lojatenis.Controller;

import dwbe.lojatenis.DAO.EstoqueDAO;
import dwbe.lojatenis.DTO.EstoqueDTO;
import dwbe.lojatenis.Model.Estoque;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    private EstoqueDAO estoqueDAO;

    public EstoqueController() {
        this.estoqueDAO = new EstoqueDAO();
    }

    @PostMapping("/cadastrarEstoque")
    public void cadastrarEstoque(@RequestBody EstoqueDTO estoqueDTO) {
        var estoque = new Estoque(
                estoqueDTO.getQtd(),
                estoqueDTO.getEstoqueMinimo(),
                estoqueDTO.getEstoqueMaximo(),
                estoqueDTO.getProdutoId()
        );
        estoqueDAO.cadastrarEstoque(estoque);
    }

    @PutMapping("/alterarEstoque")
    public void alterarEstoque(@RequestBody EstoqueDTO estoqueDTO) {
        var estoque = new Estoque(
                estoqueDTO.getQtd(),
                estoqueDTO.getEstoqueMinimo(),
                estoqueDTO.getEstoqueMaximo(),
                estoqueDTO.getProdutoId()
        );
        estoqueDAO.alterarEstoque(estoque);
    }

    @GetMapping("/listarEstoque")
    public List<Estoque> listarEstoque() {
        return estoqueDAO.listarEstoque();
    }

    @GetMapping("/buscarEstoque/{idProduto}")
    public Estoque buscarEstoque(@PathVariable int idProduto) {
        return estoqueDAO.buscarEstoquePorProduto(idProduto);
    }

    @GetMapping("/excluirEstoque/{id}")
    public void excluirEstoque(@PathVariable int id) {
        estoqueDAO.excluirEstoque(id);
    }
}