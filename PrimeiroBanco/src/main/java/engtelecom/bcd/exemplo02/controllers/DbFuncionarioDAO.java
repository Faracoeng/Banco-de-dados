package engtelecom.bcd.exemplo02.controllers;

import engtelecom.bcd.exemplo02.db.ConnectionFactory;
import engtelecom.bcd.exemplo02.entities.Funcionarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Essa clase deve ter todas as instruções SQL

public class DbFuncionarioDAO implements FuncionarioDAO{


    private Funcionarios getFuncionario(ResultSet rs) throws Exception{
        int id = rs.getInt("idFuncionario");
        String nome = rs.getString("Nome");
        String sobrenome = rs.getString("Sobrenome");
        int idDpto = rs.getInt("idDepartamento");

        Funcionarios f = new Funcionarios(id, nome, sobrenome, idDpto);
        return f;
    }


    @Override
    public List<Funcionarios> getAll() throws Exception {

        ArrayList<Funcionarios> lista = new ArrayList<>();

        String query = "SELECT * FROM Funcionario";

        PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(query);
        // Tipo um dataframe, chamo para pegar cada coluna do conjunto
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()){
            do {
                lista.add(this.getFuncionario(resultado));
            }while (resultado.next());
        }


        return lista;
    }

    @Override
    public Funcionarios getById(int idFuncionario) throws Exception {

        String query = "SELECT * FROM Funcionario WHERE idFuncionario= ?";

        PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(query);
        stmt.setInt(1,idFuncionario);
        ResultSet resultado = stmt.executeQuery();

        if(resultado.next()){
            return this.getFuncionario(resultado);
        }

        return null;
    }

    @Override
    public boolean insert(Funcionarios f) throws Exception {

        String query = "INSERT INTO Funcionario VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(query);

        // Parametros que substituem os pontos de interrogação
        stmt.setInt(1,f.getIdFuncionario());
        stmt.setString(2,f.getNome());
        stmt.setString(3,f.getSobrenome());
        stmt.setInt(4,f.getIdDepartamento());

        return stmt.execute();
    }

    @Override
    public boolean update(Funcionarios f) throws Exception {
        return false;
    }

    @Override
    public boolean delete(int idFuncionario) throws Exception {

        String query = "DELETE FROM Funcionario WHERE idFuncionario=?";

        PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(query);

        stmt.setInt(1,idFuncionario);

        return stmt.execute();
    }
}
