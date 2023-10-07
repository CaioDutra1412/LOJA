package dwbe.lojatenis.Controller;

public class EntradaSaidaController {
    private List<EntradaSaida> database = new ArrayList<>();

    public void gravar(EntradaSaida entradasaida){
        database.add(entradasaida);

    }

    public void alterar(EntradaSaida entradasaida){
        int index = database.indexOf(entradasaida);
        database.set(index,entradasaida);
    }

    public User buscarPorId(String id){
        int index = database.indexOf(new EntradaSaida(id));
        EntradaSaida selectEntradaSaida = database.get(index);
        return selectEntradaSaida;
    }

    public List<EntradaSaida> listar(){
        return database;
    }
}
