package model;

/**
 * Classe de Factory para Peças Genericas
 * @author Jean Poffo
 * @since 25/10/2018
 */
public class PecaFactoryGenerico extends PecaFactory {

    @Override
    public Mercenario createMercenario() {
        return new Mercenario();
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