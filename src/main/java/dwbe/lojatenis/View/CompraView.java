package dwbe.lojatenis.View;

import dwbe.lojatenis.Controller.CompraController;
import org.springframework.boot.CommandLineRunner;

public class CompraView implements CommandLineRunner {

    private final CompraController service = new CompraController();
    @Override
    public void run(String... args) throws Exception {
        for(int x=1; x<=5;x++){
            service.gravar(new Compra("compra" + x));
        }
        Compra compra2 = service.buscarPorId("compra2");
        compra2.setName("COMPRA 2");
        service.alterar(compra2);

        for(Compra compra: service.listar()){
            System.out.println(compra);
        }
    }
}
