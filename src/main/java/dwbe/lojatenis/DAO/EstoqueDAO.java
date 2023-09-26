package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.Estoque;

import java.util.List;

public interface EstoqueDAO {
    void create(Estoque estoque);
    Estoque read(String id);
    void update(Estoque estoque);
    void delete(String id);
    List<Estoque> getAllEstoque();
}
