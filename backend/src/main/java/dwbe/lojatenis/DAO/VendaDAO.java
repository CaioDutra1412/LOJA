package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.Venda;

import java.util.List;
public interface VendaDAO {
    void create(Venda venda);
    Venda read(String id);
    void update(Venda venda);
    void delete(String id);
    List<Venda> getAllVendas();
}
