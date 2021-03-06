package controller;

import model.CasaTabuleiro;

/**
 * Classe de estratégia para validar jogadas do Rei - Uma casa
 * @author Jean Poffo
 * @since 29/10/2018
 */
public class StrategyReiUmaCasa extends StrategyJogadaReiBase {

    /**
     * Futuramente ao invés de extender a classe base, fazer um decorator
     * para passar para as validas validações ao invés de usar herança
     * @param casaTabuleiroAnterior
     * @param casaTabuleiroAtual
     * @throws Exception 
     */
    @Override
    public void validaJogada(CasaTabuleiro casaTabuleiroAnterior, CasaTabuleiro casaTabuleiroAtual, CasaTabuleiro[][] tabuleiro) throws Exception {
        super.validaJogada(casaTabuleiroAnterior, casaTabuleiroAtual, tabuleiro);
        
        this.validaJogadaQuantidadeCasas(casaTabuleiroAnterior, casaTabuleiroAtual, 1);
        
        if(this.validaRaichi(casaTabuleiroAtual, tabuleiro, 1)) {
            ControllerGame.getInstance().notifyStatusShake("Raichi!");
        }
    }
}