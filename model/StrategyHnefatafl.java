package model;

/**
 * Estratégia do tabuleiro Hnefatafl
 * @author Jean Poffo
 * @since  12/10/2018
 */
public class StrategyHnefatafl implements StrategyTabuleiro {

    @Override
    public CasaTabuleiro[][] montaTabuleiro() {
        return new CasaTabuleiro[11][11];
    }
}