package dwbe.lojatenis.View;

import dwbe.lojatenis.Controller.FuncionarioController;
import org.springframework.boot.CommandLineRunner;

public class FuncionarioView implements CommandLineRunner {

    private final FuncionarioController service = new FuncionarioController();
    @Override
    public void run(String... args) throws Exception {
        for(int x=1; x<=5;x++){
            service.gravar(new Funcionario("funcionario" + x));
        }
        Funcionario funcionario2 = service.buscarPorId("funcionario2");
        funcionario2.setName("BEATRIZ");
        service.alterar(funcionario2);

        for(Funcionario funcionario: service.listar()){
            System.out.println(funcionario);
        }
    }
}
