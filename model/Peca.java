package model;

import javax.swing.ImageIcon;

/**
 * Classe Modelo da peça do jogo
 * @author Jean Poffo
 * @since  22/08/2018
 */
abstract public class Peca {
    
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
    
    public boolean podeMovimentarRefugio() {
        return false;
    }
    
    public boolean pecaRei() {
        return false;
    }
    
    abstract public ImageIcon getIcone();
}