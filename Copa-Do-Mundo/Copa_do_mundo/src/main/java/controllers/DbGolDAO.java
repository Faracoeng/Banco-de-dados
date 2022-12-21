package controllers;

import db.ConnectionFactory;
import entities.Gol;
import entities.Jogador;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbGolDAO implements GolDAO{

    @Override
    public List<Gol> getAll() throws Exception {
        return null;
    }

    @Override
    public Gol getById(int idGol) throws Exception {
        return null;
    }

    @Override
    public String getArtilheiro() throws Exception {

        String nome = "";
        int gols_pre = 0;
        int gols_pro = 0;

        String query = "SELECT Jogador_idJogador, Jogador.idJogador, Jogador.nome, " +
                "COUNT(Jogador_idJogador) FROM Gol INNER JOIN Jogador " +
                "ON Jogador_idJogador=Jogador.idJogador GROUP BY Jogador_idJogador;";
        PreparedStatement stmt = ConnectionFactory.getDBConnection().prepareStatement(query);
        // Tipo um dataframe, chamo para pegar cada coluna do conjunto
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()){
            do {
                gols_pre = resultado.getInt("COUNT(Jogador_idJogador)");

                if (gols_pre > gols_pro){
                    gols_pro = gols_pre;
                    nome = resultado.getString("nome");
                }

            }while (resultado.next());
        }

        String retorno = nome + " com: " + gols_pro + " gols";

        return retorno;
    }

    @Override
    public boolean insert(Gol g) throws Exception {
        String query = "INSERT INTO Gol (Jogador_idJogador,Partida_idPartida,horario,ano) VALUES (?,?,?,?)" ;
        //String query = "INSERT INTO Gol (Jogador_idJogador,Partida_idPartida,horario,ano) VALUES ()"+g.getJogador_idJogador()+","+g.getPartida_idPartida()+","+g.getHorario()+","+g.getAno()+";";
        PreparedStatement stmt = ConnectionFactory.getDBConnection().prepareStatement(query);

        stmt.setInt(1,g.getJogador_idJogador());
        stmt.setInt(2,g.getPartida_idPartida());
        stmt.setInt(3,g.getHorario());
        stmt.setInt(4,g.getAno());

        return stmt.execute();
    }

    @Override
    public boolean update(Gol g) throws Exception {
        return false;
    }

    @Override
    public boolean delete(int idGol) throws Exception {
        return false;
    }

    public List<String> getGolsBrasileiros() throws Exception{

        ArrayList<String> lista_goleadores = new ArrayList<>();
        ArrayList<Integer> lista_ids = new ArrayList<>();

        String query = "select Gol.idGol,Gol.ano, Jogador.nome from Gol inner join Jogador on (Gol.Jogador_idJogador=Jogador.idJogador) inner join Jogador_has_Selecao on (Jogador.idJogador=Jogador_has_Selecao.Jogador_idJogador)\n" +
                "inner join Selecao on (Jogador_has_Selecao.Selecao_idSelecao=Selecao.idSelecao) where Selecao.Pais_idPais=1;";

        PreparedStatement stmt = ConnectionFactory.getDBConnection().prepareStatement(query);
        // Tipo um dataframe, chamo para pegar cada coluna do conjunto
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()){
            do {
                lista_goleadores.add(resultado.getString("ano") + " - " + resultado.getString("nome") + " 1 Gol!! ");
            }while (resultado.next());
        }
        return lista_goleadores;
    }

}
