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
    private List<Command> undo;

    public Invoker() {
        this.imediatos = new ArrayList();
        this.todos     = new ArrayList();
        this.undo      = new ArrayList();
    }
    
    public void addCommand(Command command) {
        this.imediatos.add(command);
    }
    
    public void execute() {
        this.imediatos.stream().map((command) -> {
            command.execute();
            return command;
        }).forEachOrdered((command) -> {
            this.todos.add(command);
        });
        
        this.imediatos.clear();
    }
    
    public boolean undo() {
        if(this.todos.size() > 0) {
            Command command = this.todos.remove(this.todos.size() - 1);
            command.undo();
            this.undo.add(command);
            
            return true;
        }
        
        return false;
    }
    
    public boolean redo() {
        if(this.undo.size() > 0) {
            Command command = this.undo.remove(this.undo.size() - 1);
            command.redo();
            todos.add(command);
            
            return true;
        }
        
        return false;
    }
}