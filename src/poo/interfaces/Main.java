package poo.interfaces;

public class Main {
    public static void main(String[] args) {

        Reproducao reproduzir = new Video("Me at the zoo", "jawed");
        reproduzir.reproduzir();
        
        Reproducao reproduzir2 = new Musica("Snuff", "Slipknot");
        reproduzir2.reproduzir();

        Reproducao reproduzir3 = new Seriado("The office", "Greg Daniels");
        reproduzir3.reproduzir();

        Favorito favoritar = new Video("Em busca da casa automática", "Viniccius13");
        favoritar.favoritar();

        Favorito favoritar2 = new Musica("Unsainted", "Slipknot");
        favoritar2.favoritar();

        play(new Musica("Duality", "Slipknot"));
        play(new Video("Craft Games", "Davi"));
        play(new Seriado("The Big Bang Theory", "Mark Cendrowski"));
    }

    public static void play(Reproducao item) {
        item.reproduzir();
    }
}
