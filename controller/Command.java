package controller;

/**
 * Interface Command
 * @author Jean Poffo
 * @since 26/10/2018
 */
public interface Command {
    
    public void execute();
    
    public void undo();
}