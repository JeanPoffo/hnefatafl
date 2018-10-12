package model;

/**
 * Classe Modelo de Game
 * @author Jean Poffo
 * @since 20/08/2018
 */
public class Game {
    
    final int MODO_HNEFATAFL = 1;
    final int MODO_BRANDUBH  = 2;
    final int MODO_TABLUT    = 3;
    
    private int modoJogo;
    
    private Jogador jogadorUm;
    
    private Jogador jogadorDois;

    public Game() {}
    
    public Game(int modoJogo, Jogador jogadorUm, Jogador jogadorDois) {
        this.modoJogo    = modoJogo;
        this.jogadorUm   = jogadorUm;
        this.jogadorDois = jogadorDois;
    }

    public int getModoJogo() {
        return modoJogo;
    }

    public void setModoJogo(int modoJogo) {
        this.modoJogo = modoJogo;
    }

    public Jogador getJogadorUm() {
        return jogadorUm;
    }

    public void setJogadorUm(Jogador jogadorUm) {
        this.jogadorUm = jogadorUm;
    }

    public Jogador getJogadorDois() {
        return jogadorDois;
    }

    public void setJogadorDois(Jogador jogadorDois) {
        this.jogadorDois = jogadorDois;
    }
}