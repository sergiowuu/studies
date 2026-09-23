package Collections.Deques;

public class Main {
    public static void main(String[] args) {
        ActionHistory acao = new ActionHistory();

        acao.registrarAcao("Andar");
        acao.registrarAcao("Nadar");
        acao.registrarAcao("Caminhar");
        acao.registrarAcao("Escrever");

        System.out.println(acao.desfazerUltimaAcao());
        System.out.println(acao.inspecionarMaisAntiga());
    }
}
