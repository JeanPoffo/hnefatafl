package model;

/**
 * Classe abstrata de Factory de Peças
 * @author Jean Poffo
 * @since 25/10/2018
 */
abstract public class PecaFactory {
    
    abstract public Mercenario createMercenario(); 
    
    abstract public Defensor createDefensor(); 
    
    abstract public Rei createRei();
}