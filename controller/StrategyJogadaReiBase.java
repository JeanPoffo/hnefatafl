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
    
    /**
     *
     * @param casaTabuleiroAtual
     * @param tabuleiro
     * @param numeroCasaMovimentar
     * @return 
     */
    protected boolean validaRaichi(CasaTabuleiro casaTabuleiroAtual, CasaTabuleiro[][] tabuleiro, int numeroCasaMovimentar) {
        int posicaoX = casaTabuleiroAtual.getPosicaoX();
        int posicaoY = casaTabuleiroAtual.getPosicaoY();
        
        int posicaoXIncrementada = casaTabuleiroAtual.getPosicaoX() + numeroCasaMovimentar;
        int posicaoYIncrementada = casaTabuleiroAtual.getPosicaoY() + numeroCasaMovimentar;
        
        for (int i = posicaoX + 1; i < posicaoXIncrementada; i++) {
            try {
                if(tabuleiro[i][posicaoY].getPeca() != null) {
                    break;
                } 
                else if(tabuleiro[i][posicaoY].isRefugio()) {
                    return true;
                }
            } 
            catch (Exception e) {
                break;
            }
        }
        
        for (int i = posicaoX - 1; i < posicaoXIncrementada; i--) {
            try {
                if(tabuleiro[i][posicaoY].getPeca() != null) {
                    break;
                } 
                else if(tabuleiro[i][posicaoY].isRefugio()) {
                    return true;
                }
            } 
            catch (Exception e) {
                break;
            }
        }
        
        for (int i = posicaoY + 1; i < posicaoYIncrementada; i++) {
            try {
                if(tabuleiro[posicaoX][i].getPeca() != null) {
                    break;
                } 
                else if(tabuleiro[posicaoX][i].isRefugio()) {
                    return true;
                }
            } 
            catch (Exception e) {
                break;
            }
        }
        
        for (int i = posicaoY - 1; i < posicaoYIncrementada; i--) {
            try {
                if(tabuleiro[posicaoX][i].getPeca() != null) {
                    break;
                } 
                else if(tabuleiro[posicaoX][i].isRefugio()) {
                    return true;
                }
            } 
            catch (Exception e) {
                break;
            }
        }
        
        return false;
    }
}