package engtelecom.bcd.exemplo02.entities;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Funcionarios {
    private int idFuncionario;
    private String nome;
    private String sobrenome;
    private int idDepartamento;
}
