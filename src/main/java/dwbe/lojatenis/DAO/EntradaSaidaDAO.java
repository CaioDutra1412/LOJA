package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.EntradaSaida;

import java.util.List;

public interface EntradaSaidaDAO {
    void create(EntradaSaida entradaSaida);
    EntradaSaida read(String id);
    void update(EntradaSaida entradaSaida);
    void delete(String id);
    List<EntradaSaida> getAllEntradaSaida();
}
