package view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;

/**
 * Classe do JTable do Game
 * @author Jean Poffo
 * @since  22/08/2018
 */
public class GameTable extends JTable implements MouseListener{
    
    private GameTableModel tableModel;
    
    public GameTable(GameTableModel tableModel) {
        super.setRowHeight(50);
        super.setDefaultRenderer(Object.class, new GameTableCellRenderer());	
        super.setGridColor(Color.BLACK);
        
        super.addMouseListener(this);
        
        super.setModel(tableModel);
        
        this.tableModel = tableModel;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        this.tableModel.movePeca(this.getSelectedRow(), this.getSelectedColumn());
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}