package model;

/**
 * Classe Modelo da peça do jogo
 * @author Jean Poffo
 * @since  22/08/2018
 */
public class Peca {
    
    private int id;
    
    private Jogador jogador;

    public Peca() {}

    public Peca(int id, Jogador jogador) {
        this.id      = id;
        this.jogador = jogador;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}