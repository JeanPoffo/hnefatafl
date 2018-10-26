package model;

/**
 * Classe abstrata de Factory de Peças
 * @author Jean Poffo
 * @since 25/10/2018
 */
abstract public class PecaFactory {
    
    abstract public Peca createMercenario(); 
    
    abstract public Peca createDefensor(); 
    
    abstract public Peca createRei();
}