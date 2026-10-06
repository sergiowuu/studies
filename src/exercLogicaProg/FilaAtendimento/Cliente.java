package exercLogicaProg.FilaAtendimento;

public class Cliente {
    private String nome;
    private int idade;
    private boolean preferencial;

    public Cliente(String nome, int idade, boolean preferencial){
        this.nome = nome;
        this.idade = idade;
        this.preferencial = preferencial;
    }

    public Categoria getCategoria() {
    if (idade >= 80) return Categoria.PREFERENCIAL_80;
    if (preferencial && idade >= 60) return Categoria.PREFERENCIAL_60;
    if (preferencial) return Categoria.PREFERENCIAL;
    return Categoria.COMUM;
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean getPreferencial() {
        return preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }
}
