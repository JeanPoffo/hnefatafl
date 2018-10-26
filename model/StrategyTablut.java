package model;

/**
 * Estratégia do tabuleiro Tablut
 * @author Jean Poffo
 * @since 12/10/2018
 */
public class StrategyTablut implements StrategyTabuleiro {
    
    @Override
    public CasaTabuleiro[][] montaTabuleiro(Jogador atacante, Jogador defensor) {
        CasaTabuleiro[][] tabuleiro   = new CasaTabuleiro[9][9];
        PecaFactoryTablut pecaFactory = new PecaFactoryTablut();
        
        for (int linha = 0; linha <= 8; linha++) {
            for (int coluna = 0; coluna <= 8; coluna++) {
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
        tabuleiro[1][4].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        tabuleiro[3][0].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        tabuleiro[3][8].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        tabuleiro[4][0].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        tabuleiro[4][7].setPeca(peca);
        tabuleiro[4][1].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        tabuleiro[4][8].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        tabuleiro[5][0].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        tabuleiro[5][8].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        tabuleiro[8][3].setPeca(peca);
        tabuleiro[7][4].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        tabuleiro[8][4].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        tabuleiro[8][5].setPeca(peca);
        
        /** Defensor */
        peca = pecaFactory.createDefensor();
        peca.setId(5);
        peca.setJogador(defensor);
        tabuleiro[2][4].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(6);
        peca.setJogador(defensor);
        tabuleiro[3][4].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(7);
        peca.setJogador(defensor);
        tabuleiro[4][2].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(8);
        peca.setJogador(defensor);
        tabuleiro[4][3].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(9);
        peca.setJogador(defensor);
        tabuleiro[4][5].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(10);
        peca.setJogador(defensor);
        tabuleiro[4][6].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(5);
        peca.setJogador(defensor);
        tabuleiro[5][4].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(5);
        peca.setJogador(defensor);
        tabuleiro[6][4].setPeca(peca);
        
        /** Rei */
        peca = pecaFactory.createRei();
        peca.setId(99);
        peca.setJogador(defensor);
        tabuleiro[4][4].setPeca(peca);
        tabuleiro[4][4].setTrono(true);
        
        /** Refúgios */
        tabuleiro[0][3].setRefugio(true);
        tabuleiro[0][4].setRefugio(true);
        tabuleiro[0][5].setRefugio(true);
        tabuleiro[1][4].setRefugio(true);
        tabuleiro[3][0].setRefugio(true);
        tabuleiro[3][8].setRefugio(true);
        tabuleiro[4][0].setRefugio(true);
        tabuleiro[4][1].setRefugio(true);
        tabuleiro[4][7].setRefugio(true);
        tabuleiro[4][8].setRefugio(true);
        tabuleiro[5][0].setRefugio(true);
        tabuleiro[5][8].setRefugio(true);
        tabuleiro[7][4].setRefugio(true);
        tabuleiro[8][3].setRefugio(true);
        tabuleiro[8][4].setRefugio(true);
        tabuleiro[8][5].setRefugio(true);
        
        return tabuleiro;
    }
}