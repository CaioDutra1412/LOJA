package dwbe.lojatenis.Controller;

import dwbe.lojatenis.Model.Cliente;

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

    public Cliente buscarPorId(String id){
        int index = database.indexOf(id);
        Cliente selectCliente = database.get(index);
        return selectCliente;
    }

    public List<Cliente> listar(){
        return database;
    }
}
