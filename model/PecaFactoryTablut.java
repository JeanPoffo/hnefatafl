package model;

/**
 * Classe de Factory para Peças do Tabuleiro Tablut
 * @author Jean Poffo
 * @since 25/10/2018
 */
public class PecaFactoryTablut extends PecaFactory {

    @Override
    public Mercenario createMercenario() {
        return new MercenarioTablut();
    }

    @Override
    public Defensor createDefensor() {
        return new Defensor();
    }

    @Override
    public Rei createRei() {
        return new Rei();
    }
}