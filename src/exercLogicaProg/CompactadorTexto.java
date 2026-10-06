package exercLogicaProg;

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
            "acbdefghijklmnopqrstuvwxyz"
        };

        String textoComprimido = "";

        for (String texto : textos) {
            System.out.print("Comprimindo o texto: " + texto + " -> ");
            try {
                textoComprimido = comprimir(texto);
                System.out.println(textoComprimido);

                int tamanhoTextoOriginal = texto.length();
                int tamanhoTextoComprimido = textoComprimido.length();

                if (tamanhoTextoOriginal < tamanhoTextoComprimido) {
                    System.out.printf("Não valeu a pena comprimir. Tamanho do texto original: %s / Tamanho do texto comprimido: %s\n", tamanhoTextoOriginal, tamanhoTextoComprimido);
                } else if (tamanhoTextoOriginal > tamanhoTextoComprimido) {
                    System.out.printf("Valeu a pena comprimir. Tamanho do texto original: %s / Tamanho do texto comprimido: %s\n", tamanhoTextoOriginal, tamanhoTextoComprimido);
                } else {
                    System.out.printf("Deu na mesma. Tamanho do texto original: %s / Tamanho do texto comprimido: %s\n", tamanhoTextoOriginal, tamanhoTextoComprimido);
                }

                double porcentagem = ((double)(tamanhoTextoComprimido - tamanhoTextoOriginal) / tamanhoTextoOriginal) * 100.0;

                if (porcentagem > 0) {
                    System.out.printf("Aumento de %.2f%%\n", porcentagem);
                } else if (porcentagem < 0) {
                    System.out.printf("Redução de: %.2f%%\n", Math.abs(porcentagem));
                } else { 
                    System.out.println("Deu na mesma coisa.");
                }

            } catch (Exception e) {
                System.out.println("Erro ao tentar comprimir o texto: " + e.getMessage());
            }
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