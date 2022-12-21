package engtelecom.bcd.exemplo01.db;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectionFactory {
    private final static String DB_URI = "jdbc:sqlite:src/main/resources/funcionario-departamento.sqlite";
    private static SQLiteConfig config = new SQLiteConfig();
    private static Connection conexao;

    public static synchronized Connection getConnection(){
        config.enforceForeignKeys(true);
        try {
            conexao = DriverManager.getConnection(DB_URI,config.toProperties());
        } catch (SQLException e) {
            System.err.println("Erro: " + e);
        }
        return conexao;
    }
}
