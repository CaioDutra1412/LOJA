package dwbe.lojatenis.Controller;

public class FuncionarioController {
    private List<Funcionario> database = new ArrayList<>();

    public void gravar(Funcionario funcionario){
        database.add(user);

    }

    public void alterar(Funcionario funcionario){
        int index = database.indexOf(funcionario);
        database.set(index,funcionario);
    }

    public User buscarPorId(String id){
        int index = database.indexOf(new Funcionario(id));
        Funcionario selectFuncionario = database.get(index);
        return selectFuncionario;
    }

    public List<Funcionario> listar(){
        return database;
    }
}
