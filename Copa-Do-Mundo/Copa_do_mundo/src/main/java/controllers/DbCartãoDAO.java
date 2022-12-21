package controllers;

import db.ConnectionFactory;
import entities.Cartao;
import entities.Gol;

import java.sql.PreparedStatement;

public class DbCartãoDAO {

    public boolean insert(Cartao c) throws Exception {
        String query = "INSERT INTO Cartao (Jogador_idJogador,Cor_idCor,Partida_idPartida) VALUES (?,?,?)" ;

        PreparedStatement stmt = ConnectionFactory.getDBConnection().prepareStatement(query);

        stmt.setInt(1,c.getJogador_idJogador());
        stmt.setInt(2,c.getCor_idCor());
        stmt.setInt(3,c.getPartida_idPartida());

        return stmt.execute();
    }
}
