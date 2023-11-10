package dwbe.lojatenis.View;

import dwbe.lojatenis.Controller.CompraController;
import dwbe.lojatenis.Model.Compra;
import dwbe.lojatenis.Model.Produto;

import java.util.Date;

public class CompraView {
    private final CompraController service = new CompraController();
    //@Override
    public void run(String... args) throws Exception {
        for(int x=1; x<=5;x++){
            service.gravar(new Compra("1", 4, 30.70, new Date(10,03,2023), null, null));
        }
        Compra compra1 = service.buscarPorId("user2");
        compra1.setId("MASTER");
        service.alterar(compra1);

        for(Compra compra: service.listar()){
            System.out.println(compra);
        }
    }
}
