package dwbe.lojatenis.DAO;

import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;


@Repository
public class UsuarioDAO {

    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String USUARIO;

    @Value("${spring.datasource.password}")
    private String SENHA;

    public void gravarUsuarioDAO(Usuario user) {

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "INSERT INTO usuario (name, username, password) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getNome());
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getPassword());

                preparedStatement.executeUpdate();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Usuario> buscarUsuariosDA0() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "SELECT * FROM usuario";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Usuario usuario = new Usuario();
                        usuario.setNome(resultSet.getString("name"));
                        usuario.setUsername(resultSet.getString("username"));
                        usuario.setPassword(resultSet.getString("password"));

                        usuarios.add(usuario);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

}
