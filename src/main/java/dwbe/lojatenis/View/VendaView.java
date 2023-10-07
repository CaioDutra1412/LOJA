package dwbe.lojatenis.View;

import dwbe.lojatenis.Controller.VendaController;
import org.springframework.boot.CommandLineRunner;

public class VendaView implements CommandLineRunner {

    private final VendaController service = new VendaController();
    @Override
    public void run(String... args) throws Exception {
        for(int x=1; x<=5;x++){
            service.gravar(new Venda("venda" + x));
        }
        Venda venda2 = service.buscarPorId("venda2");
        venda2.setName("VENDA");
        service.alterar(venda2);

        for(Venda venda: service.listar()){
            System.out.println(venda);
        }
    }
}
