package engtelecom.bcd.exemplo02;

import engtelecom.bcd.exemplo02.db.ConnectionFactory;

import java.sql.*;

public class ExemploMySQL {

    public void listarFuncionario(){

        String query = "SELECT * FROM Funcionario";

        try (
                PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(query);
                ResultSet resultado = stmt.executeQuery();
        ){
            //Faço a logica
            if (resultado.next() == false){
                System.out.println("Não tem linhas");
            }else {
                do{
                    int id = resultado.getInt("idFuncionario");
                    String nome = resultado.getString("Nome");

                    System.out.println("id: " + id);
                    System.out.println("nome" + nome);
                    System.out.println("----------");

                }while (resultado.next());
            }

        } catch (SQLException e) {
            System.err.println("Erro" + e);
        }
    }

    public static void main(String[] args) {
        ExemploMySQL app = new ExemploMySQL();

        app.listarFuncionario();

    }
}
