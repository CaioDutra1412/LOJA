package dwbe.lojatenis.Controller;

import dwbe.lojatenis.DAO.ProdutoDAO;
import dwbe.lojatenis.DTO.ProdutoDTO;
import dwbe.lojatenis.Model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        this.produtoDAO = new ProdutoDAO();
    }

    @PostMapping("/cadastrarProduto")
    public void cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        var produto = new Produto(
                produtoDTO.getPreco(),
                produtoDTO.getTamanho(),
                produtoDTO.getCor(),
                produtoDTO.getMarca(),
                produtoDTO.getTipo(),
                produtoDTO.getFornecedorId()
        );
        produtoDAO.cadastrarProduto(produto);
    }

    @GetMapping("/listarProdutos")
    public List<Produto> listarProdutos() {
        return produtoDAO.listarProdutos();
    }

    @GetMapping("/listarProdutosPorFornecedor/{idFornecedor}")
    public List<Produto> listarProdutosPorFornecedor(@PathVariable int idFornecedor) {
        return produtoDAO.listarProdutosPorFornecedor(idFornecedor);
    }

    @GetMapping("/buscarProduto/{id}")
    public Produto buscarProduto(@PathVariable int id) {
        return produtoDAO.buscarProduto(id);
    }

    @GetMapping("/excluirProduto/{id}")
    public void excluirProduto(@PathVariable int id) {
        produtoDAO.excluirProduto(id);
    }
}