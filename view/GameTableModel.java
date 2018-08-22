package view;

import controller.ControllerGame;
import javax.swing.table.AbstractTableModel;

/**
 * Classe de Modelo do JTable do Game
 * @author Jean Poffo
 * @since 22/08/2018
 */
public class GameTableModel extends AbstractTableModel {

    ControllerGame controller;

    public GameTableModel(ControllerGame controller) {
        this.controller = controller;
    }
    
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("@todo");
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("@todo");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("@todo");
    }
}