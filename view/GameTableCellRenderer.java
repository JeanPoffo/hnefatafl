package view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Classe de renderização de Cell do JTable do Game
 * @author Jean Poffo
 * @since  22/08/2018
 */
public class GameTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.setBackground(new Color(247, 244, 175));
        
        super.repaint();
        
        return this;
    }
}