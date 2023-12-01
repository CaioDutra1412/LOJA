package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.DatabaseConnection;
import dwbe.lojatenis.Model.Fornecedor;
import dwbe.lojatenis.Model.Pessoa;
import dwbe.lojatenis.Model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class FornecedorDAO {
    private int idFornecedor;
    private Connection connection;

    public FornecedorDAO() {
        this.idFornecedor = 3;
        this.connection = DatabaseConnection.getConnection();
    }

    public int getIdFornecedor(){
        return idFornecedor;
    }
    public void setIdFornecedor() {this.idFornecedor++;};

    public void cadastrarFornecedor(Fornecedor fornecedor) {
        var pessoa = new Pessoa(fornecedor.getNome(), fornecedor.getCpf(), fornecedor.getEndereco(), fornecedor.getSexo(), fornecedor.getTelefone(), fornecedor.getEmail());
        var daoPessoa = new PessoaDAO();
        daoPessoa.cadastrarPessoa(pessoa);

        String sql = "INSERT INTO Fornecedor(id, cnpj, numeroInscricao, nomeFantasia, dataDeAbertura, porte, atividadeEconomicaPrincipal, situacaoCadastral) VALUES(?,?,?,?,?,?,?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, pessoa.getId());
            pstmt.setString(2, fornecedor.getCnpj());
            pstmt.setInt(3, fornecedor.getNumeroInscricao());
            pstmt.setString(4, fornecedor.getNomeFantasia());
            pstmt.setString(5, fornecedor.getDataDeAbertura());
            pstmt.setString(6, fornecedor.getPorte());
            pstmt.setString(7, fornecedor.getAtividadeEconomicaPrincipal());
            pstmt.setString(8, fornecedor.getSituacaoCadastral());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    fornecedor.setId(pessoa.getId());
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Fornecedor> listarFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<>();

        String sql = "SELECT * FROM Fornecedor INNER JOIN Pessoa ON Fornecedor.id = Pessoa.id";

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
                String cnpj = rs.getString("cnpj");
                int numeroInscricao = rs.getInt("numeroInscricao");
                String nomeFantasia = rs.getString("nomeFantasia");
                String dataDeAbertura = rs.getString("dataDeAbertura");
                String porte = rs.getString("porte");
                String atividadeEconomicaPrincipal = rs.getString("atividadeEconomicaPrincipal");
                String situacaoCadastral = rs.getString("situacaoCadastral");

                Fornecedor fornecedor = new Fornecedor(nome, cpf, endereco, sexo, telefone, email, cnpj, numeroInscricao, nomeFantasia, dataDeAbertura, porte, atividadeEconomicaPrincipal, situacaoCadastral);
                fornecedor.setId(id);
                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return fornecedores;
    }
    public Fornecedor buscarFornecedor(int id) {
        Fornecedor fornecedor = null;
        String sql = "SELECT * FROM Fornecedor INNER JOIN Pessoa ON Fornecedor.id = Pessoa.id WHERE Fornecedor.id = ?";

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
                String cnpj = rs.getString("cnpj");
                int numeroInscricao = rs.getInt("numeroInscricao");
                String nomeFantasia = rs.getString("nomeFantasia");
                String dataDeAbertura = rs.getString("dataDeAbertura");
                String porte = rs.getString("porte");
                String atividadeEconomicaPrincipal = rs.getString("atividadeEconomicaPrincipal");
                String situacaoCadastral = rs.getString("situacaoCadastral");

                fornecedor = new Fornecedor(nome, cpf, endereco, sexo, telefone, email, cnpj, numeroInscricao, nomeFantasia, dataDeAbertura, porte, atividadeEconomicaPrincipal, situacaoCadastral);
                fornecedor.setId(id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return fornecedor;
    }

    public boolean fornecedorTemProduto(int id) {
        String sql = "SELECT COUNT(*) FROM Produto WHERE fornecedorId = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean excluirFornecedor(int id) {
        if (fornecedorTemProduto(id)) {
            System.out.println("Não é possível excluir o fornecedor pois ele tem produtos associados.");
            return false;
        }

        String sql = "DELETE FROM Fornecedor WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao excluir fornecedor. Nenhuma linha foi afetada.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
