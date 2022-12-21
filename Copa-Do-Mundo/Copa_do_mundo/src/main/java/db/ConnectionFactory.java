package db;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class  ConnectionFactory {

    private static Connection conexao;

    private static InputStream getDbProperties(){

        // Se a aplicação estiver empacotada em um arquivo JAR
        InputStream is = ConnectionFactory.class.getResourceAsStream("/resources/db.properties");

        // Se não estiver
        if (is == null){
            is = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
        }
        return is;
    }
    public static synchronized Connection getDBConnection() {

        try {
            Properties properties = new Properties();
            properties.load(getDbProperties());


            String host = properties.getProperty("host");
            String port = properties.getProperty("port");
            String db = properties.getProperty("database");
            String dbURI = "jdbc:mysql://" + host + ":" + port + "/" + db;
            conexao = DriverManager.getConnection(dbURI,properties);

            //conexao = DriverManager.getConnection(DB_URI,config.toProperties());
        } catch (SQLException e) {
            System.err.println("Erro: " + e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return conexao;
    }

}
