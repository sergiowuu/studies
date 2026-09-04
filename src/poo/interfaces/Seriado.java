package poo.interfaces;

public class Seriado implements Reproducao{

    private String nome;
    private String diretor;

    public Seriado(String nome, String diretor) {
        this.nome = nome;
        this.diretor = diretor;
    }

    @Override
    public void reproduzir(){
        System.out.println("Reproduzindo o seriado " + nome + " dirigido por " + diretor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    
}
