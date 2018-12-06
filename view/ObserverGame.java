package view;

/**
 * Classe de Interface Observable (Observador)
 * @author Jean Poffo
 */
public interface ObserverGame {
    
    public void atualizaEstrategiaTabuleiro();
    
    public void atualizaEstrategiaJogada();
    
    public void atualizaEstrategiaJogadaRei();
    
    public void atualizaJogadorAtacante();
    
    public void atualizaJogadorDefensor();
    
    public void atualizaStatus(String status);
    
    public void atualizaStatusShake(String status);
    
    public void atualizaStatusJogador(String status);
    
    public void atualizaStatusDesfazerJogada(boolean ativa);
    
    public void atualizaStatusMensagem(String mensagem);
}