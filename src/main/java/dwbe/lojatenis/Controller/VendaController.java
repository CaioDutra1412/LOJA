package dwbe.lojatenis.Controller;

public class VendaController {
    private List<Venda> database = new ArrayList<>();

    public void gravar(Venda venda){
        database.add(venda);

    }

    public void alterar(Venda venda){
        int index = database.indexOf(venda);
        database.set(index,venda);
    }

    public User buscarPorId(String id){
        int index = database.indexOf(new Venda(id));
        Venda selectVenda = database.get(index);
        return selectVenda;
    }

    public List<Venda> listar(){
        return database;
    }
}
