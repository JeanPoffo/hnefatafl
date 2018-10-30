package controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de Invoker de Commands
 * @author Jean Poffo
 * @since 26/10/2018
 */
public class Invoker {
    
    private List<Command> imediatos;
    private List<Command> todos;

    public Invoker() {
        this.imediatos = new ArrayList();
        this.todos     = new ArrayList();
    }
    
    public void addCommand(Command command) {
        this.imediatos.add(command);
    }
    
    public void execute() {
        for (Command command : this.imediatos) {
            command.execute();
            this.todos.add(command);
        }
        
        this.imediatos.clear();
    }
    
    public void undo() {
        Command command = this.todos.remove(this.todos.size() - 1);
        command.undo();
        this.imediatos.add(command);
    }
    
    public void redo() {
        Command command = this.imediatos.remove(this.imediatos.size() - 1);
        command.redo();
        todos.add(command);
    }
}