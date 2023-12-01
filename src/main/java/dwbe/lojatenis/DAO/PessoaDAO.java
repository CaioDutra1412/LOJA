package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.DatabaseConnection;
import dwbe.lojatenis.Model.Fornecedor;
import dwbe.lojatenis.Model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    private Connection connection;

    public PessoaDAO() {
        this.connection = DatabaseConnection.getConnection();
    }
    public void cadastrarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO Pessoa(nome, cpf, endereco, sexo, telefone, email) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getCpf());
            pstmt.setString(3, pessoa.getEndereco());
            pstmt.setString(4, pessoa.getSexo());
            pstmt.setString(5, pessoa.getTelefone());
            pstmt.setString(6, pessoa.getEmail());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha na criação do usuário. Nenhuma linha foi afetada.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pessoa.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha na criação do usuário, nenhum ID obtido.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Pessoa> listarPessoa() {
        List<Pessoa> pessoas = new ArrayList<>();

        String sql = "SELECT * FROM Pessoa";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String endereco = rs.getString("endereco");
                String sexo = rs.getString("sexo");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");

                Pessoa pessoa = new Pessoa(nome, cpf, endereco, sexo, telefone, email);
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return pessoas;
    }

    public void excluirPessoa(int id) {
        String sql = "DELETE FROM Pessoa WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao excluir pessoa. Nenhuma linha foi afetada.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
