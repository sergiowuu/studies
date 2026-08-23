package poo.modificadoresAcesso;

public class Main {
    public static void main(String[] args) {
        Visitante visitante1 = new Visitante();
        System.out.println(visitante1.criarVisitante("João", "123.456.789-00"));
        System.out.println(visitante1.verificarVisitante());
        System.out.println(visitante1.consultarVisitante());

        Visitante visitante2 = new Visitante();
        System.out.println(visitante2.criarVisitante("Maria", "987.654.321-00"));
        System.out.println(visitante2.consultarVisitante());
        // visitante2.verificado = true; // Aqui não funciona, pois o atributo é privado

    }
}
