package controller;

import view.ObserverGame;

/**
 * Classe de Interface Observable (Observado)
 * @author Jean Poffo
 * @since  22/08/2018
 */
public interface ObservedGame {
    
    public void adicionarObserver(ObserverGame observer);

    public void removerObserver(ObserverGame observer);    
    
    public void notifyStatus(String status);
    
    public void notifyStatusShake(String status);
    
    public void notifyStatusJogador(String status);
    
    public void notifyStatusDesfazerJogada(boolean ativa);
    
    public void notifyAtualizaStatusMensagem(String status);
}