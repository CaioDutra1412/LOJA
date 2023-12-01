package dwbe.lojatenis.Controller;

import dwbe.lojatenis.DAO.CompraDAO;
import dwbe.lojatenis.DTO.CompraDTO;
import dwbe.lojatenis.Model.Compra;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraController {
    private CompraDAO compraDAO;

    public CompraController() {
        this.compraDAO = new CompraDAO();
    }

    @PostMapping("/cadastrarCompra")
    public void cadastrarCompra(@RequestBody CompraDTO compraDTO) {
        var compra = new Compra(
                compraDTO.getQtd(),
                compraDTO.getPreco(),
                compraDTO.getData(),
                compraDTO.getProdutoId(),
                compraDTO.getFornecedorId()
        );
        compraDAO.cadastrarCompra(compra);
    }

    @RequestMapping("/listarCompras")
    public List<Compra> listarCompras() {
        return compraDAO.listarCompras();
    }
}