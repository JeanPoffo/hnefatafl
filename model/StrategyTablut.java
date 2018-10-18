package model;

/**
 * Estratégia do tabuleiro Tablut
 * @author Jean Poffo
 * @since 12/10/2018
 */
public class StrategyTablut implements StrategyTabuleiro {

    @Override
    public CasaTabuleiro[][] montaTabuleiro() {
        return new CasaTabuleiro[9][9];
    }
}