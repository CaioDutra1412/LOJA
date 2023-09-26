package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.Produto;

import java.util.List;
public interface ProdutoDAO {
    void create(Produto produto);
    Produto read(String id);
    void update(Produto produto);
    void delete(String id);
    List<Produto> getAllProdutos();
}
