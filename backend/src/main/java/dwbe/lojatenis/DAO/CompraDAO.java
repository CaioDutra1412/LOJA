package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.Compra;

import java.util.List;

public interface CompraDAO {
    void create(Compra compra);
    Compra read(String id);
    void update(Compra compra);
    void delete(String id);
    List<Compra> getAllCompras();
}
