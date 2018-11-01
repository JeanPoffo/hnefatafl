package view;

import javax.swing.JFrame;

/**
 * Classe Adapter para fazer o efeito Shake da Tela
 * @author Jean Poffo
 * @since 31/10/2018
 */
public class ShakeJFrameAdapter extends shakejframe.ShakeJFrame{
    
    public void shakeJFrame(JFrame jFrame) {
        int tamanhoX = jFrame.getLocation().x;
        int tamanhoY = jFrame.getLocation().y;
        
        if(tamanhoX != 0 && tamanhoY != 0 && jFrame.isVisible()) {
            super.shake(jFrame);
        }
    }
}