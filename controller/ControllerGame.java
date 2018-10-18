package controller;

import java.util.ArrayList;
import model.CasaTabuleiro;
import model.Game;
import model.Jogador;
import model.StrategyTabuleiro;
import view.ObserverGame;

/**
 * Controller principal da aplicação
 * @author Jean Poffo
 * @since 09/08/2018
 */
public class ControllerGame implements InterfaceControllerGame {
    
    private static ControllerGame instance;
    
    private Game game; 
   
    private ArrayList<ObserverGame> observers;
    
    private ControllerGame() {
        this.observers = new ArrayList();
        this.game      = new Game();
    }
  
    public static ControllerGame getInstance() {
        if(instance == null) {
            instance = new ControllerGame();
        }
        return instance;
    }

    protected Game getGame() {
        return game;
    }
    
    @Override
    public void adicionarObserver(ObserverGame observer) {
        this.observers.add(observer);
        
        observer.atualizaEstrategia();
        observer.atualizaJogadorAtacante();
        observer.atualizaJogadorDefensor();
    }

    @Override
    public void removerObserver(ObserverGame observer) {
        this.observers.remove(observer);
    }
    
    @Override
    public int getNumeroLinhasTabuleiro() {
        return this.getGame().getLinhasTabuleiro();
    }

    @Override
    public int getNumeroColunasTabuleiro() {
        return this.getGame().getColunasTabuleiro();
    }

    @Override
    public CasaTabuleiro getCasaTabuleiro(int linha, int coluna) {
        return this.getGame().getTabuleiro()[linha][coluna];
    }

    @Override
    public void movimentaPecaTabuleiro(int linha, int coluna) {
        
    }

    @Override
    public void setEstrategia(StrategyTabuleiro estrategia) {
        this.getGame().setEstrategia(estrategia);
    }

    @Override
    public void setJogadorAtacante(Jogador jogador) {
        this.getGame().setAtacante(jogador);
    }

    @Override
    public void setJogadorDefensor(Jogador jogador) {
        this.getGame().setDefensor(jogador);
    }
}