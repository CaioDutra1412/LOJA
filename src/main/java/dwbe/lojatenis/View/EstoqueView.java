package dwbe.lojatenis.View;

import dwbe.lojatenis.Controller.EstoqueController;
import org.springframework.boot.CommandLineRunner;

public class EstoqueView implements CommandLineRunner {

    private final EstoqueController service = new EstoqueController();
    @Override
    public void run(String... args) throws Exception {
        for(int x=1; x<=5;x++){
            service.gravar(new Estoque("estoque" + x));
        }
        Estoque estoque2 = service.buscarPorId("estoque2");
        estoque2.setName("NIKE");
        service.alterar(estoque2);

        for(Estoque estoque: service.listar()){
            System.out.println(estoque);
        }
    }
}
