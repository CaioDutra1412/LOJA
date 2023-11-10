package dwbe.lojatenis.View;

import dwbe.lojatenis.Controller.ClienteController;
import dwbe.lojatenis.Model.Cliente;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClienteView {
    private final ClienteController service = new ClienteController();
    //@Override
    public void run(String... args) throws Exception {
        for(int x=1; x<=5;x++){
            service.gravar(new Cliente("1", "Thiago", "123456789", "Rua Oscar Vidal", "M", "31 9 8888-7777", "thiago.cotta05@gmail.com", "ativo"));
        }
        Cliente cliente2 = service.buscarPorId("user2");
        cliente2.setId("MASTER");
        service.alterar(cliente2);

        for(Cliente cliente: service.listar()){
            System.out.println(cliente);
        }
    }
}
