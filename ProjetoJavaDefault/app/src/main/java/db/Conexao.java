package db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class Conexao {
    
    // Este atributo vai representar minha conexão
    private static Connection conexao;
    //Criar atributo para ler credenciais do arquivo
    private static final String DB_PROPERTIES = "database.properties";



    public static InputStream getInputStream(){
            // O getResourceAsStream pega ali o arquivo do diretorio resources
            // como parametro da funcao, mando o nome do arquivo ali, que foi definido como constante
            // Dessa forma como esta, funciona usando uma IDE, se empacotar o projeto em JAR
            // Não funciona,dai se estiver em JAR usar:
            InputStream entrada = Conexao.class.getResourceAsStream("/resources"+DB_PROPERTIES);
            // Se estiver na IDE, pega assim
            if (entrada == null){
                entrada = Conexao.class.getClassLoader().getResourceAsStream(DB_PROPERTIES);
            }
        return entrada;
    }

    // synchronized para nao ocorrer conflitos em consultas no banco 
    public static synchronized Connection getConexao(){

        //String dbUri = "jdbc:sqlite://ampto.sj.ifsc.edu.br:33006/lab01emerson?user=emerson&password=bcd1234";
        //String dbUri = "jdbc:mysql://ampto.sj.ifsc.edu.br:33006/lab01emerson?user=emerson&password=bcd1234";

        Properties credenciais = new Properties();

        try {
            credenciais.load((getInputStream())); 
            
            String host = credenciais.getProperty("host");
            String port = credenciais.getProperty("port");
            String database = credenciais.getProperty("database");
            String dbURI = "jdbc:mysql://" + host + ":" + port + "/" + database;

            // o parametro de credenciais aqui é para pegar "user" e "password" que ja  pega
            // nativamente no formato abaixo, só tem que estar as credenciais la no arquivo obviamente
            conexao = DriverManager.getConnection(dbURI,credenciais);

        } catch(SQLException e){
            e.printStackTrace();
        }catch(IOException d){
            d.printStackTrace();
        }

        return conexao;
    }
}
