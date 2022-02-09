package db;

import java.sql.Connection;

public abstract class Conexao {
    
    // Este atributo vai representar minha conexão
    private static Connection conexao;

    
    public static synchronized Connection getConexoa(){



        return conexao;
    }
}
