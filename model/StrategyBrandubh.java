package model;

/**
 * Estratégia do tabuleiro Brandubh
 * @author Jean Poffo
 * @since  12/10/2018
 */
public class StrategyBrandubh implements StrategyTabuleiro {

    @Override
    public CasaTabuleiro[][] montaTabuleiro() {
        return new CasaTabuleiro[7][7];
    }
}