package controller;

import model.CasaTabuleiro;

/**
 * Classe de estratégia para validar jogadas várias casas
 * @author Jean Poffo
 * @since 26/10/2018
 */
public class StrategyMultiplaCasa extends StrategyJogadaBase {

    /**
     * Futuramente ao invés de extender a classe base, fazer um decorator
     * para passar para as validações ao invés de usar herança
     * @throws java.lang.Exception
     */
    @Override
    public void validaJogada(CasaTabuleiro casaTabuleiroAnterior, CasaTabuleiro casaTabuleiroAtual, CasaTabuleiro[][] tabuleiro) throws Exception {
        super.validaJogada(casaTabuleiroAnterior, casaTabuleiroAtual, tabuleiro);
        
        this.validaJogadaPecaCaminho(casaTabuleiroAnterior, casaTabuleiroAtual, tabuleiro);
    }
}