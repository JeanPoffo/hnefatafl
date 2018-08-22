package model;

/**
 * Classe Modelo da peça do jogo
 * @author Jean Poffo
 * @since  22/08/2018
 */
public class ModelPeca {
    
    private int id;
    
    private ModelJogador jogador;

    public ModelPeca() {}

    public ModelPeca(int id, ModelJogador jogador) {
        this.id      = id;
        this.jogador = jogador;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModelJogador getJogador() {
        return jogador;
    }

    public void setJogador(ModelJogador jogador) {
        this.jogador = jogador;
    }
}