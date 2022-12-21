package entities;

import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
//@AllArgsConstructor
public class Gol {
    //private int idGol;
    private int Jogador_idJogador;
    private int Partida_idPartida;
    private int horario;
    private int ano;

    public int getJogador_idJogador() {
        return Jogador_idJogador;
    }

    public void setJogador_idJogador(int jogador_idJogador) {
        Jogador_idJogador = jogador_idJogador;
    }

    public int getPartida_idPartida() {
        return Partida_idPartida;
    }

    public void setPartida_idPartida(int partida_idPartida) {
        Partida_idPartida = partida_idPartida;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Gol(int jogador_idJogador, int partida_idPartida, int horario, int ano) {
        Jogador_idJogador = jogador_idJogador;
        Partida_idPartida = partida_idPartida;
        this.horario = horario;
        this.ano = ano;
    }
}
