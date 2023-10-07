package dwbe.lojatenis.View;

import dwbe.lojatenis.Controller.ProdutoController;
import org.springframework.boot.CommandLineRunner;

public class ProdutoView implements CommandLineRunner {

    private final ProdutoController service = new ProdutoController();
    @Override
    public void run(String... args) throws Exception {
        for(int x=1; x<=5;x++){
            service.gravar(new Produto("produto" + x));
        }
        Produto produto2 = service.buscarPorId("produto2");
        produto2.setName("TENIS");
        service.alterar(produto2);

        for(Produto produto: service.listar()){
            System.out.println(produto);
        }
    }
}
