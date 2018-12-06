package controller;

import java.util.ArrayList;
import java.util.List;
import model.CasaTabuleiro;

/**
 * Classe que executa o come come de peças
 * @author Jean Poffo
 */
public class StrategyCapturaRei implements InterfaceCapturaPeca {

    private InterfaceCapturaPeca capturaPeca;

    public StrategyCapturaRei(InterfaceCapturaPeca capturaPeca) {
        this.capturaPeca = capturaPeca;
    }
    
    @Override
    public List<CasaTabuleiro> getCasasCapturaPeca() {
        List<CasaTabuleiro> casasParaCapturar = this.capturaPeca.getCasasCapturaPeca();
        List<CasaTabuleiro> casasPecaRemover  = new ArrayList();
        
        casasParaCapturar.stream().filter((casaTabuleiroAtual) -> (casaTabuleiroAtual.getPeca().pecaRei())).forEachOrdered((casaTabuleiroAtual) -> {
            int contaNull         = 0;
            int contaRefugioTrono = 0;
            int contaPecaAliada   = 0;
            
            List<CasaTabuleiro> casas = new ArrayList();
            
            int posicaoX = casaTabuleiroAtual.getPosicaoX();
            int posicaoY = casaTabuleiroAtual.getPosicaoY();
            
            CasaTabuleiro casaTabuleiro1 = null;
            CasaTabuleiro casaTabuleiro2 = null;
            CasaTabuleiro casaTabuleiro3 = null;
            CasaTabuleiro casaTabuleiro4 = null;
            
            try { casaTabuleiro1 = this.getTabuleiro()[posicaoX + 1][posicaoY]; } catch(Exception ex) {}
            try { casaTabuleiro2 = this.getTabuleiro()[posicaoX - 1][posicaoY]; } catch(Exception ex) {}
            try { casaTabuleiro3 = this.getTabuleiro()[posicaoX][posicaoY + 1]; } catch(Exception ex) {}
            try { casaTabuleiro4 = this.getTabuleiro()[posicaoX][posicaoY - 1]; } catch(Exception ex) {}
            
            casas.add(casaTabuleiro1);
            casas.add(casaTabuleiro2);
            casas.add(casaTabuleiro3);
            casas.add(casaTabuleiro4);
            
            for (CasaTabuleiro casaTabuleiro : casas) {
                if(casaTabuleiro == null) {
                    contaNull++;
                }
                else if (casaTabuleiro.isTrono() || casaTabuleiro.isRefugio()) {
                    contaRefugioTrono++;
                }
                else if (casaTabuleiro.getPeca() != null && !casaTabuleiro.getPeca().getJogador().equals(casaTabuleiroAtual.getPeca().getJogador())) {
                    contaPecaAliada++;
                }
            }
            if ((contaNull + contaRefugioTrono + contaPecaAliada) < 4) {
                casasPecaRemover.add(casaTabuleiroAtual);
            }
        });
        
        casasPecaRemover.forEach((casaTabuleiro) -> {
            casasParaCapturar.remove(casaTabuleiro);
        });
        
        return casasParaCapturar;
    }
    
    @Override
    public CasaTabuleiro[][] getTabuleiro() {
        return this.capturaPeca.getTabuleiro();
    }
}