package entities;
import lombok.*;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
//@AllArgsConstructor
public class Cartao {
    private int Jogador_idJogador;

    public Cartao(int jogador_idJogador, int cor_idCor, int partida_idPartida) {
        Jogador_idJogador = jogador_idJogador;
        Cor_idCor = cor_idCor;
        Partida_idPartida = partida_idPartida;
    }

    public int getJogador_idJogador() {
        return Jogador_idJogador;
    }

    public void setJogador_idJogador(int jogador_idJogador) {
        Jogador_idJogador = jogador_idJogador;
    }

    public int getCor_idCor() {
        return Cor_idCor;
    }

    public void setCor_idCor(int cor_idCor) {
        Cor_idCor = cor_idCor;
    }

    public int getPartida_idPartida() {
        return Partida_idPartida;
    }

    public void setPartida_idPartida(int partida_idPartida) {
        Partida_idPartida = partida_idPartida;
    }

    private int Cor_idCor;
    private int Partida_idPartida;

}
