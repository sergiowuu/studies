package Collections.Sets;

public class Main {
    public static void main(String[] args) {
        ControleAcesso controleAcesso = new ControleAcesso();

        System.out.println(controleAcesso.registrarEntrada("123"));
        System.out.println(controleAcesso.registrarEntrada("123"));
        System.out.println(controleAcesso.registrarEntrada("234"));
        System.out.println(controleAcesso.registrarEntrada("456"));
        System.out.println(controleAcesso.registrarEntrada("678"));
        System.out.println(controleAcesso.registrarEntrada("890"));
        
        controleAcesso.listarCpf();

        System.out.println(controleAcesso.totalPessoas());
    }
}
