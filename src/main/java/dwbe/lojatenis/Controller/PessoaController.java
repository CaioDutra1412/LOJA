package dwbe.lojatenis.Controller;

import dwbe.lojatenis.Model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaController {
    private List<Pessoa> database = new ArrayList<>();

    public void gravar(Pessoa pessoa){
        database.add(pessoa);
    }

    public void alterar(Pessoa pessoa){
        int index = database.indexOf(pessoa);
        database.set(index,pessoa);
    }

    public Pessoa buscarPorId(String id){
        int index = database.indexOf(id);
        Pessoa selectPessoa = database.get(index);
        return selectPessoa;
    }

    public List<Pessoa> listar(){
        return database;
    }
}
