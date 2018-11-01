package model;

/**
 * Clase modelo da peça de Mercenario (Tabuleiro Tablut)
 * @author Jean Poffo
 * @since 17/10/2018
 */
public class MercenarioTablut extends Mercenario {

    @Override
    public boolean podeMovimentarRefugio() {
        return true;
    }
}