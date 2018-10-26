package model;

/**
 * Estratégia do tabuleiro Hnefatafl
 * @author Jean Poffo
 * @since  12/10/2018
 */
public class StrategyHnefatafl implements StrategyTabuleiro {

    @Override
    public CasaTabuleiro[][] montaTabuleiro(Jogador atacante, Jogador defensor) {
        CasaTabuleiro[][]   tabuleiro   = new CasaTabuleiro[11][11];
        PecaFactoryGenerico pecaFactory = new PecaFactoryGenerico();
        
        for (int linha = 0; linha <= 10; linha++) {
            for (int coluna = 0; coluna <= 10; coluna++) {
                tabuleiro[linha][coluna] = new CasaTabuleiro(false);
            }
        }
        
        Peca peca;
        
        /** Mercenários */
        peca = pecaFactory.createMercenario();
        peca.setId(1);
        peca.setJogador(atacante);
        tabuleiro[0][3].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(2);
        peca.setJogador(atacante);
        tabuleiro[0][4].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(3);
        peca.setJogador(atacante);
        tabuleiro[0][5].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        tabuleiro[0][6].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(5);
        peca.setJogador(atacante);
        tabuleiro[0][7].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(6);
        peca.setJogador(atacante);
        tabuleiro[1][5].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(7);
        peca.setJogador(atacante);
        tabuleiro[3][0].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(8);
        peca.setJogador(atacante);
        tabuleiro[4][0].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(9);
        peca.setJogador(atacante);
        tabuleiro[5][0].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(10);
        peca.setJogador(atacante);
        tabuleiro[6][0].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(11);
        peca.setJogador(atacante);
        tabuleiro[7][0].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(12);
        peca.setJogador(atacante);
        tabuleiro[5][1].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(13);
        peca.setJogador(atacante);
        tabuleiro[3][10].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(14);
        peca.setJogador(atacante);
        tabuleiro[4][10].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(15);
        peca.setJogador(atacante);
        tabuleiro[5][10].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(16);
        peca.setJogador(atacante);
        tabuleiro[6][10].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(17);
        peca.setJogador(atacante);
        tabuleiro[7][10].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(18);
        peca.setJogador(atacante);
        tabuleiro[5][9].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(19);
        peca.setJogador(atacante);
        tabuleiro[10][3].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(20);
        peca.setJogador(atacante);
        tabuleiro[10][4].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(21);
        peca.setJogador(atacante);
        tabuleiro[10][5].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(22);
        peca.setJogador(atacante);
        tabuleiro[10][6].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(23);
        peca.setJogador(atacante);
        tabuleiro[10][7].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(24);
        peca.setJogador(atacante);
        tabuleiro[9][5].setPeca(peca);
        
          /** Defensor */
        peca = pecaFactory.createDefensor();
        peca.setId(25);
        peca.setJogador(defensor);
        tabuleiro[3][5].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(26);
        peca.setJogador(defensor);
        tabuleiro[4][4].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(26);
        peca.setJogador(defensor);
        tabuleiro[4][5].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(24);
        peca.setJogador(defensor);
        tabuleiro[4][6].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(25);
        peca.setJogador(defensor);
        tabuleiro[5][3].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(25);
        peca.setJogador(defensor);
        tabuleiro[5][4].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(25);
        peca.setJogador(defensor);
        tabuleiro[5][6].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(25);
        peca.setJogador(defensor);
        tabuleiro[5][7].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(26);
        peca.setJogador(defensor);
        tabuleiro[6][4].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(26);
        peca.setJogador(defensor);
        tabuleiro[6][5].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(24);
        peca.setJogador(defensor);
        tabuleiro[6][6].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(25);
        peca.setJogador(defensor);
        tabuleiro[7][5].setPeca(peca);
        
        /** Rei */
        peca = pecaFactory.createRei();
        peca.setId(99);
        peca.setJogador(defensor);
        tabuleiro[5][5].setPeca(peca);
        tabuleiro[5][5].setTrono(true);
        
        /** Refúgios */
        tabuleiro[0][0].setRefugio(true);
        tabuleiro[10][0].setRefugio(true);
        tabuleiro[0][10].setRefugio(true);
        tabuleiro[10][10].setRefugio(true);
        
        return tabuleiro;
    }
}