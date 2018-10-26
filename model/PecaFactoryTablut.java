package model;

/**
 * Classe de Factory para Peças do Tabuleiro Tablut
 * @author Jean Poffo
 * @since 25/10/2018
 */
public class PecaFactoryTablut extends PecaFactory {

    @Override
    public Peca createMercenario() {
        return new MercenarioTablut();
    }

    @Override
    public Peca createDefensor() {
        return new Defensor();
    }

    @Override
    public Peca createRei() {
        return new Rei();
    }
}