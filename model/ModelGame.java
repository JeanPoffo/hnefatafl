package model;

/**
 * Classe Modelo de Game
 * @author Jean Poffo
 * @since 20/08/2018
 */
public class ModelGame {
    
    final int MODO_HNEFATAFL = 1;
    final int MODO_BRANDUBH  = 2;
    final int MODO_TABLUT    = 3;
    
    private int modoJogo;
    
    private ModelJogador jogadorUm;
    
    private ModelJogador jogadorDois;

    public ModelGame() {}
    
    public ModelGame(int modoJogo, ModelJogador jogadorUm, ModelJogador jogadorDois) {
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

    public ModelJogador getJogadorUm() {
        return jogadorUm;
    }

    public void setJogadorUm(ModelJogador jogadorUm) {
        this.jogadorUm = jogadorUm;
    }

    public ModelJogador getJogadorDois() {
        return jogadorDois;
    }

    public void setJogadorDois(ModelJogador jogadorDois) {
        this.jogadorDois = jogadorDois;
    }
}