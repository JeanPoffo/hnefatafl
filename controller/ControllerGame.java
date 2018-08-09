package controller;

/**
 * The Controller main of Application
 * @author Jean Poffo
 * @since 09/08/2018
 */
public class ControllerGame {
    
    private static ControllerGame instance;

    /**
     * Private builder, forcing to use the Singleton
     */
    private ControllerGame() {
        this.init();
    }
    
    /**
     * Get the instance of Singleton
     * @return ControllerGame 
     */
    public static ControllerGame getInstance() {
        if(instance == null) {
            instance = new ControllerGame();
            
            
        }   
        
        return instance;
    }
    
    private void init() {
        
    }
}