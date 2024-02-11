package cadastro.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorBD {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                // URL de conexão atualizada para incluir o banco de dados
                String url = "jdbc:sqlserver://localhost:1533;databaseName=estacio_db_1;encrypt=false";
                String user = "sa";
                String password = "julio102030";
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao obter conexao com o banco de dados: " + e.getMessage(), e);
            }
        }
        return conn;
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar o statement: " + e.getMessage(), e);
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar o resultSet: " + e.getMessage(), e);
        }
    }

    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados: " + e.getMessage(), e);
        }
    }

}
