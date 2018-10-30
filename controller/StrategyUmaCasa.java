package controller;

import model.CasaTabuleiro;

/**
 * Classe de estratégia para validar jogadas de uma casa
 * @author Jean Poffo
 * @since 26/10/2018
 */
public class StrategyUmaCasa extends StrategyJogadaBase {

    /**
     * Futuramente ao invés de extender a classe base, fazer um decorator
     * para passar para as validas validações ao invés de usar herança
     * @throws java.lang.Exception
     */
    @Override
    public void validaJogada(CasaTabuleiro casaTabuleiroAnterior, CasaTabuleiro casaTabuleiroAtual, CasaTabuleiro[][] tabuleiro) throws Exception {
        super.validaJogada(casaTabuleiroAnterior, casaTabuleiroAtual, tabuleiro);
        
        this.validaJogadaQuantidadeCasas(casaTabuleiroAnterior, casaTabuleiroAtual, 1);
    }
}