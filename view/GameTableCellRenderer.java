package view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.CasaTabuleiro;

/**
 * Classe de renderização de Cell do JTable do Game
 * @author Jean Poffo
 * @since  22/08/2018
 */
public class GameTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object casaAtual, boolean isSelected, boolean hasFocus, int row, int column) {
        CasaTabuleiro casaTabuleiro = (CasaTabuleiro) casaAtual;
        
        if(casaTabuleiro.isRefugio()) {
            super.setBackground(new Color(242, 242, 234));
        }
        else if (casaTabuleiro.isTrono()){
            super.setBackground(new Color(244, 255, 168));
        }
        else {
            super.setBackground(new Color(247, 244, 175));          
        }
        
        if(casaTabuleiro.getPeca() != null) {
            super.setIcon(casaTabuleiro.getPeca().getIcone());
        }
        else {
            super.setIcon(null);
        }
        
        super.setHorizontalAlignment(CENTER);
        super.setVerticalAlignment(CENTER);
        
        super.repaint();
        
        return this;
    }
}