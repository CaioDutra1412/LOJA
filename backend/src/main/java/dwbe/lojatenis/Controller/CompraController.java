package dwbe.lojatenis.Controller;

import dwbe.lojatenis.Model.Compra;

import java.util.ArrayList;
import java.util.List;

public class CompraController {
    private List<Compra> database = new ArrayList<>();

    public void gravar(Compra compra){
        database.add(compra);
    }

    public void alterar(Compra compra){
        int index = database.indexOf(compra);
        database.set(index,compra);
    }

    public Compra buscarPorId(String id){
        int index = database.indexOf(id);
        Compra selectCompra = database.get(index);
        return selectCompra;
    }

    public List<Compra> listar(){
        return database;
    }
}
