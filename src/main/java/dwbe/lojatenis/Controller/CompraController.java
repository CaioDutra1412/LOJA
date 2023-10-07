package dwbe.lojatenis.Controller;

public class CompraController {
    private List<Compra> database = new ArrayList<>();

    public void gravar(Compra compra){
        database.add(compra);

    }

    public void alterar(Compra compra){
        int index = database.indexOf(compra);
        database.set(index,compra);
    }

    public User buscarPorId(String id){
        int index = database.indexOf(new Compra(id));
        Compra selectCompra = database.get(index);
        return selectCompra;
    }

    public List<Compra> listar(){
        return database;
    }
}
