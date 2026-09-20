package Collections.Queues;

public class Main {
    public static void main(String[] args) {
        Atendimento atendimento = new Atendimento();

        System.out.println(atendimento.entrarFila("Kleber"));
        System.out.println(atendimento.entrarFila("Rosalia"));
        System.out.println(atendimento.entrarFila("Luigi"));
        System.out.println(atendimento.entrarFila("Espigão"));

        System.out.println(atendimento.atenderCliente());
        System.out.println(atendimento.atenderCliente());
        System.out.println(atendimento.atenderCliente());
        System.out.println(atendimento.atenderCliente());
        System.out.println(atendimento.atenderCliente());
    }
}
