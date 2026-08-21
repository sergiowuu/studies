package fundamentos;
public class OperadoresMatematicos{
    public static void main(String[] args){
        int a = 10;
        int b = 5;

        int soma = a + b;
        int subtracao = a - b;
        int multiplicacao = a * b;
        double divisao = (double) a / b;
        int resto = a % b;

        System.out.println("Soma: " + soma);
        System.out.println("Subtração: " + subtracao);
        System.out.println("Multiplicação: " + multiplicacao);
        System.out.println("Divisão: " + divisao);
        System.out.println("Resto da divisão: " + resto);
    }
}