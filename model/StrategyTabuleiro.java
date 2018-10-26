package model;

/**
 * Interface de estratégia para criação dos tabuleiros
 * @author Jean Poffo
 * @since 12/10/2018
 */
public interface StrategyTabuleiro {
    
    /**
     * Cria a matriz do tabuleiro
     * @todo Transformar a criação de casas em um builder
     * @param atacante
     * @param defensor
     * @return Matriz do Tabuleiro
     */
    public CasaTabuleiro[][] montaTabuleiro(Jogador atacante, Jogador defensor);
}