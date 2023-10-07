package dwbe.lojatenis.Controller;

public class PessoaController {
    private List<Pessoa> database = new ArrayList<>();

    public void gravar(Pessoa pessoa){
        database.add(pessoa);

    }

    public void alterar(Pessoa pessoa){
        int index = database.indexOf(pessoa);
        database.set(index,pessoa);
    }

    public User buscarPorId(String pessoa){
        int index = database.indexOf(new Pessoa(pessoa));
        Pessoa selectPessoa = database.get(index);
        return selectPessoa;
    }

    public List<Pessoa> listar(){
        return database;
    }
}
