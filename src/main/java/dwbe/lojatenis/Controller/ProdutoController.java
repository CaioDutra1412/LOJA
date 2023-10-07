package dwbe.lojatenis.Controller;

public class ProdutoController {
    private List<Produto> database = new ArrayList<>();

    public void gravar(Produto produto){
        database.add(produto);

    }

    public void alterar(Produto produto){
        int index = database.indexOf(produto);
        database.set(index,produto);
    }

    public User buscarPorId(String id){
        int index = database.indexOf(new Produto(id));
        Produto selectProduto = database.get(index);
        return selectProduto;
    }

    public List<Produto> listar(){
        return database;
    }
}
