package controller;

import java.util.List;
import model.CasaTabuleiro;

/**
 * Classe de Interface do Decorator que captura peças
 * @author Jean Poffo
 */
public interface InterfaceCapturaPeca {
    
    public List<CasaTabuleiro> getCasasCapturaPeca();
    
    public CasaTabuleiro[][] getTabuleiro();
}