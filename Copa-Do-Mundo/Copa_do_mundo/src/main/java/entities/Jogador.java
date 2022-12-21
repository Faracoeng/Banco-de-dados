package entities;

import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jogador {
    private int idJogador;
    private Date data_nascimento;
    private String nome;
    private String sobrenome;
    private int Posicao_idPosicao;

    public Jogador(int idJogador, Date data_nascimento, String nome, String sobrenome, int posicao_idPosicao) {
        this.idJogador = idJogador;
        this.data_nascimento = data_nascimento;
        this.nome = nome;
        this.sobrenome = sobrenome;
        Posicao_idPosicao = posicao_idPosicao;
    }
}
