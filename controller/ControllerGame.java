package controller;

import model.Game;
import model.Peca;

/**
 * Controller principal da aplicação
 * @author Jean Poffo
 * @since 09/08/2018
 */
public class ControllerGame implements InterfaceControllerGame{
    
    private static ControllerGame instance;
    
    private Game gameAtual;
    
    /**
     * Construtor privado, forçando a usar Singleton
     */
    private ControllerGame() {
        this.init();
    }

    public Game getGameAtual() {
        return gameAtual;
    }

    public void setGameAtual(Game gameAtual) {
        this.gameAtual = gameAtual;
    }
    
    /**
     * Get the instance of Singleton
     * @return ControllerGame 
     */
    public static ControllerGame getInstance() {
        if(instance == null) {
            instance = new ControllerGame();        
        }   
        
        return instance;
    }
    
    private void init() {
        
    }

    @Override
    public int getNumeroLinhasTabuleiro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getNumeroColunasTabuleiro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Peca getPecaTabuleiro(int linha, int coluna) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void movimentaPecaTabuleiro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}