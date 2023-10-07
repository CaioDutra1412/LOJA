package dwbe.lojatenis.View;

import dwbe.lojatenis.Controller.PessoaController;
import org.springframework.boot.CommandLineRunner;

public class PessoaView implements CommandLineRunner {

    private final PessoaController service = new PessoaController();
    @Override
    public void run(String... args) throws Exception {
        for(int x=1; x<=5;x++){
            service.gravar(new Pessoa("pessoa" + x));
        }
        Pessoa pessoa2 = service.buscarPorId("pessoa2");
        pessoa2.setName("PESSOA");
        service.alterar(pessoa2);

        for(Pessoa pessoa: service.listar()){
            System.out.println(pessoa);
        }
    }
}
