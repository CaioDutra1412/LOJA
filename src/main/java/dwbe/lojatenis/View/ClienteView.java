package dwbe.lojatenis.View;

import dwbe.lojatenis.Controller.ClienteController;
import org.springframework.boot.CommandLineRunner;

public class ClienteView implements CommandLineRunner {
    private final ClienteController service = new ClienteController();
    @Override
    public void run(String... args) throws Exception {
        for(int x=1; x<=5;x++){
            service.gravar(new Cliente("cliente" + x));
        }
        Cliente cliente2 = service.buscarPorId("cliente2");
        cliente2.setName("CAIO");
        service.alterar(cliente2);

        for(Cliente cliente: service.listar()){
            System.out.println(cliente);
        }
    }

}
