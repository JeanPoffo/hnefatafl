package controller;

import model.Peca;

/**
 * Interface do Visitor
 * @author Jean Poffo
 */
public interface Visitor {
    
    public void visit(Peca peca);   
}