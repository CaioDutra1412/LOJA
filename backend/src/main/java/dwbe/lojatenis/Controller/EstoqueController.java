package dwbe.lojatenis.Controller;

import dwbe.lojatenis.Model.Estoque;

import java.util.ArrayList;
import java.util.List;

public class EstoqueController {
    private List<Estoque> database = new ArrayList<>();

    public void gravar(Estoque estoque){
        database.add(estoque);
    }

    public void alterar(Estoque estoque){
        int index = database.indexOf(estoque);
        database.set(index,estoque);
    }

    public Estoque buscarPorId(String id){
        int index = database.indexOf(id);
        Estoque selectEstoque = database.get(index);
        return selectEstoque;
    }

    public List<Estoque> listar(){
        return database;
    }
}
