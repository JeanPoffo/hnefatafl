package model;

/**
 * Classe de Casa do Tabuleiro
 * @author Jean Poffo
 * @since  14/10/2018
 */
public class CasaTabuleiro {
    
    private boolean refugio;
    
    private boolean trono;
    
    private Peca peca;

    public CasaTabuleiro(boolean refugio) {
        this.refugio = refugio;
    }

    public boolean isTrono() {
        return trono;
    }

    public void setTrono(boolean trono) {
        this.trono = trono;
    }
    
    public boolean isRefugio() {
        return refugio;
    }

    public void setRefugio(boolean refugio) {
        this.refugio = refugio;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
}