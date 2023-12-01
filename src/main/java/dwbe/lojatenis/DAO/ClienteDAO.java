package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.Cliente;
import dwbe.lojatenis.Model.DatabaseConnection;
import dwbe.lojatenis.Model.Pessoa;
import dwbe.lojatenis.Model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public void cadastrarCliente(Cliente cliente) {
        var daoPessoa = new PessoaDAO();
        var pessoa = new Pessoa(cliente.getNome(), cliente.getCpf(), cliente.getEndereco(), cliente.getSexo(), cliente.getTelefone(), cliente.getEmail());
        daoPessoa.cadastrarPessoa(pessoa);

        String sql = "INSERT INTO Cliente(id, status) VALUES(?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, pessoa.getId());
            pstmt.setString(2, cliente.getStatus());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha na criação do usuário. Nenhuma linha foi afetada.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cliente.setId(pessoa.getId());
                } else {
                    throw new SQLException("Falha ao criar usuário, nenhum ID obtido.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM Cliente INNER JOIN Pessoa ON Cliente.id = Pessoa.id";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                String sexo = rs.getString("sexo");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String status = rs.getString("status");

                Cliente cliente = new Cliente(nome, cpf, endereco, sexo, telefone, email, status);
                cliente.setId(id);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return clientes;
    }

    public Cliente buscarCliente(int id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM Cliente INNER JOIN Pessoa ON Cliente.id = Pessoa.id WHERE Cliente.id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                String sexo = rs.getString("sexo");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String status = rs.getString("status");

                cliente = new Cliente(nome, cpf, endereco, sexo, telefone, email, status);
                cliente.setId(id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cliente;
    }
    public void excluirCliente(int id) {
        String sql = "DELETE FROM Cliente WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falhou ao deletar o Cliente.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
