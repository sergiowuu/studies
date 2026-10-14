package exercLogicaProg;

/**
 * Dado uma String, deve ser comprimido a sequência de caracteres iguais consecutivos
 * indicando o caractere seguido da quantidade (exemplo: aaabccdddd vira a3b1c2d4).
 * Depois, compare o tamanho da string original com a comprimida e informe se a 
 * compressão valeu a pena e qual foi a porcentagem de redução ou aumento.
 */
public class CompactadorTexto {
    public static void main(String[] args) {
        // MELHORIA: incluídos casos de borda ("" e null) para testar entradas que
        // o código original não tratava.
        String[] textos = {
            "aaabccdddd",
            "aabbccdd",
            "abcde",
            "aaaaaaaaaabcd",
            "acbdefghijklmnopqrstuvwxyz",
            "",
            null
        };

        // MELHORIA: a variável só é usada dentro do for, então deve ser declarada lá.
        // Declarada fora, ela "carrega" o valor da volta anterior sem necessidade.
        // String textoComprimido = "";

        for (String texto : textos) {
            // BUG: texto null ou vazio.
            // - null: comprimir(null) lança NullPointerException. O catch genérico
            //   escondia isso e imprimia uma mensagem técnica do Java para o usuário.
            // - "": a porcentagem fazia 0 / 0 em double, o que resulta em NaN
            //   (Not a Number). Só imprimia "Deu na mesma coisa." por sorte, já que
            //   NaN > 0 e NaN < 0 são ambos false e caía no else.
            // Validando antes, não há divisão por zero e o try/catch fica desnecessário.
            if (texto == null || texto.isEmpty()) {
                System.out.println("Texto vazio, nada para comprimir.");
                System.out.println();
                continue;
            }

            String textoComprimido = comprimir(texto);
            System.out.println("Comprimindo o texto: " + texto + " -> " + textoComprimido);
            // System.out.print("Comprimindo o texto: " + texto + " -> ");
            // try {
            //     textoComprimido = comprimir(texto);
            //     System.out.println(textoComprimido);

            int tamanhoTextoOriginal = texto.length();
            int tamanhoTextoComprimido = textoComprimido.length();

            // MELHORIA: havia duas cadeias de if/else decidindo a mesma coisa
            // (uma pelos tamanhos, outra pela porcentagem), e o empate imprimia
            // "Deu na mesma" duas vezes. Uma única cadeia resolve tudo.
            // Também: %d é o formato próprio para inteiros e %n é a quebra de linha
            // independente de sistema operacional (no lugar de \n).
            double porcentagem = ((double) (tamanhoTextoComprimido - tamanhoTextoOriginal) / tamanhoTextoOriginal) * 100.0;

            System.out.printf("Tamanho do texto original: %d / Tamanho do texto comprimido: %d%n",
                    tamanhoTextoOriginal, tamanhoTextoComprimido);

            if (tamanhoTextoComprimido < tamanhoTextoOriginal) {
                System.out.printf("Valeu a pena comprimir. Redução de %.2f%%%n", Math.abs(porcentagem));
            } else if (tamanhoTextoComprimido > tamanhoTextoOriginal) {
                System.out.printf("Não valeu a pena comprimir. Aumento de %.2f%%%n", porcentagem);
            } else {
                System.out.println("Não valeu a pena comprimir. O tamanho ficou igual.");
            }
            System.out.println();

            //     if (tamanhoTextoOriginal < tamanhoTextoComprimido) {
            //         System.out.printf("Não valeu a pena comprimir. Tamanho do texto original: %s / Tamanho do texto comprimido: %s\n", tamanhoTextoOriginal, tamanhoTextoComprimido);
            //     } else if (tamanhoTextoOriginal > tamanhoTextoComprimido) {
            //         System.out.printf("Valeu a pena comprimir. Tamanho do texto original: %s / Tamanho do texto comprimido: %s\n", tamanhoTextoOriginal, tamanhoTextoComprimido);
            //     } else {
            //         System.out.printf("Deu na mesma. Tamanho do texto original: %s / Tamanho do texto comprimido: %s\n", tamanhoTextoOriginal, tamanhoTextoComprimido);
            //     }
            //
            //     double porcentagem = ((double)(tamanhoTextoComprimido - tamanhoTextoOriginal) / tamanhoTextoOriginal) * 100.0;
            //
            //     if (porcentagem > 0) {
            //         System.out.printf("Aumento de %.2f%%\n", porcentagem);
            //     } else if (porcentagem < 0) {
            //         System.out.printf("Redução de: %.2f%%\n", Math.abs(porcentagem));
            //     } else {
            //         System.out.println("Deu na mesma coisa.");
            //     }
            //
            // } catch (Exception e) {
            //     System.out.println("Erro ao tentar comprimir o texto: " + e.getMessage());
            // }
        }
    }

    // Lógica de compressão correta, sem alterações.
    // LIMITAÇÃO: se o texto tiver dígitos, a saída fica ambígua. Ex: "a111"
    // vira "a113", que também poderia ser lido como "a" 113 vezes. Para um
    // compressor real seria preciso um separador ou proibir dígitos na entrada.
    static String comprimir(String texto){
        int caracteresConsecutivos = 1;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < texto.length(); i++){
            if (i + 1 < texto.length() && texto.charAt(i + 1) == texto.charAt(i)) {
                caracteresConsecutivos++;
            } else {
                sb.append(texto.charAt(i)).append(caracteresConsecutivos);
                caracteresConsecutivos = 1;
            }
        }
        return sb.toString();
    }
}
