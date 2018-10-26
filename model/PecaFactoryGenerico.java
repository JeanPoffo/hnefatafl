package model;

/**
 * Classe de Factory para Peças Genericas
 * @author Jean Poffo
 * @since 25/10/2018
 */
public class PecaFactoryGenerico extends PecaFactory {

    @Override
    public Peca createMercenario() {
        return new Mercenario();
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