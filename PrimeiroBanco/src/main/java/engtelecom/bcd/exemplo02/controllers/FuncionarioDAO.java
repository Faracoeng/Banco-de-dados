package engtelecom.bcd.exemplo02.controllers;

import engtelecom.bcd.exemplo02.entities.Funcionarios;
import lombok.*;

import java.util.List;


public interface FuncionarioDAO {

    //SELECT
    public List<Funcionarios> getAll() throws Exception;

    //SELECT where IDfUNCIONARIOS
    public Funcionarios getById(int idFuncionario) throws Exception;

    boolean insert(Funcionarios f) throws Exception;
    boolean update(Funcionarios f) throws Exception;
    boolean delete(int idFuncionario) throws Exception;
}
