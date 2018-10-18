package view;

import controller.InterfaceControllerGame;
import javax.swing.table.AbstractTableModel;

/**
 * Classe de Modelo do JTable do Game
 * @author Jean Poffo
 * @since 22/08/2018
 */
public class GameTableModel extends AbstractTableModel {

    InterfaceControllerGame controller;

    public GameTableModel(InterfaceControllerGame controller) {
        this.controller = controller;
    }
    
    @Override
    public int getRowCount() {
        return this.controller.getNumeroLinhasTabuleiro();
    }

    @Override
    public int getColumnCount() {
        return this.controller.getNumeroColunasTabuleiro();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        return this.controller.getCasaTabuleiro(linha, coluna);
    }

    public void movePeca(int linha, int coluna) {
        this.controller.movimentaPecaTabuleiro(linha, coluna);
    }
}