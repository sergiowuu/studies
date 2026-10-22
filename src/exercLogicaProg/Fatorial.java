package exerclogicaprog;

import java.util.Scanner;

public class Fatorial {
    // 20! = 2.432.902.008.176.640.000 é o maior fatorial que cabe em um long.
    // 21! já ultrapassa Long.MAX_VALUE (~9,22 quintilhões).
    static final int MAXIMO = 20;

    public static void main(String[] args) {
        // try-with-resources para fechar o recurso automaticamente
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Digite o número para calcular o fatorial: ");

            /**
             * se o usuário digitase algo que não fosse um inteiro,
             * nextInt lança InputMismatchException e o programa encerraria com o stach track.
             * O hasNextInt() verifica antes de ler, evitando a exceção.
             */
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida: digite um número inteiro.");
                return;
            }

            int numero = scanner.nextInt();

            /**
             * Não havia validação para número negativo, calcularFatorial(-5) retornava 1
             * por exemplo, e contaria como resultado válido
             */
            if (numero < 0) {
                System.out.println("Não existe fatorial de número negativo.");
                return;
            }

            /**
             * Trocado de int para long, pois fatorial cresce muito rápido, e o int
             * só comporta até 12!, caso fosse calculado um valor maior, o resultado
             * seria incorreto e o Java não avisaria, apenas imprimiria o valor errado.
             * O long aumenta para 20!, para números maiores, seria preciso usar o BigInteger
             */
            if (numero > MAXIMO) {
                System.out.println("O maior número suportado é " + MAXIMO + ".");
                return;
            }

            long resultado = calcularFatorial(numero);

            // usar %d é o formato próprio para inteiros, %s funciona, mas converte para texto
            System.out.printf("O fatorial de %d é %d%n", numero, resultado);
        }
    }

    // passa a retornar um long
    static long calcularFatorial(int numero) {
        if (numero <= 1) {
            return 1;
        }
        return numero * calcularFatorial(numero - 1);
    }
}
