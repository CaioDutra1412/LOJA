package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class VendaDAO {
    private Connection connection;

    public VendaDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public boolean cadastrarVenda(Venda venda) {
        var entradaSaida = new EntradaSaida(venda.getQtd(), venda.getValor(), venda.getData(), venda.getProdutoId());
        var daoEntradaSaida = new EntradaSaidaDAO();
        var estoqueDao = new EstoqueDAO();
        daoEntradaSaida.cadastrarEntradaSaida(entradaSaida);

        String sql = "INSERT INTO Venda(id, clienteId) VALUES(?,?)";

        try (PreparedStatement pstmtVenda = connection.prepareStatement(sql)) {
            pstmtVenda.setInt(1, entradaSaida.getId());
            pstmtVenda.setInt(2, venda.getClienteId());
            pstmtVenda.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        Estoque estoque = estoqueDao.buscarEstoquePorProduto(venda.getProdutoId());

        estoque.setQtd(estoque.getQtd() - venda.getQtd());

        estoqueDao.alterarEstoque(estoque);
        return true;
    }

    public List<Venda> listarVendas() {
        List<Venda> vendas = new ArrayList<>();

        String sql = "SELECT * FROM Venda INNER JOIN EntradaSaida ON Venda.id = EntradaSaida.id";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int qtd = rs.getInt("qtd");
                double valor = rs.getDouble("valor");
                Date data = rs.getDate("data");
                int produtoId = rs.getInt("produtoId");
                int clienteId = rs.getInt("clienteId");

                Venda venda = new Venda(qtd, valor, data, produtoId, clienteId);
                venda.setId(id);
                vendas.add(venda);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return vendas;
    }
}
