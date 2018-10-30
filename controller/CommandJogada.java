package controller;

import model.CasaTabuleiro;

/**
 * Classe Command que executa as jogadas
 * @author Jean Poffo
 * @since 26/10/2018
 */
public class CommandJogada implements Command {

    private CasaTabuleiro casaTabuleiroAnterior;
    
    private CasaTabuleiro casaTabuleiroProxima;

    public CommandJogada(CasaTabuleiro casaTabuleiroAnterior, CasaTabuleiro casaTabuleiroProxima) {
        this.casaTabuleiroAnterior = casaTabuleiroAnterior;
        this.casaTabuleiroProxima  = casaTabuleiroProxima;
    }
    
    @Override
    public void execute() {
        this.casaTabuleiroProxima.setPeca(this.casaTabuleiroAnterior.getPeca());
        this.casaTabuleiroAnterior.setPeca(null);
    }

    @Override
    public void undo() {
        this.casaTabuleiroAnterior.setPeca(this.casaTabuleiroProxima.getPeca());
        this.casaTabuleiroProxima.setPeca(null);
    }

    @Override
    public void redo() {
        this.execute();
    }
}