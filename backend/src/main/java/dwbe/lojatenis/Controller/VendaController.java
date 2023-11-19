package dwbe.lojatenis.Controller;

import dwbe.lojatenis.Model.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaController {
    private List<Venda> database = new ArrayList<>();

    public void gravar(Venda venda){
        database.add(venda);
    }

    public void alterar(Venda venda){
        int index = database.indexOf(venda);
        database.set(index,venda);
    }

    public Venda buscarPorId(String id){
        int index = database.indexOf(id);
        Venda selectVenda = database.get(index);
        return selectVenda;
    }

    public List<Venda> listar(){
        return database;
    }
}
