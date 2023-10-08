package dwbe.lojatenis.Controller;

import dwbe.lojatenis.Model.Fornecedor;

import java.util.ArrayList;
import java.util.List;

public class FornecedorController {
    private List<Fornecedor> database = new ArrayList<>();

    public void gravar(Fornecedor fornecedor){
        database.add(fornecedor);
    }

    public void alterar(Fornecedor fornecedor){
        int index = database.indexOf(fornecedor);
        database.set(index,fornecedor);
    }

    public Fornecedor buscarPorNumeroInscricao(String numeroInscricao){
        int index = database.indexOf(numeroInscricao);
        Fornecedor selectFornecedor = database.get(index);
        return selectFornecedor;
    }

    public List<Fornecedor> listar(){
        return database;
    }
}
