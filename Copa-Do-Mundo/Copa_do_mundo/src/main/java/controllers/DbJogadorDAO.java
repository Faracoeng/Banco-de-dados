package controllers;

import db.ConnectionFactory;
import entities.Jogador;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Essa clase deve ter todas as instruções SQL
public class DbJogadorDAO implements JogadorDAO{


    private Jogador getJogador(ResultSet rs) throws Exception{
        int id = rs.getInt("idJogador");
        Date data_nascimento = rs.getDate("data_nascimento");
        String nome = rs.getString("nome");
        String sobrenome = rs.getString("Sobrenome");
        int Posicao_idPosicao = rs.getInt("Posicao_idPosicao");

        Jogador j = new Jogador(id, data_nascimento, nome, sobrenome, Posicao_idPosicao);
        return j;
    }

    @Override
    public List<Jogador> getAll() throws Exception {
        ArrayList<Jogador> lista = new ArrayList<>();

        String query = "SELECT * FROM Jogador";

        PreparedStatement stmt = ConnectionFactory.getDBConnection().prepareStatement(query);
        // Tipo um dataframe, chamo para pegar cada coluna do conjunto
        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()){
            do {
                lista.add(this.getJogador(resultado));
            }while (resultado.next());
        }


        return lista;
    }

    @Override
    public Jogador getById(int idJogador) throws Exception {
        return null;
    }

    @Override
    public boolean insert(Jogador j) throws Exception {
        return false;
    }

    @Override
    public boolean update(Jogador j) throws Exception {
        return false;
    }

    @Override
    public boolean delete(int idJogador) throws Exception {
        return false;
    }

    public List<String> get_atacantes(int ano) throws Exception{

        ArrayList<String> lista_atacantes = new ArrayList<>();


        String query = "SELECT  Jogador.idJogador,Jogador.nome, Jogador.Posicao_idPosicao, Jogador_has_Selecao.Selecao_idSelecao, Selecao.Pais_idPais, Pais.sigla, Participacao_selecao.Copa_ano  from Jogador inner join Jogador_has_Selecao on (Jogador.idJogador=Jogador_has_Selecao.Jogador_idJogador) inner join Selecao on (Jogador_has_Selecao.Selecao_idSelecao=Selecao.idSelecao) inner join Pais on (Selecao.Pais_idPais=Pais.idPais) inner join Participacao_selecao on (Jogador_has_Selecao.Selecao_idSelecao=Participacao_selecao.Selecao_idSelecao) where Jogador.Posicao_idPosicao = 1 and Participacao_selecao.Copa_ano="+ano;
        PreparedStatement stmt = ConnectionFactory.getDBConnection().prepareStatement(query);
        // Tipo um dataframe, chamo para pegar cada coluna do conjunto

        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()){
            do {
                lista_atacantes.add(resultado.getString("sigla") + " - " + resultado.getString("nome"));
            }while (resultado.next());
        }


        return lista_atacantes;
    }
}
