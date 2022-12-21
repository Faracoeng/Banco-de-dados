package engtelecom.bcd.exemplo02;

import engtelecom.bcd.exemplo02.controllers.DbFuncionarioDAO;
import engtelecom.bcd.exemplo02.entities.Funcionarios;

import java.util.ArrayList;
import java.util.List;

public class Exemplo02 {

    //Ideia aqui é usar o FUNCIONARIODAO

    public static void main(String[] args)  throws Exception{
        DbFuncionarioDAO dbFuncionarioDAO = new DbFuncionarioDAO();

        List<Funcionarios> lista = dbFuncionarioDAO.getAll();

        //iterando uma lista com method reference - java8
        //lista.forEach(System.out::println);

        // Usando o metodo GetById criado
        System.out.println(dbFuncionarioDAO.getById(879));

        // Inserindo funcionario
       //Funcionarios f = new Funcionarios(879,"Pirlo", "Damata", 4);

       //dbFuncionarioDAO.insert(f);
        //dbFuncionarioDAO.delete(879);

    }
}
