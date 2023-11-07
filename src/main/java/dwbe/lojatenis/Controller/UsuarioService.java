package dwbe.lojatenis.Controller;

import com.example.demo.DAO.UsuarioDAO;
import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO userDAO;

    public void gravarServiceUsuario(Usuario user) {
        userDAO.gravarUsuarioDAO(user);
    }

    public ArrayList<Usuario> listarServiceUsuario() {
        return userDAO.buscarUsuariosDA0();
    }
}
