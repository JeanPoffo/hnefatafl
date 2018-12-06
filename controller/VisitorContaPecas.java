package controller;

import model.Jogador;
import model.Peca;

/**
 * Classe visitor que conta as peças do jogador
 * @author Jean Poffo
 */
public class VisitorContaPecas implements Visitor {

    private int numeroPecas;
    
    private Jogador jogador;

    public VisitorContaPecas(Jogador jogador) {
        this.jogador     = jogador;
        this.numeroPecas = 0;
    }

    @Override
    public void visit(Peca peca) {
        if(peca != null) {
            if(peca.getJogador().equals(this.jogador)) {
                this.numeroPecas++;
            }
        }
    }

    public int getNumeroPecas() {
        return this.numeroPecas;
    }
}