package controller;

import java.util.ArrayList;
import java.util.List;
import model.CasaTabuleiro;

/**
 * Classe que executa o come come de peças
 * @author Jean Poffo
 */
public class StrategyCapturaPecaBase implements InterfaceCapturaPeca {

    private CasaTabuleiro casaPeca;
    
    private CasaTabuleiro[][] tabuleiro;

    public StrategyCapturaPecaBase(CasaTabuleiro casaPeca, CasaTabuleiro[][] tabuleiro) {
        this.casaPeca  = casaPeca;
        this.tabuleiro = tabuleiro;
    }

    public CasaTabuleiro getCasaPeca() {
        return casaPeca;
    }

    public CasaTabuleiro[][] getTabuleiro() {
        return tabuleiro;
    }
    
    @Override
    public List<CasaTabuleiro> getCasasCapturaPeca() {
        List<CasaTabuleiro> casasParaCapturar = new ArrayList();
        
        int posicaoX = casaPeca.getPosicaoX();
        int posicaoY = casaPeca.getPosicaoY();
        
        CasaTabuleiro casa1;
        CasaTabuleiro casa2;
        CasaTabuleiro casa3;
        CasaTabuleiro casaCaptura;
        
        /** Comendo peças abaixo */
        try {
            casa1 = tabuleiro[posicaoX][posicaoY];
            casa2 = tabuleiro[posicaoX-1][posicaoY];
            casa3 = tabuleiro[posicaoX-2][posicaoY];
            
            casaCaptura = this.getCasaValidaCaptura(casa1, casa2, casa3);
            
            if(casaCaptura != null) {
                casasParaCapturar.add(casaCaptura);
            }
        } 
        catch (Exception e) {}
        
        /** Comendo peças acima */
        try {
            casa1 = tabuleiro[posicaoX][posicaoY];
            casa2 = tabuleiro[posicaoX+1][posicaoY];
            casa3 = tabuleiro[posicaoX+2][posicaoY];
            
            casaCaptura = this.getCasaValidaCaptura(casa1, casa2, casa3);
            
            if(casaCaptura != null) {
                casasParaCapturar.add(casaCaptura);
            }
        } 
        catch (Exception e) {}

        /** Comendo peças a esquerda */
        try{
            casa1 = tabuleiro[posicaoX][posicaoY];
            casa2 = tabuleiro[posicaoX][posicaoY-1];
            casa3 = tabuleiro[posicaoX][posicaoY-2];
            
            casaCaptura = this.getCasaValidaCaptura(casa1, casa2, casa3);
            
            if(casaCaptura != null) {
                casasParaCapturar.add(casaCaptura);
            }
        } 
        catch (Exception e) {}
  
        /** Comendo peças a direita */
        try {
            casa1 = tabuleiro[posicaoX][posicaoY];
            casa2 = tabuleiro[posicaoX][posicaoY+1];
            casa3 = tabuleiro[posicaoX][posicaoY+2];
            
            casaCaptura = this.getCasaValidaCaptura(casa1, casa2, casa3);
            
            if(casaCaptura != null) {
                casasParaCapturar.add(casaCaptura);
            }
        } 
        catch (Exception e) {}
        
        return casasParaCapturar;
    }
    
    private CasaTabuleiro getCasaValidaCaptura(CasaTabuleiro casa1, CasaTabuleiro casa2, CasaTabuleiro casa3) {
        if(casa1.getPeca() != null && casa2.getPeca() != null && casa3.getPeca() != null) {
            /** Se fizer sanduíche com peça aliada */
            if(casa1.getPeca().getJogador().equals(casa3.getPeca().getJogador()) && !casa1.getPeca().getJogador().equals(casa2.getPeca().getJogador())) {
                return casa2;
            }
        }
        else if(casa1.getPeca() != null && casa2.getPeca() != null) {
            /** Se formar sanduíche com trono ou refúgio */
            if ((casa3.isRefugio() || casa3.isTrono()) && !casa1.getPeca().getJogador().equals(casa2.getPeca().getJogador())) {
                return casa2;
            }
            else if(casa2.getPeca().pecaRei()) {
                return casa2;
            }
        }
        return null;
    }
}