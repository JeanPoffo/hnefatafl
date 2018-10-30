package controller;

import model.CasaTabuleiro;

/**
 * Interface de estratégia para validação das jogadas
 * @author Jean Poffo
 * @since 26/10/2018
 */
public interface StrategyJogada {
    
    public void validaJogada(CasaTabuleiro casaTabuleiroAnterior, CasaTabuleiro casaTabuleiroAtual, CasaTabuleiro[][] tabuleiro) throws Exception ;
}