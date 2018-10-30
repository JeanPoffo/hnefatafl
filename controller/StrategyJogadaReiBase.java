package controller;

import model.CasaTabuleiro;

/**
 * Classe de estratégia para validar jogadas - Rei
 * @author Jean Poffo
 * @since 29/10/2018
 */
public class StrategyJogadaReiBase extends StrategyJogadaBase {

    @Override
    public void validaJogada(CasaTabuleiro casaTabuleiroAnterior, CasaTabuleiro casaTabuleiroAtual, CasaTabuleiro[][] tabuleiro) throws Exception {
        super.validaJogada(casaTabuleiroAnterior, casaTabuleiroAtual, tabuleiro);
    }
}