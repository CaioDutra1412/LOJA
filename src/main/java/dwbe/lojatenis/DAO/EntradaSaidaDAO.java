package dwbe.lojatenis.DAO;

import dwbe.lojatenis.Model.DatabaseConnection;
import dwbe.lojatenis.Model.EntradaSaida;

import java.sql.*;
import java.util.List;

public class EntradaSaidaDAO {
    private Connection connection;

    public EntradaSaidaDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void cadastrarEntradaSaida(EntradaSaida entradaSaida) {
        String sql = "INSERT INTO EntradaSaida(qtd, valor, data, produtoId) VALUES(?,?,?,?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, entradaSaida.getQtd());
            pstmt.setDouble(2, entradaSaida.getValor());
            pstmt.setDate(3, new java.sql.Date(entradaSaida.getData().getTime()));
            pstmt.setInt(4, entradaSaida.getProdutoId());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao criar a venda. Nenhuma linha foi afetada.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entradaSaida.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao criar a venda, nenhum ID obtido.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}