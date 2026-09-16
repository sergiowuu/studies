package Collections.ArrayList;

public class Main {
    public static void main(String[] args) {
        InscricaoEvento inscricaoEvento = new InscricaoEvento();

        System.out.println(inscricaoEvento.inscreverParticipante("Paulão"));
        System.out.println(inscricaoEvento.inscreverParticipante("Paulão"));
        System.out.println(inscricaoEvento.inscreverParticipante("Julieto"));
        System.out.println(inscricaoEvento.inscreverParticipante("Marcola"));
        System.out.println(inscricaoEvento.inscreverParticipante("Travis"));

        System.out.println(inscricaoEvento.cancelarInscricao("Pedro"));
        System.out.println(inscricaoEvento.cancelarInscricao("Paulão"));

        System.out.println(inscricaoEvento.candidatoInscrito("Paulão"));
        System.out.println(inscricaoEvento.candidatoInscrito("Marcola"));

        inscricaoEvento.listarParticipantes();
    }
}
