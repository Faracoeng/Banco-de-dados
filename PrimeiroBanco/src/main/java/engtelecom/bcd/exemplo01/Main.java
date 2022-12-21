package engtelecom.bcd.exemplo01;

import engtelecom.bcd.exemplo01.db.ConnectionFactory;

import java.sql.*;
import java.util.Scanner;

public class Main {
    //private final String DB_URI = "jdbc:sqlite:src/main/resources/funcionario-departamento.sqlite";

    public void listarFuncionario(){

        String query = "SELECT * FROM Funcionario";

        try (Connection conexao = ConnectionFactory.getConnection();
             Statement console = conexao.createStatement();
             ResultSet resultado = console.executeQuery(query);
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

    public void listarFuncionarios(int idFuncionario){

        String query = "SELECT * FROM Funcionario WHERE idFuncionario="+idFuncionario;

        try (Connection conexao = ConnectionFactory.getConnection();
             Statement console = conexao.createStatement();
             ResultSet resultado = console.executeQuery(query);
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

    public void listarPorSobrenomeNome(String sNome){

        String query = "SELECT * FROM Funcionario WHERE Sobrenome= ?";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement console = conexao.prepareStatement(query);

        ){
            console.setString(1,sNome);
            ResultSet resultado = console.executeQuery();
            //Faço a logica
            if (resultado.next() == false){
                System.out.println("Não tem linhas");
            }else {
                do{
                    int id = resultado.getInt("idFuncionario");
                    String sobrenome = resultado.getString("Sobrenome");

                    System.out.println("id: " + id);
                    System.out.println("Sobrenome: " + sobrenome);
                    System.out.println("----------");

                }while (resultado.next());
            }

        } catch (SQLException e) {
            System.err.println("Erro" + e);
        }
    }

    //public void cadastrarFuncionario(int id, String nome, String sobrenome, int departamento){

        //String query = "INSERT INTO Funcionario (idFuncionario, Nome, Sobrenome, idDepartamento) " +
          //      "VALUES ("+ id + ", '"+ nome + "'" + ","+"'" + sobrenome + "'" + ","+ + departamento + ")" ;

//        try (Connection conexao = DriverManager.getConnection(DB_URI);
//             Statement console = conexao.createStatement();
//
//        ){
//            //Faço a logica
//            int resultado = console.executeUpdate(query);
//            if (resultado > 0){
//                System.out.println("Cadastrado com sucesso");
//            }
//
//        } catch (SQLException e) {
//            System.err.println("Erro" + e);
//        }
//    }

    public static void main(String[] args) {
        Main app = new Main();

        Scanner teclado = new Scanner(System.in);

        System.out.println("Entre com o sobrenome");
        String snome = teclado.nextLine();

        //app.listarFuncionario();
        //app.listarFuncionarios(1);
        app.listarPorSobrenomeNome(snome);
        //app.cadastrarFuncionario(999,"George", "Hams", 1);
    }
}