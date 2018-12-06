package model;

import controller.Visitor;

/**
 * Classe de Casa do Tabuleiro
 * @author Jean Poffo
 * @since  14/10/2018
 */
public class CasaTabuleiro {
    
    private boolean refugio;
    
    private boolean trono;
    
    private int posicaoX;
    
    private int posicaoY;
    
    private Peca peca;

    public CasaTabuleiro(boolean refugio) {
        this.refugio = refugio;
    }
    
    public void accept(Visitor visitor) {
        visitor.visit(this.peca);
    }
    
    public boolean isTrono() {
        return trono;
    }

    public void setTrono(boolean trono) {
        this.trono = trono;
    }
    
    public boolean isRefugio() {
        return refugio;
    }

    public void setRefugio(boolean refugio) {
        this.refugio = refugio;
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }
    
    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
}