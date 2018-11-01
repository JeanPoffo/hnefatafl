package view;

import controller.ControllerGame;
import controller.InterfaceControllerGame;
import controller.StrategyMultiplaCasa;
import controller.StrategyReiMultiplaCasa;
import controller.StrategyReiQuatroCasas;
import controller.StrategyReiUmaCasa;
import controller.StrategyUmaCasa;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    private JLabel    labelJogador;
    private JButton   botaoDesfazerJogada;
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
        
        this.initComponents();
        
        this.addListeners();
        
        super.setTitle("Hnefatafl");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setIconImage(new ImageIcon(getClass().getResource("/view/icons/game.png")).getImage());
        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    public InterfaceControllerGame getController() {
        return this.controller;
    }

    @Override
    public void atualizaJogadorAtacante() {
        String nomeAtacante = JOptionPane.showInputDialog(this, "Digite o nome do atacante:", "Hnefatafl", JOptionPane.QUESTION_MESSAGE);
        
        if(nomeAtacante == null || nomeAtacante.equals("")) {
            JOptionPane.showMessageDialog(this, "Por favor informe um nome", "Hnefatafl", JOptionPane.WARNING_MESSAGE);
            this.atualizaJogadorAtacante();
        }
        else {
            Jogador jogadorAtacante = new Jogador(1, nomeAtacante);
        
            this.getController().setJogadorAtacante(jogadorAtacante);
        }
    }

    @Override
    public void atualizaJogadorDefensor() {
        String nomeDefensor = JOptionPane.showInputDialog(this, "Digite o nome do defensor:", "Hnefatafl", JOptionPane.QUESTION_MESSAGE);
        
        if(nomeDefensor == null || nomeDefensor.equals("")) {
            JOptionPane.showMessageDialog(this, "Por favor informe um nome", "Hnefatafl", JOptionPane.WARNING_MESSAGE);
            this.atualizaJogadorDefensor();
        }
        else {
            Jogador jogadorDefensor = new Jogador(2, nomeDefensor);
        
            this.getController().setJogadorDefensor(jogadorDefensor);
        }
    }

    @Override
    public void atualizaEstrategiaTabuleiro() {
        String[] opcoes = {"Brandubh", "Hnefatafl", "Tablut"};
        int opcao = JOptionPane.showOptionDialog(this, "Escolha um modo de Jogo:", "Hnefatafl", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        switch(opcao) {
            case 0: this.getController().setEstrategiaTabuleiro(new StrategyBrandubh());
                break;
            case 1: this.getController().setEstrategiaTabuleiro(new StrategyHnefatafl());
                break;
            case 2: this.getController().setEstrategiaTabuleiro(new StrategyTablut());
                break;
            default: 
                JOptionPane.showMessageDialog(this, "Por favor informe uma opção", "Hnefatafl", JOptionPane.WARNING_MESSAGE);
                this.atualizaEstrategiaTabuleiro();
        }
    }

    @Override
    public void atualizaEstrategiaJogada() {
        String[] opcoes = {"Uma Casa", "Várias Casas"};
        int opcao = JOptionPane.showOptionDialog(this, "Escolha quantas casas a peça poderá se movimentar:", "Hnefatafl", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        switch(opcao) {
            case 0: this.getController().setEstrategiaJogada(new StrategyUmaCasa());
                break;
            case 1: this.getController().setEstrategiaJogada(new StrategyMultiplaCasa());
                break;
            default: 
                JOptionPane.showMessageDialog(this, "Por favor informe uma opção", "Hnefatafl", JOptionPane.WARNING_MESSAGE);
                this.atualizaEstrategiaJogada();
        }
    }
    
    @Override
    public void atualizaEstrategiaJogadaRei() {
        String[] opcoes = {"Uma Casa", "Quatro Casas", "Várias Casas"};
        int opcao = JOptionPane.showOptionDialog(this, "Escolha quantas casas o Rei poderá se movimentar:", "Hnefatafl", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
        
        switch(opcao) {
            case 0: this.getController().setEstrategiaJogadaRei(new StrategyReiUmaCasa());
                break;
            case 1: this.getController().setEstrategiaJogadaRei(new StrategyReiQuatroCasas());
                break;
            case 2: this.getController().setEstrategiaJogadaRei(new StrategyReiMultiplaCasa());
                break;
            default: 
                JOptionPane.showMessageDialog(this, "Por favor informe uma opção", "Hnefatafl", JOptionPane.WARNING_MESSAGE);
                this.atualizaEstrategiaJogadaRei();
        }
    }
    
    @Override
    public void atualizaStatus(String status) {
       this.labelStatus.setText(status);
    }

    @Override
    public void atualizaStatusShake(String status) {
        this.labelStatus.setText(status);
        
        ShakeJFrameAdapter shakeJFrame = new ShakeJFrameAdapter();
        shakeJFrame.shake(this);
    }
    
    @Override
    public void atualizaStatusJogador(String status) {
        this.labelJogador.setText(status);
    }
    
    private void initComponents() {
        this.tableModel           = new GameTableModel(ControllerGame.getInstance());
        this.tableGame            = new GameTable(this.tableModel);
        this.panelStatus          = new JPanel();
        this.labelStatus          = new JLabel();
        this.labelJogador         = new JLabel();
        this.botaoDesfazerJogada  = new JButton();
        this.menuPrincipal        = new JMenuBar();
        this.menuJogo             = new JMenu();
        this.itemMenuNovoJogo     = new JMenuItem();
        this.itemMenuSalvar       = new JMenuItem();
        this.itemMenuCarregarJogo = new JMenuItem();
        this.itemMenuSair         = new JMenuItem();
        this.menuSobre            = new JMenu();
        this.itemMenuSobre        = new JMenuItem();

        this.labelStatus.setText("Olá! O jogo começa do lado dos defensores do rei!");
        
        this.labelJogador.setText("Defensores");

        this.botaoDesfazerJogada.setText("Desfazer Jogada");
        this.botaoDesfazerJogada.setIcon(new ImageIcon(getClass().getResource("/view/icons/desfazer.png")));
        
        this.menuJogo.setText("Jogo");

        this.itemMenuNovoJogo.setText("Novo Jogo");
        this.itemMenuNovoJogo.setIcon(new ImageIcon(getClass().getResource("/view/icons/novo.png")));
        this.menuJogo.add(this.itemMenuNovoJogo);

        this.itemMenuSalvar.setText("Salvar Jogo");
        this.itemMenuSalvar.setIcon(new ImageIcon(getClass().getResource("/view/icons/salvar.png")));
        this.menuJogo.add(this.itemMenuSalvar);

        this.itemMenuCarregarJogo.setText("Carregar Jogo");
        this.itemMenuCarregarJogo.setIcon(new ImageIcon(getClass().getResource("/view/icons/carregar.png")));
        this.menuJogo.add(this.itemMenuCarregarJogo);

        this.itemMenuSair.setText("Sair");
        this.itemMenuSair.setIcon(new ImageIcon(getClass().getResource("/view/icons/sair.png")));
        this.menuJogo.add(this.itemMenuSair);

        this.menuPrincipal.add(this.menuJogo);

        this.menuSobre.setText("Sobre");

        this.itemMenuSobre.setText("Hnefatafl!");
        this.itemMenuSobre.setIcon(new ImageIcon(getClass().getResource("/view/icons/sobre.png")));
        this.menuSobre.add(this.itemMenuSobre);

        this.menuPrincipal.add(this.menuSobre);

        super.setJMenuBar(this.menuPrincipal);

        javax.swing.GroupLayout panelStatusLayout = new javax.swing.GroupLayout(panelStatus);
        panelStatus.setLayout(panelStatusLayout);
        panelStatusLayout.setHorizontalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoDesfazerJogada)
                .addContainerGap())
        );
        panelStatusLayout.setVerticalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelStatus)
                    .addComponent(botaoDesfazerJogada)
                    .addComponent(labelJogador))
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
        this.itemMenuNovoJogo.addActionListener((e) -> {
            JOptionPane.showMessageDialog(this, "Futura implementação");
        });
        
        this.itemMenuSalvar.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Futura implementação");
        });
        
        this.itemMenuCarregarJogo.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Futura implementação");
        });
        
        this.itemMenuSair.addActionListener((e) -> {
            System.exit(0);
        });   
        
        this.itemMenuSobre.addActionListener((e) -> {
            JOptionPane.showMessageDialog(this, "Desenvolvido por Jean Poffo", "Hnefatafl", JOptionPane.INFORMATION_MESSAGE);
        });
        
        this.botaoDesfazerJogada.addActionListener((e) -> {
            this.controller.desfazUltimaJogada();
            
            /** @todo Melhorar isso aqui */
            this.tableModel.fireTableDataChanged();
        });
    }
}