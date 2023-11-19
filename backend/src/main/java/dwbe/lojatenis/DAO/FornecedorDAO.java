package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.Fornecedor;

import java.util.List;
public interface FornecedorDAO {
    void create(Fornecedor fornecedor);
    Fornecedor read(String id);
    void update(Fornecedor fornecedor);
    void delete(String id);
    List<Fornecedor> getAllFornecedores();
}
