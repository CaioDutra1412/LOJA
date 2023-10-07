package dwbe.lojatenis.View;

import dwbe.lojatenis.Controller.FornecedorController;
import org.springframework.boot.CommandLineRunner;

public class FornecedorView implements CommandLineRunner {

    private final FornecedorController service = new FornecedorController();
    @Override
    public void run(String... args) throws Exception {
        for(int x=1; x<=5;x++){
            service.gravar(new Fornecedor("fornecedor" + x));
        }
        Fornecedor fornecedor2 = service.buscarPorCNPJ("fornecedor2");
        fornecedor.setName("MASTER");
        service.alterar(fornecedor);

        for(Fornecedor fornecedor: service.listar()){
            System.out.println(fornecedor);
        }
    }
}
