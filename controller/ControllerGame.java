package controller;

import model.ModelGame;
import model.ModelPeca;

/**
 * Controller principal da aplicação
 * @author Jean Poffo
 * @since 09/08/2018
 */
public class ControllerGame {
    
    private static ControllerGame instance;
    
    private ModelGame jogoAtual;
    
//    private ModelPeca
    
    /**
     * Construtor privado, forçando a usar Singleton
     */
    private ControllerGame() {
        this.init();
    }

    public ModelGame getJogoAtual() {
        return jogoAtual;
    }

    public void setJogoAtual(ModelGame jogoAtual) {
        this.jogoAtual = jogoAtual;
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
}