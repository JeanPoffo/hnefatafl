package view;

import controller.ControllerGame;
import controller.InterfaceControllerGame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Jogador;
import model.StrategyBrandubh;
import model.StrategyHnefatafl;
import model.StrategyTablut;

/**
 * Classe de View do Game
 * @author Jean Poffo
 * @since 22/08/2018
 */
public class ViewGame extends JFrame implements ObserverGame {
    
    private JMenuItem itemMenuCarregarJogo;
    private JMenuItem itemMenuNovoJogo;
    private JMenuItem itemMenuSair;
    private JMenuItem itemMenuSalvar;
    private JMenuItem itemMenuSobre;
    private JLabel    labelStatus;
    private JMenu     menuJogo;
    private JMenuBar  menuPrincipal;
    private JMenu     menuSobre;
    private JPanel    panelStatus;
    private GameTable tableGame;
    
    private GameTableModel tableModel;

    private InterfaceControllerGame controller;
    
    public ViewGame(InterfaceControllerGame controller) {
        this.controller = controller;
        
        this.controller.adicionarObserver(this);
        
        super.setTitle("Hnefatafl");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setResizable(false);
        
        this.initComponents();
        
        super.setVisible(true);
    }

    public InterfaceControllerGame getController() {
        return this.controller;
    }
    
    @Override
    public void atualizaEstrategia() {
        String[] opcoes = {"Brandubh", "Hnefatafl", "Tablut"};
        int opcao = JOptionPane.showOptionDialog(this, "Escolha um modo de Jogo:", "Hnefatafl", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        switch(opcao) {
            case 0: this.getController().setEstrategia(new StrategyBrandubh());
                break;
            case 1: this.getController().setEstrategia(new StrategyHnefatafl());
                break;
            case 2: this.getController().setEstrategia(new StrategyTablut());
                break;
        }
    }

    @Override
    public void atualizaJogadorAtacante() {
        String nomeAtacante = JOptionPane.showInputDialog(this, "Digite o nome do atacante:", "Hnefatafl", JOptionPane.QUESTION_MESSAGE);
        
        Jogador jogadorAtacante = new Jogador(1, nomeAtacante);
        
        this.getController().setJogadorAtacante(jogadorAtacante);
    }

    @Override
    public void atualizaJogadorDefensor() {
        String nomeDefensor = JOptionPane.showInputDialog(this, "Digite o nome do defensor:", "Hnefatafl", JOptionPane.QUESTION_MESSAGE);
        
        Jogador jogadorDefensor = new Jogador(2, nomeDefensor);
        
        this.getController().setJogadorDefensor(jogadorDefensor);
    }

    private void initComponents() {
        this.tableModel           = new GameTableModel(ControllerGame.getInstance());
        this.tableGame            = new GameTable(this.tableModel);
        this.panelStatus          = new JPanel();
        this.labelStatus          = new JLabel();
        this.menuPrincipal        = new JMenuBar();
        this.menuJogo             = new JMenu();
        this.itemMenuNovoJogo     = new JMenuItem();
        this.itemMenuSalvar       = new JMenuItem();
        this.itemMenuCarregarJogo = new JMenuItem();
        this.itemMenuSair         = new JMenuItem();
        this.menuSobre            = new JMenu();
        this.itemMenuSobre        = new JMenuItem();

        this.labelStatus.setText("Hello!");

        this.menuJogo.setText("Jogo");

        this.itemMenuNovoJogo.setText("Novo Jogo");
        this.menuJogo.add(this.itemMenuNovoJogo);

        this.itemMenuSalvar.setText("Salvar Jogo");
        this.menuJogo.add(this.itemMenuSalvar);

        this.itemMenuCarregarJogo.setText("Carregar Jogo");
        this.menuJogo.add(this.itemMenuCarregarJogo);

        this.itemMenuSair.setText("Sair");
        this.menuJogo.add(this.itemMenuSair);

        this.menuPrincipal.add(this.menuJogo);

        this.menuSobre.setText("Sobre");

        this.itemMenuSobre.setText("Hnefatafl!");
        this.menuSobre.add(this.itemMenuSobre);

        this.menuPrincipal.add(this.menuSobre);

        setJMenuBar(this.menuPrincipal);

        javax.swing.GroupLayout panelStatusLayout = new javax.swing.GroupLayout(this.panelStatus);
        this.panelStatus.setLayout(panelStatusLayout);
        panelStatusLayout.setHorizontalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.labelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelStatusLayout.setVerticalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.labelStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(this.panelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(this.tableGame, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(this.tableGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(this.panelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
    
    private void addListeners() {
        
    }
}