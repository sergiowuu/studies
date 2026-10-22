package exerclogicaprog;

import java.util.Scanner;

/**
 * Um cofre aceita apenas senhas de 6 dígitos. Dada uma sequência de dígitos, 
 * diga se ela é válida. Para ser válida, ela precisa ter exatamente 6 dígitos, 
 * nenhum deles pode ser repetido em sequência (como "11") e a soma dos dígitos precisa ser par.
 */
public class CofreSenha {
    public static void main(String[] args) {
        // try-with-resources fecha o Scanner automaticamente, dispensando o bloco finally.
        try (Scanner scan = new Scanner(System.in)) {

            /**
             * Alterado de String para int, assim a senha pode ter zeros a esquerda,
             * além disso, ao usar int, numeros negativos passavam na validação
             */
            String senha;

            System.out.print("Digite a senha: ");

            /**
             * Com nextInt, a entrada "123 456" virava 123. Também era lançado
             * InputMismatchException para letras, cujo getMessage() é null.
             */
            senha = scan.nextLine().trim();

            /**
             * Para garantir que todos os caracteres são dígitos e não apenas o tamanho,
             * foi usado uma regex que verifica se a senha contém exatamente 6 dígitos (0-9).
             * Também foi removido as exceções para controle de fluxo, sendo trocadas por um 
             * println, que é mais simples e direto.
             */
            if (!senha.matches("\\d{6}")) {
                System.out.println("Senha inválida: a senha deve conter exatamente 6 dígitos numéricos.");
            } else if (temDigitosIguais(senha)) {
                System.out.println("Senha inválida: a senha não deve conter dígitos iguais em sequência.");
            } else if (somaDigitos(senha) % 2 != 0) {
                System.out.println("Senha inválida: a soma dos dígitos da senha deve ser par.");
            } else {
                System.out.println("Senha aceita.");
            }
        }
    }

    /**
     * Como senha agora é String, recebe uma String direto, sem precisar
     * ficar convertendo de int para String
     */
    static boolean temDigitosIguais(String senha) {
        for (int i = 0; i < senha.length() - 1; i++) {
            if (senha.charAt(i) == senha.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Antes, a soma dos dígitos era feita no while dentro da validação,
     * agora foi separado para um método que recebe a senha e retorna a soma
     */
    static int somaDigitos(String senha) {
        int soma = 0;
        for (int i = 0; i < senha.length(); i++) {
            soma += senha.charAt(i) - '0';
        }
        return soma;
    }
}
