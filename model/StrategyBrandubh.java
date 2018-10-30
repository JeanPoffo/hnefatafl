package model;

/**
 * Estratégia do tabuleiro Brandubh
 * @author Jean Poffo
 * @since  12/10/2018
 */
public class StrategyBrandubh implements StrategyTabuleiro {

    @Override
    public CasaTabuleiro[][] montaTabuleiro(Jogador atacante, Jogador defensor) {
        CasaTabuleiro[][]   tabuleiro   = new CasaTabuleiro[7][7];
        PecaFactoryGenerico pecaFactory = new PecaFactoryGenerico();
        
        for (int linha = 0; linha <= 6; linha++) {
            for (int coluna = 0; coluna <= 6; coluna++) {
                CasaTabuleiro casaTabuleiro = new CasaTabuleiro(false);
                casaTabuleiro.setPosicaoX(linha);
                casaTabuleiro.setPosicaoY(coluna);
                
                tabuleiro[linha][coluna] = casaTabuleiro;
            }
        }
        
        Peca peca;
        
        /** Mercenários */
        peca = pecaFactory.createMercenario();
        peca.setId(1);
        peca.setJogador(atacante);
        tabuleiro[3][0].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(2);
        peca.setJogador(atacante);
        tabuleiro[3][1].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(3);
        peca.setJogador(atacante);
        tabuleiro[0][3].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(4);
        peca.setJogador(atacante);
        tabuleiro[1][3].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(5);
        peca.setJogador(atacante);
        tabuleiro[5][3].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(6);
        peca.setJogador(atacante);
        tabuleiro[6][3].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(1);
        peca.setJogador(atacante);
        tabuleiro[3][5].setPeca(peca);
        
        peca = pecaFactory.createMercenario();
        peca.setId(7);
        peca.setJogador(atacante);
        tabuleiro[3][6].setPeca(peca);
        
        /** Defensor */
        peca = pecaFactory.createDefensor();
        peca.setId(8);
        peca.setJogador(defensor);
        tabuleiro[3][2].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(9);
        peca.setJogador(defensor);
        tabuleiro[2][3].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(10);
        peca.setJogador(defensor);
        tabuleiro[4][3].setPeca(peca);
        
        peca = pecaFactory.createDefensor();
        peca.setId(11);
        peca.setJogador(defensor);
        tabuleiro[3][4].setPeca(peca);
        
        /** Rei */
        peca = pecaFactory.createRei();
        peca.setId(99);
        peca.setJogador(defensor);
        tabuleiro[3][3].setPeca(peca);
        tabuleiro[3][3].setTrono(true);
        
        /** Refúgios */
        tabuleiro[0][0].setRefugio(true);
        tabuleiro[6][0].setRefugio(true);
        tabuleiro[0][6].setRefugio(true);
        tabuleiro[6][6].setRefugio(true);
        
        return tabuleiro;
    }
}