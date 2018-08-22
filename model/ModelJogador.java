package model;

/**
 * Classe Modelo de Jogador
 * @author Jean Poffo
 * @since 20/08/2018
 */
public class ModelJogador {
    
    private int codigo;
    
    private String nome;

    public ModelJogador() {}
    
    public ModelJogador(int codigo, String nome) {
        this.codigo = codigo;
        this.nome   = nome;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}