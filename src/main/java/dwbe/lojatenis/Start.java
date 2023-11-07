package dwbe.lojatenis;

import com.example.demo.controller.UsuarioService;
import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Start implements CommandLineRunner {

    @Autowired
    private UsuarioService service;

    public Start(UsuarioService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {

        service.gravarServiceUsuario(new Usuario("Caio", "cdottoni", "12345"));

        ArrayList<Usuario> listUsuarios = service.listarServiceUsuario();
        for(Usuario usuario: listUsuarios){
            System.out.println(usuario.getNome());
            System.out.println(usuario.getUsername());
            System.out.println(usuario.getPassword());
        }
    }
}
