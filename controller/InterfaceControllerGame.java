package controller;

import model.Peca;

/**
 * Interface do Controller do Game
 * @author Jean Poffo
 * @since 09/10/2018
 */
public interface InterfaceControllerGame {

    public int getNumeroLinhasTabuleiro();
    
    public int getNumeroColunasTabuleiro();
    
    public Peca getPecaTabuleiro(int linha, int coluna);
    
    public void movimentaPecaTabuleiro();
}