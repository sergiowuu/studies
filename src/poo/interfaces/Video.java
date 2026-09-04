package poo.interfaces;

public class Video implements Reproducao, Favorito{
    
    private String titulo;
    private String autor;

    public Video(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public void favoritar() {
        System.out.println("O vídeo " + titulo + " feito por " + autor + "foi favoritado!");
    }

    @Override
    public void reproduzir() {
        System.out.println("Reproduzindo vídeo " + titulo + " feito pelo " + autor);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
