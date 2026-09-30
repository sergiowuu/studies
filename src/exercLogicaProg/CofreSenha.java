package exercLogicaProg;

import java.util.Scanner;

/**
 * Um cofre aceita apenas senhas de 6 dígitos. Dada uma sequência de dígitos, 
 * diga se ela é válida. Para ser válida, ela precisa ter exatamente 6 dígitos, 
 * nenhum deles pode ser repetido em sequência (como "11") e a soma dos dígitos precisa ser par.
 */
public class CofreSenha {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int senha;

        System.out.print("Digite a senha: ");
        try {
            senha = scan.nextInt();

            if (String.valueOf(senha).length() != 6) {
                throw new IllegalArgumentException("A senha deve conter 6 dígitos.");
            } else if (temDigitosIguais(senha)) {
                throw new IllegalArgumentException("A senha não deve conter números iguais sequenciais.");
            } else {
                int somaDigitos = 0;
                int numero = senha;

                while (numero > 0) {
                    somaDigitos += numero % 10;
                    numero /= 10;
                }

                if (somaDigitos % 2 != 0) {
                    throw new IllegalArgumentException("A soma dos dígitos da senha deve ser par.");
                }

                System.out.println("Senha aceita.");
            }
        } catch (Exception e) {
            System.out.println("Entrada inválida: " + e.getMessage());
        } finally{
            scan.close();
        }
    }

    static boolean temDigitosIguais(int senha) {
        String senhaString = String.valueOf(senha);
        for (int i = 0; i < senhaString.length() - 1; i++) {
            if (senhaString.charAt(i) == senhaString.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}
