package Collections.Maps;

public class Main {
    public static void main(String[] args) {
        Votacao votacao = new Votacao();

        votacao.registrarVoto("Mario");
        votacao.registrarVoto("Mario");
        votacao.registrarVoto("Hebber");
        votacao.registrarVoto("Hebber");
        votacao.registrarVoto("Calvo");
        votacao.registrarVoto("Marcia");

        votacao.exibirResultados();
    }
}
