package dwbe.lojatenis.Controller;

public class FornecedorController {
    private List<Fornecedor> database = new ArrayList<>();

    public void gravar(Fornecedor fornecedor){
        database.add(fornecedor);

    }

    public void alterar(Fornecedor fornecedor){
        int index = database.indexOf(fornecedor);
        database.set(index,fornecedor);
    }

    public User buscarPorCNPJ(String cnpj){
        int index = database.indexOf(new Fornecedor(cnpj));
        Fornecedor selectFornecedor = database.get(index);
        return selectFornecedor;
    }

    public List<Fornecedor> listar(){
        return database;
    }
}
