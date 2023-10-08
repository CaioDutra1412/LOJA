package dwbe.lojatenis.Controller;

import dwbe.lojatenis.Model.EntradaSaida;

import java.util.ArrayList;
import java.util.List;

public class EntradaSaidaController {
    private List<EntradaSaida> database = new ArrayList<>();

    public void gravar(EntradaSaida entradaSaida){
        database.add(entradaSaida);
    }

    public void alterar(EntradaSaida entradaSaida){
        int index = database.indexOf(entradaSaida);
        database.set(index,entradaSaida);
    }

    public EntradaSaida buscarPorId(String id){
        int index = database.indexOf(id);
        EntradaSaida selectEntradaSaida = database.get(index);
        return selectEntradaSaida;
    }

    public List<EntradaSaida> listar(){
        return database;
    }
}
