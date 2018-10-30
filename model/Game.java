package model;

/**
 * Classe Modelo de Game
 * @author Jean Poffo
 * @since 20/08/2018
 */
public class Game {
    
    private Jogador atacante;
    
    private Jogador defensor;
    
    private Jogador jogadorAtual;
    
    private StrategyTabuleiro estrategia;
    
    private CasaTabuleiro[][] tabuleiro;

    public Game() {}
    
    public Jogador getAtacante() {
        return atacante;
    }

    public void setAtacante(Jogador atacante) {
        this.atacante = atacante;
    }

    public Jogador getDefensor() {
        return defensor;
    }

    public void setDefensor(Jogador defensor) {
        this.defensor = defensor;
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }
    
    public void alternaJogador() {
        if(this.jogadorAtual == null) {
            this.jogadorAtual = this.defensor;
        }
        else if (this.jogadorAtual.equals(this.atacante)){
            this.jogadorAtual = this.defensor;
        }
        else {
            this.jogadorAtual = this.atacante;
        }
    }
    
    public StrategyTabuleiro getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(StrategyTabuleiro estrategia) {
        this.estrategia = estrategia;
        this.tabuleiro  = estrategia.montaTabuleiro(this.getAtacante(), this.getDefensor());
    }

    public CasaTabuleiro[][] getTabuleiro() {
        return tabuleiro;
    }
    
    public int getLinhasTabuleiro() {
        return this.tabuleiro.length;
    }
    
    public int getColunasTabuleiro() {
        return this.tabuleiro[0].length;
    }
}