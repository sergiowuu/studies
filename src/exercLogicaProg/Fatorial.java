package exercLogicaProg;

import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o fatorial desejado: ");
        int fatorial = scanner.nextInt();
        int resultado = calcularFatorial(fatorial);

        System.out.printf("O fatorial de %s é %s", fatorial, resultado);

        scanner.close();
    }

    static int calcularFatorial(int numero){
        if (numero <= 1) {
            return 1;
        }
        return numero * calcularFatorial(numero - 1);
    }
}
