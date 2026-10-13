package exercLogicaProg;

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
             * além disso, a validação
             */
            // BUG: ao guardar a senha como int, os zeros à esquerda se perdem:
            // "012345" vira 12345 (5 dígitos) e uma senha válida é recusada.
            // Além disso, números negativos passam: "-12345" tem length 6 em
            // String.valueOf, e o while (numero > 0) nem executa, então a soma
            // fica 0 (par) e a senha "-12345" é ACEITA.
            // A senha é uma sequência de dígitos (texto), não um número.
            String senha;

            System.out.print("Digite a senha: ");

            // BUG: nextInt() lê só o primeiro token ("123 456" vira 123) e lança
            // InputMismatchException para letras, cuja getMessage() é null,
            // imprimindo "Entrada inválida: null". Lendo a linha inteira como
            // String, a validação fica toda sob nosso controle.
            senha = scan.nextLine().trim();
            // try {
            //     senha = scan.nextInt();

            // BUG: com String é preciso garantir que todos os caracteres são
            // dígitos, não só o tamanho. "\\d{6}" = exatamente 6 dígitos (0-9).
            // MELHORIA: usar exceções para controle de fluxo (throw só para cair
            // no catch logo abaixo) é desnecessário; basta imprimir a mensagem.
            // O catch (Exception e) genérico também misturava erros de validação
            // com erros de leitura sob o mesmo rótulo "Entrada inválida".
            if (!senha.matches("\\d{6}")) {
                System.out.println("Senha inválida: a senha deve conter exatamente 6 dígitos numéricos.");
            } else if (temDigitosIguais(senha)) {
                System.out.println("Senha inválida: a senha não deve conter dígitos iguais em sequência.");
            } else if (somaDigitos(senha) % 2 != 0) {
                System.out.println("Senha inválida: a soma dos dígitos da senha deve ser par.");
            } else {
                System.out.println("Senha aceita.");
            }
            //     if (String.valueOf(senha).length() != 6) {
            //         throw new IllegalArgumentException("A senha deve conter 6 dígitos.");
            //     } else if (temDigitosIguais(senha)) {
            //         throw new IllegalArgumentException("A senha não deve conter números iguais sequenciais.");
            //     } else {
            //         // MELHORIA: o cálculo da soma foi extraído para o método
            //         // somaDigitos, assim como já foi feito com temDigitosIguais.
            //         int somaDigitos = 0;
            //         int numero = senha;
            //
            //         while (numero > 0) {
            //             somaDigitos += numero % 10;
            //             numero /= 10;
            //         }
            //
            //         if (somaDigitos % 2 != 0) {
            //             throw new IllegalArgumentException("A soma dos dígitos da senha deve ser par.");
            //         }
            //
            //         System.out.println("Senha aceita.");
            //     }
            // } catch (Exception e) {
            //     System.out.println("Entrada inválida: " + e.getMessage());
            // } finally{
            //     scan.close();
            // }
        }
    }

    // MELHORIA: recebe a String diretamente, sem converter de int de novo
    // (a conversão também perdia zeros à esquerda).
    static boolean temDigitosIguais(String senha) {
        for (int i = 0; i < senha.length() - 1; i++) {
            if (senha.charAt(i) == senha.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
    // static boolean temDigitosIguais(int senha) {
    //     String senhaString = String.valueOf(senha);
    //     for (int i = 0; i < senhaString.length() - 1; i++) {
    //         if (senhaString.charAt(i) == senhaString.charAt(i + 1)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // Como a senha agora é String, cada char é convertido em seu valor numérico:
    // c - '0' transforma '7' (código 55) em 7 (55 - 48).
    static int somaDigitos(String senha) {
        int soma = 0;
        for (int i = 0; i < senha.length(); i++) {
            soma += senha.charAt(i) - '0';
        }
        return soma;
    }
}
