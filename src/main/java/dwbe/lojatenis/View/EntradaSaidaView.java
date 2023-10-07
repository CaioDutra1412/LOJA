package dwbe.lojatenis.View;

import dwbe.lojatenis.Controller.EntradaSaidaController;
import org.springframework.boot.CommandLineRunner;

public class EntradaSaidaView implements CommandLineRunner {

    private final EntradaSaidaController service = new EntradaSaidaController();
    @Override
    public void run(String... args) throws Exception {
        for(int x=1; x<=5;x++){
            service.gravar(new EntradaSaida("es" + x));
        }
        EntradaSaida es2 = service.buscarPorId("es2");
        es2.setName("MOVIMENTAÇÃO 2");
        service.alterar(es2);

        for(EntradaSaida entradasaida: service.listar()){
            System.out.println(entradasaida);
        }
    }
}
