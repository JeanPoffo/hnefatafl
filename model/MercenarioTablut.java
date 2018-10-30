package model;

import javax.swing.ImageIcon;

/**
 * Clase modelo da peça de Mercenario (Tabuleiro Tablut)
 * @author Jean Poffo
 * @since 17/10/2018
 */
public class MercenarioTablut extends Peca {

    @Override
    public ImageIcon getIcone() {
        return new ImageIcon(getClass().getResource("/view/icons/mercenario.png"));
    }

    @Override
    public boolean podeMovimentarRefugio() {
        return true;
    }   
}