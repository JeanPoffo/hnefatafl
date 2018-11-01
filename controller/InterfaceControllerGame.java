package controller;

import model.CasaTabuleiro;
import model.Jogador;
import model.StrategyTabuleiro;

/**
 * Interface do Controller do Game
 * @author Jean Poffo
 * @since 09/10/2018
 */
public interface InterfaceControllerGame extends ObservedGame {

    public int getNumeroLinhasTabuleiro();
    
    public int getNumeroColunasTabuleiro();
    
    public CasaTabuleiro getCasaTabuleiro(int linha, int coluna);
    
    public void movimentaPecaTabuleiro(int linha, int coluna);
    
    public void desfazUltimaJogada();
    
    public void setEstrategiaTabuleiro(StrategyTabuleiro estrategia);
    
    public void setEstrategiaJogada(StrategyJogadaBase estrategia);
    
    public void setEstrategiaJogadaRei(StrategyJogadaReiBase estrategia);
    
    public void setJogadorAtacante(Jogador jogador);
    
    public void setJogadorDefensor(Jogador jogador);
}