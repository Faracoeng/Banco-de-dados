package controllers;

import entities.Jogador;

import java.util.List;

public interface JogadorDAO {

    //SELECT
    public List<Jogador> getAll() throws Exception;

    //SELECT where IDfUNCIONARIOS
    public Jogador getById(int idJogador) throws Exception;

    boolean insert(Jogador j) throws Exception;
    boolean update(Jogador j) throws Exception;
    boolean delete(int idJogador) throws Exception;

}
