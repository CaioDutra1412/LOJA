package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.Compra;
import dwbe.lojatenis.Model.DatabaseConnection;
import dwbe.lojatenis.Model.EntradaSaida;
import dwbe.lojatenis.Model.Estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
    private Connection connection;
    private EntradaSaidaDAO entradaSaidaDAO;
    private EstoqueDAO estoqueDAO;

    public CompraDAO() {
        this.connection = DatabaseConnection.getConnection();
        this.entradaSaidaDAO = new EntradaSaidaDAO();
        this.estoqueDAO = new EstoqueDAO();
    }

    public void cadastrarCompra(Compra compra) {
        var entradaSaida = new EntradaSaida(compra.getQtd(), compra.getValor(), compra.getData(), compra.getProdutoId());
        entradaSaidaDAO.cadastrarEntradaSaida(entradaSaida);
        String sql = "INSERT INTO Compra(id, fornecedorId) VALUES(?,?)";
        try (PreparedStatement pstmtCompra = connection.prepareStatement(sql)) {
            pstmtCompra.setInt(1, entradaSaida.getId());
            pstmtCompra.setInt(2, compra.getFornecedorId());
            pstmtCompra.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Estoque estoque = new Estoque(compra.getQtd(), 0, 100, compra.getProdutoId());
        estoqueDAO.cadastrarEstoque(estoque);
    }

    public List<Compra> listarCompras() {
        List<Compra> compras = new ArrayList<>();

        String sql = "SELECT * FROM Compra INNER JOIN EntradaSaida ON Compra.id = EntradaSaida.id";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int qtd = rs.getInt("qtd");
                double valor = rs.getDouble("valor");
                Date data = rs.getDate("data");
                int produtoId = rs.getInt("produtoId");
                int fornecedorId = rs.getInt("fornecedorId");

                Compra compra = new Compra(qtd, valor, data, produtoId, fornecedorId);
                compra.setId(id);
                compras.add(compra);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return compras;
    }
}
