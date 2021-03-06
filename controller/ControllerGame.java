package controller;

import java.util.ArrayList;
import java.util.List;
import model.CasaTabuleiro;
import model.Game;
import model.Jogador;
import model.StrategyTabuleiro;
import view.ObserverGame;

/**
 * Controller principal da aplicação
 * @author Jean Poffo
 * @since 09/08/2018
 */
public class ControllerGame implements InterfaceControllerGame {
    
    private static ControllerGame instance;
    
    private Game game; 
   
    private ArrayList<ObserverGame> observers;
    
    private CasaTabuleiro casaTabuleiroSelecionada;
    
    private StrategyJogadaBase estrategiaJogada;
    
    private StrategyJogadaReiBase estrategiaJogadaRei;
    
    private Invoker invokerJogada;
    
    private ControllerGame() {
        this.observers     = new ArrayList();
        this.game          = new Game();
        this.invokerJogada = new Invoker();
    }
  
    public static ControllerGame getInstance() {
        if(instance == null) {
            instance = new ControllerGame();
        }
        return instance;
    }

    protected Game getGame() {
        return game;
    }
    
    @Override
    public void adicionarObserver(ObserverGame observer) {
        this.observers.add(observer);
        this.setDadosGame(observer);
    }

    private void setDadosGame(ObserverGame observer) {
        observer.atualizaJogadorDefensor();
        observer.atualizaJogadorAtacante();
        observer.atualizaEstrategiaTabuleiro();
        observer.atualizaEstrategiaJogada();
        observer.atualizaEstrategiaJogadaRei();
        
        this.getGame().alternaJogador();
    }
    
    @Override
    public void removerObserver(ObserverGame observer) {
        this.observers.remove(observer);
    }
    
    private void alternaJogador() {
        this.getGame().alternaJogador();
        this.notifyStatusJogador("Jogada de " + this.getGame().getJogadorAtual().getNome());
    }

    @Override
    public void desfazUltimaJogada() {
        this.invokerJogada.undo();
        this.casaTabuleiroSelecionada = null;
        this.alternaJogador();
        this.notifyStatusDesfazerJogada(false);
    }

    @Override
    public void verificaStatus() {
        String status = ""; 
        
        VisitorContaPecas contaPecasAtacante = new VisitorContaPecas(this.getGame().getAtacante());
        
        for (CasaTabuleiro[] casasTabuleiros : this.getGame().getTabuleiro()) {
            for (CasaTabuleiro casaTabuleiro : casasTabuleiros) {
                casaTabuleiro.accept(contaPecasAtacante);
            }
        }
        status += "Peças do jogador " + this.getGame().getAtacante().getNome() + ": " + contaPecasAtacante.getNumeroPecas() + "\n";
    
        VisitorContaPecas contaPecasDefensor = new VisitorContaPecas(this.getGame().getDefensor());
        
        for (CasaTabuleiro[] casasTabuleiros : this.getGame().getTabuleiro()) {
            for (CasaTabuleiro casaTabuleiro : casasTabuleiros) {
                casaTabuleiro.accept(contaPecasDefensor);
            }
        }
        status += "Peças do jogador " + this.getGame().getDefensor().getNome() + ": " + contaPecasDefensor.getNumeroPecas() + "\n";
        
        this.notifyAtualizaStatusMensagem(status);
    }

    @Override
    public void finalizarGame() {
        notifyAtualizaStatusMensagem("Parabéns! O jogador " + this.getGame().getJogadorAtual().getNome() + " venceu!");
        System.exit(0);
    }
    
    @Override
    public void notifyAtualizaStatusMensagem(String status) {
        this.observers.forEach((observer) -> {
            observer.atualizaStatusMensagem(status);
        });
    }
    
    @Override
    public void notifyStatus(String status) {
        this.observers.forEach((observer) -> {
            observer.atualizaStatus(status);
        });
    }

    @Override
    public void notifyStatusShake(String status) {
        this.observers.forEach((observer) -> {
            observer.atualizaStatusShake(status);
        });
    }

    @Override
    public void notifyStatusJogador(String status) {
        this.observers.forEach((observer) -> {
            observer.atualizaStatusJogador(status);
        });
    }
    
    @Override
    public void notifyStatusDesfazerJogada(boolean ativa) {
        this.observers.forEach((observer) -> {
            observer.atualizaStatusDesfazerJogada(ativa);
        });
    }
    
    @Override
    public int getNumeroLinhasTabuleiro() {
        return this.getGame().getLinhasTabuleiro();
    }

    @Override
    public int getNumeroColunasTabuleiro() {
        return this.getGame().getColunasTabuleiro();
    }

    @Override
    public CasaTabuleiro getCasaTabuleiro(int linha, int coluna) {
        return this.getGame().getTabuleiro()[linha][coluna];
    }

    @Override
    public void movimentaPecaTabuleiro(int linha, int coluna) {
        CasaTabuleiro casaTabuleiroAtual = this.getGame().getTabuleiro()[linha][coluna];
        
        if(this.casaTabuleiroSelecionada == null) {
            try {
                this.validaCasaSelecionadaPossuiPeca(casaTabuleiroAtual);
                this.validaJogadorCasaSelecionada(casaTabuleiroAtual);
                
                this.casaTabuleiroSelecionada = casaTabuleiroAtual;
                
                /** Caso for selecionada uma peça válida limpa o status */
                this.notifyStatus("");
            } 
            catch (Exception e) {
                this.notifyStatus(e.getMessage());
            }
        }
        /** Caso o jogador resolva trocar de peça */
        else if(this.alteraPecaAtual(this.casaTabuleiroSelecionada, casaTabuleiroAtual)) {
            this.casaTabuleiroSelecionada = null;
            this.movimentaPecaTabuleiro(linha, coluna);
        }
        else {
            try {
                /** Isso vai ser removido com um futuro Decorator */
                if(this.casaTabuleiroSelecionada.getPeca().pecaRei()) {
                    this.estrategiaJogadaRei.validaJogada(this.casaTabuleiroSelecionada, casaTabuleiroAtual, this.getGame().getTabuleiro());
                }
                else {
                    this.estrategiaJogada.validaJogada(this.casaTabuleiroSelecionada, casaTabuleiroAtual, this.getGame().getTabuleiro());
                }

                /** Só será permitido desfazer a ultima jogada */
                this.invokerJogada.reset();
                
                if(this.casaTabuleiroSelecionada.getPeca().pecaRei() && casaTabuleiroAtual.isRefugio()) {
                    this.finalizarGame();
                }
                
                /** Adiciona a jogada ao Invoker */
                this.invokerJogada.addCommand(new CommandJogada(this.casaTabuleiroSelecionada, casaTabuleiroAtual));
                this.invokerJogada.execute();
                
                /** Decorator para "comer" as peças */
                InterfaceCapturaPeca capturaPeca = new StrategyCapturaRei(new StrategyCapturaPecaBase(casaTabuleiroAtual, this.getGame().getTabuleiro()));
                List<CasaTabuleiro> casasCapturar = capturaPeca.getCasasCapturaPeca();
                
                casasCapturar.forEach((casaTabuleiro) -> {
                    if(casaTabuleiro.getPeca().pecaRei()) {
                        this.finalizarGame();
                    }
                    
                    /** Adiciona a captura ao Invoker */
                    this.invokerJogada.addCommand(new CommandCapturaPeca(casaTabuleiro));
                });
                    
                /** Executa os comandos */
                this.invokerJogada.execute();
                
                this.casaTabuleiroSelecionada = null;

                this.alternaJogador();
                this.notifyStatusDesfazerJogada(true);
            }
            catch (Exception e) {
                this.notifyStatus(e.getMessage());
            }
        }
    }

    /**
     * Valida se a casa selecionada possui peça
     * @param casaTabuleiro
     * @throws Exception 
     */
    private void validaCasaSelecionadaPossuiPeca(CasaTabuleiro casaTabuleiro) throws Exception {
        if(casaTabuleiro.getPeca() == null) {
            throw new Exception("Selecione uma casa que possua peça!");
        }
    }
    
    /**
     * Valida se oo jogador escolheu uma peça dele
     * @param casaTabuleiro
     * @throws Exception 
     */
    private void validaJogadorCasaSelecionada(CasaTabuleiro casaTabuleiro) throws Exception {
        if(!casaTabuleiro.getPeca().getJogador().equals(this.getGame().getJogadorAtual())) {
            throw new Exception("Selecione somente peças suas!");
        }
    }
    
    /**
     * Verifica se foi selecionada uma peça do mesmo jogador na segunda jogada
     * Sendo assim, ele esta trocando a peça da jogada
     * @param casaTabuleiroAnterior
     * @param casaTabuleiroAtual
     * @return 
     */
    private boolean alteraPecaAtual(CasaTabuleiro casaTabuleiroAnterior, CasaTabuleiro casaTabuleiroAtual) {
        if(casaTabuleiroAtual.getPeca() != null) {
//            if(casaTabuleiroAnterior.getPeca().getJogador() != null && casaTabuleiroAtual.getPeca().getJogador() != null) {
                if(casaTabuleiroAnterior.getPeca().getJogador().equals(casaTabuleiroAtual.getPeca().getJogador())) {
                    return true;
                }
//            }
        }
        
        return false;
    }
    
    @Override
    public void setEstrategiaTabuleiro(StrategyTabuleiro estrategia) {
        this.getGame().setEstrategia(estrategia);
    }

    @Override
    public void setEstrategiaJogada(StrategyJogadaBase estrategia) {
        this.estrategiaJogada = estrategia;
    }

    @Override
    public void setEstrategiaJogadaRei(StrategyJogadaReiBase estrategia) {
        this.estrategiaJogadaRei = estrategia;
    }

    @Override
    public void setJogadorAtacante(Jogador jogador) {
        this.getGame().setAtacante(jogador);
    }

    @Override
    public void setJogadorDefensor(Jogador jogador) {
        this.getGame().setDefensor(jogador);
    }
}