package model;

/**
 * Interface de estratégia para criação dos tabuleiros
 * @author Jean Poffo
 * @since 12/10/2018
 */
public interface StrategyTabuleiro {
    
    public CasaTabuleiro[][] montaTabuleiro();
}