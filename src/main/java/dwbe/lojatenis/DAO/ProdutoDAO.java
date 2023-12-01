package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.DatabaseConnection;
import dwbe.lojatenis.Model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void cadastrarProduto(Produto produto) {
        String sql = "INSERT INTO produto(preco, tamanho, cor, marca, tipo, fornecedorId) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDouble(1, produto.getPreco());
            pstmt.setString(2, produto.getTamanho());
            pstmt.setString(3, produto.getCor());
            pstmt.setString(4, produto.getMarca());
            pstmt.setString(5, produto.getTipo());
            pstmt.setInt(6, produto.getFornecedorId());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    produto.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Produto> listarProdutos(String sql, Object... params) {
        List<Produto> produtos = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                double preco = rs.getDouble("preco");
                String tamanho = rs.getString("tamanho");
                String cor = rs.getString("cor");
                String marca = rs.getString("marca");
                String tipo = rs.getString("tipo");
                int fornecedorId = rs.getInt("fornecedorId");

                Produto produto = new Produto(preco, tamanho, cor, marca, tipo, fornecedorId);
                produto.setId(id);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return produtos;
    }

    public List<Produto> listarProdutos() {
        return listarProdutos("SELECT * FROM Produto");
    }

    public List<Produto> listarProdutosPorFornecedor(int idFornecedor) {
        return listarProdutos("SELECT * FROM Produto WHERE fornecedorId = ?", idFornecedor);
    }

    public Produto buscarProduto(int id) {
        Produto produto = null;
        String sql = "SELECT * FROM Produto WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                double preco = rs.getDouble("preco");
                String tamanho = rs.getString("tamanho");
                String cor = rs.getString("cor");
                String marca = rs.getString("marca");
                String tipo = rs.getString("tipo");
                int fornecedorId = rs.getInt("fornecedorId");

                produto = new Produto(preco, tamanho, cor, marca, tipo, fornecedorId);
                produto.setId(id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return produto;
    }
    public void excluirProduto(int id) {
        String sql = "DELETE FROM Produto WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao excluir o produto. Nenhuma linha foi afetada.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
