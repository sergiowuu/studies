package exerclogicaprog;

/**
 * Dado uma String, deve ser comprimido a sequência de caracteres iguais consecutivos
 * indicando o caractere seguido da quantidade (exemplo: aaabccdddd vira a3b1c2d4).
 * Depois, compare o tamanho da string original com a comprimida e informe se a 
 * compressão valeu a pena e qual foi a porcentagem de redução ou aumento.
 */
public class CompactadorTexto {
    public static void main(String[] args) {
        String[] textos = {
            "aaabccdddd",
            "aabbccdd",
            "abcde",
            "aaaaaaaaaabcd",
            "acbdefghijklmnopqrstuvwxyz",
            // dois cenários que não eram testados
            "",
            null
        };

        for (String texto : textos) {
            /**
             * Validação para null ou vazio que não existia antes. O try/catch genérico
             * escondia a NPE e imprimia uma mensagem do Java para o usuário.
             */
            if (texto == null || texto.isEmpty()) {
                System.out.println("Texto vazio, nada para comprimir.");
                System.out.println();
                continue;
            }

            // variável movida para dentro do for, já que só era usada aqui
            String textoComprimido = comprimir(texto);
            System.out.println("Comprimindo o texto: " + texto + " -> " + textoComprimido);;

            int tamanhoTextoOriginal = texto.length();
            int tamanhoTextoComprimido = textoComprimido.length();

            /**
             * Removido uma das cadeias de if/else, já que as duas faziam basicamente
             * a mesma coisa. Agora há apenas uma cadeia que decide se valeu a pena
             * ou não comprimir, e já imprime a porcentagem.
             */
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
        }
    }

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