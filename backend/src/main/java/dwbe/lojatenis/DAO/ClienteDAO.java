package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.Cliente;

import java.util.List;

public interface ClienteDAO {
    void create(Cliente cliente);
    Cliente read(String id);
    void update(Cliente cliente);
    void delete(String id);
    List<Cliente> getAllClientes();
}
