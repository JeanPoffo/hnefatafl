package controller;

import model.CasaTabuleiro;

/**
 * Classe de estratégia para validar jogadas - Base
 * @author Jean Poffo
 * @since 29/10/2018
 */
public class StrategyJogadaBase implements StrategyJogada {
    
    /**
     * Validação base de Jogadas
     * @param casaTabuleiroAnterior
     * @param casaTabuleiroAtual
     * @param tabuleiro
     * @throws Exception
     */
    @Override
    public void validaJogada(CasaTabuleiro casaTabuleiroAnterior, CasaTabuleiro casaTabuleiroAtual, CasaTabuleiro[][] tabuleiro) throws Exception  {
        this.validaJogadaDiagonal(casaTabuleiroAnterior, casaTabuleiroAtual);
        this.validaJogadaCasaDestinoPossuiPeca(casaTabuleiroAtual);
        this.validaJogadaRefugio(casaTabuleiroAnterior, casaTabuleiroAtual);
        this.validaJogadaTrono(casaTabuleiroAnterior, casaTabuleiroAtual);
    }
    
    /**
     * Se o eixo X e Y se alteraram, é uma jogada diagonal, não permitida
     * @param casaTabuleiroAnterior
     * @param casaTabuleiroAtual
     * @throws Exception 
     */
    protected void validaJogadaDiagonal(CasaTabuleiro casaTabuleiroAnterior, CasaTabuleiro casaTabuleiroAtual) throws Exception{
        if(casaTabuleiroAnterior.getPosicaoX() != casaTabuleiroAtual.getPosicaoX()) {
            if(casaTabuleiroAnterior.getPosicaoY() != casaTabuleiroAtual.getPosicaoY()) {
                throw new Exception("Não é permitida jogadas na diagonal!");
            }
        }
    }
    
    /**
     * Se a casa que foi movimentada ja possui peça, não é permitida a jogada
     * @param casaTabuleiroAtual
     * @throws Exception 
     */
    protected void validaJogadaCasaDestinoPossuiPeca(CasaTabuleiro casaTabuleiroAtual) throws Exception {
        if(casaTabuleiroAtual.getPeca() != null) {
            throw new Exception("A peça só pode ser movimentada para casas vazias!");
        }
    }
    
    /**
     * Valida se a peça pode entrar no Refúgio
     * @param casaTabuleiroAnterior
     * @param casaTabuleiroAtual
     * @throws Exception 
     */
    protected void validaJogadaRefugio(CasaTabuleiro casaTabuleiroAnterior, CasaTabuleiro casaTabuleiroAtual) throws Exception {
        if(casaTabuleiroAtual.isRefugio()) {
            if(!casaTabuleiroAnterior.getPeca().podeMovimentarRefugio()) {
                throw new Exception("Esta peça não pode entrar no refugio!");   
            }
        }
    }
    
    /**
     * Valida se a peça pode entrar no Trono
     * @param casaTabuleiroAnterior
     * @param casaTabuleiroAtual
     * @throws Exception 
     */
    protected void validaJogadaTrono(CasaTabuleiro casaTabuleiroAnterior, CasaTabuleiro casaTabuleiroAtual) throws Exception {
        if(casaTabuleiroAtual.isTrono()) {
            if(!casaTabuleiroAnterior.getPeca().podeMovimentarTrono()) {
                throw new Exception("Esta peça não pode entrar no Trono!");   
            }
        }
    }
    
    /**
     * Valida se possui peças no caminho que a peça vai trilhar
     * @param casaTabuleiroAnterior
     * @param casaTabuleiroAtual
     * @param tabuleiro
     * @throws Exception 
     */
    protected void validaJogadaPecaCaminho(CasaTabuleiro casaTabuleiroAnterior, CasaTabuleiro casaTabuleiroAtual, CasaTabuleiro[][] tabuleiro) throws Exception {
        int movimentacaoEixoX = casaTabuleiroAtual.getPosicaoX() - casaTabuleiroAnterior.getPosicaoX();
        int movimentacaoEixoY = casaTabuleiroAtual.getPosicaoY() - casaTabuleiroAnterior.getPosicaoY();
        
        if(movimentacaoEixoX > 0) {
            for (int i = casaTabuleiroAnterior.getPosicaoX() + 1; i < casaTabuleiroAtual.getPosicaoX(); i++) {
                if(tabuleiro[i][casaTabuleiroAnterior.getPosicaoY()].getPeca() != null) {
                    throw new Exception("Não é possível saltar sobre outras peças!");
                } 
            }
        } 
        else if(movimentacaoEixoX < 0) {
            for (int i = casaTabuleiroAnterior.getPosicaoX() - 1; i > casaTabuleiroAtual.getPosicaoX(); i--) {
                if(tabuleiro[i][casaTabuleiroAnterior.getPosicaoY()].getPeca() != null) {
                    throw new Exception("Não é possível saltar sobre outras peças!");
                } 
            }
        }
        
        if(movimentacaoEixoY > 0) {
            for (int i = casaTabuleiroAnterior.getPosicaoY() + 1; i < casaTabuleiroAtual.getPosicaoY(); i++) {
                if(tabuleiro[casaTabuleiroAnterior.getPosicaoX()][i].getPeca() != null) {
                    throw new Exception("Não é possível saltar sobre outras peças!");
                } 
            }
        }
        else if(movimentacaoEixoY < 0) {
            for (int i = casaTabuleiroAnterior.getPosicaoY() - 1; i > casaTabuleiroAtual.getPosicaoY(); i--) {
                if(tabuleiro[casaTabuleiroAnterior.getPosicaoX()][i].getPeca() != null) {
                    throw new Exception("Não é possível saltar sobre outras peças!");
                } 
            }
        }
    }
    
    /**
     * Função genérica para validar a quantidade de casas movimentadas
     * @param casaTabuleiroAnterior
     * @param casaTabuleiroAtual
     * @param quantidadeCasas
     * @throws Exception 
     */
    protected void validaJogadaQuantidadeCasas(CasaTabuleiro casaTabuleiroAnterior, CasaTabuleiro casaTabuleiroAtual, int quantidadeCasas) throws Exception {
        int movimentacaoEixoX = casaTabuleiroAnterior.getPosicaoX() - casaTabuleiroAtual.getPosicaoX();
        int movimentacaoEixoY = casaTabuleiroAnterior.getPosicaoY() - casaTabuleiroAtual.getPosicaoY();
        
        if(movimentacaoEixoX > quantidadeCasas || movimentacaoEixoX < (quantidadeCasas * -1)) {
            throw new Exception("Só é permitido movimentar " + quantidadeCasas + " casa(s)!");
        }
        
        if(movimentacaoEixoY > quantidadeCasas || movimentacaoEixoY < (quantidadeCasas * -1)) {
            throw new Exception("Só é permitido movimentar " + quantidadeCasas + " casa(s)!");
        }
    }
}