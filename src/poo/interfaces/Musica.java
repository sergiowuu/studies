package poo.interfaces;

public class Musica implements Reproducao, Favorito{

    private String nome;
    private String artista;

    public Musica(String nome, String artista) {
        this.nome = nome;
        this.artista = artista;
    }

    @Override
    public void favoritar() {
        System.out.println("Música: " + nome + " do artista: " + artista + " foi favoritada!");
    }

    @Override
    public void reproduzir() {
        System.out.println("Reproduzindo música: " + nome + " do artista: " + artista);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

}
