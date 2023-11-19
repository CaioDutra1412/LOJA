package dwbe.lojatenis.Controller;

import dwbe.lojatenis.Model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> database = new ArrayList<>();

    public void gravar(Produto produto){
        database.add(produto);
    }

    public void alterar(Produto produto){
        int index = database.indexOf(produto);
        database.set(index,produto);
    }

    public Produto buscarPorId(String id){
        int index = database.indexOf(id);
        Produto selectProduto = database.get(index);
        return selectProduto;
    }

    public List<Produto> listar(){
        return database;
    }
}
