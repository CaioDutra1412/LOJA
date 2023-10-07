package dwbe.lojatenis.Controller;

public class EstoqueController {
    private List<User> database = new ArrayList<>();

    public void gravar(Estoque estoque){
        database.add(user);

    }

    public void alterar(Estoque estoque){
        int index = database.indexOf(estoque);
        database.set(index,estoque);
    }

    public User buscarPorId(String id){
        int index = database.indexOf(new Estoque(id));
        Estoque selectEstoque = database.get(index);
        return selectEstoque;
    }

    public List<Estoque> listar(){
        return database;
    }
}
