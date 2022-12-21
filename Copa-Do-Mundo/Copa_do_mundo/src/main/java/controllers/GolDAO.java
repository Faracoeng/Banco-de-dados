package controllers;

import entities.Gol;

import java.sql.ResultSet;
import java.util.List;

public interface GolDAO {

    //SELECT
    public List<Gol> getAll() throws Exception;

    //SELECT where IDfUNCIONARIOS
    public Gol getById(int idGol) throws Exception;

    public String getArtilheiro() throws Exception;

    boolean insert(Gol g) throws Exception;
    boolean update(Gol g) throws Exception;
    boolean delete(int idGol) throws Exception;
}
