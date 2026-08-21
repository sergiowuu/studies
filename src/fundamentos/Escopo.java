package fundamentos;

public class Escopo {
    public static void main(String[] args) {

        int numero = 7;

        if (numero % 2 != 0){
            String resultado = "O número é ímpar";
            System.out.println(resultado);
        }
        System.out.println("O número é: " + numero);
    }
}
