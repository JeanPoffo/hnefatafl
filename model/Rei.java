package model;

import javax.swing.ImageIcon;

/**
 * Clase modelo da peça de Rei
 * @author Jean Poffo
 * @since 17/10/2018
 */
public class Rei extends Peca {

    @Override
    public ImageIcon getIcone() {
        return new ImageIcon(getClass().getResource("/view/icons/todo.png"));
    }
}