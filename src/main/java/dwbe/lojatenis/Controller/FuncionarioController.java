package dwbe.lojatenis.Controller;

import dwbe.lojatenis.Model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private List<Funcionario> database = new ArrayList<>();

    public void gravar(Funcionario funcionario){
        database.add(funcionario);
    }

    public void alterar(Funcionario funcionario){
        int index = database.indexOf(funcionario);
        database.set(index,funcionario);
    }

    public Funcionario buscarPorId(String id){
        int index = database.indexOf(id);
        Funcionario selectFuncionario = database.get(index);
        return selectFuncionario;
    }

    public List<Funcionario> listar(){
        return database;
    }
}
