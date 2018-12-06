package controller;

import model.CasaTabuleiro;
import model.Peca;

/**
 * Classe command que executa a captura de peca
 * @author Jean Poffo
 */
public class CommandCapturaPeca implements Command {

    private CasaTabuleiro casaTabuleiro;
    
    private Peca peca;

    public CommandCapturaPeca(CasaTabuleiro casa) {
        this.casaTabuleiro = casa;
        this.peca = casa.getPeca();
    }
    
    @Override
    public void execute() {
        this.casaTabuleiro.setPeca(null);
    }

    @Override
    public void undo() {
        this.casaTabuleiro.setPeca(this.peca);
    }
}