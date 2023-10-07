package dwbe.lojatenis.Controller;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> database = new ArrayList<>();

    public void gravar(Cliente cliente){
        database.add(cliente);

    }

    public void alterar(Cliente cliente){
        int index = database.indexOf(cliente);
        database.set(index,cliente);
    }

    public User buscarPorId(String id){
        int index = database.indexOf(new Cliente(id));
        Cliente selectCliente = database.get(index);
        return selectCliente;
    }

    public List<Cliente> listar(){
        return database;
    }
}
