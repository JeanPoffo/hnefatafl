package model;

import javax.swing.ImageIcon;

/**
 * Clase modelo da peça de Defensor
 * @author Jean Poffo
 * @since 17/0/2018
 */
public class Defensor extends Peca {

    @Override
    public ImageIcon getIcone() {
        return new ImageIcon(getClass().getResource("/view/icons/todo.png"));
    }
}