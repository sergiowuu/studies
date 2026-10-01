package exercLogicaProg;

/**
 * Um estacionamento só aceita placas em uma formato específico: 3 letras
 * maiúsculas, um hífen e 4 dígitos
 * (exemplo: ABC-1234). Além do formato, a soma dos 4 dígitos deve ser maior do
 * que 10 e as 3 letras forem
 * diferentes entre si. Dada a placa, verifique se ela é aceita ou recusada, em
 * caso de recusada, informe
 * o motivo (formato inválido, soma baixa ou letras repetidas).
 */
public class PlacaEstacionamento {
    public static void main(String[] args) {
        String[] placas = {
                "ABC-1234",
                "AAB-1234",
                "ABC-0001",
                "ABC",
                "abc-9999",
                "CD-0011",
                "XVZ-8972"
        };

        for (String placa : placas) {
            System.out.print(placa + " -> ");
            try {
                if (verificarFormato(placa) && verificarLetrasDiferentes(placa) && verificarSomaDigitos(placa)) {
                    System.out.println("Placa válida");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static boolean verificarFormato(String placa) {

        // Verifica se tem 8 caracteres
        if (placa.length() != 8) {
            throw new IllegalArgumentException("Recusado: não tem exatos 8 caracteres");
        }

        // Verifica se os 3 primeiros são letras e maiúsculas
        for (int i = 0; i < 3; i++) {
            char caractere = placa.charAt(i);
            if (!Character.isUpperCase(caractere)) {
                throw new IllegalArgumentException(
                        "Recusado: os três primeiros caracteres devem ser letras e maiúsculas");
            }
        }

        // Vefifica se a posição [3] é um hífen
        if (placa.charAt(3) != '-') {
            throw new IllegalArgumentException("Recusado: deve ter um hífen na quarta posição");
        }

        // Verifica se da posição 4 a 7, é um dígito
        for (int i = 4; i < 8; i++) {
            char caractere = placa.charAt(i);

            if (!Character.isDigit(caractere)) {
                throw new IllegalArgumentException("Recusado: os ultimos quatro caracteres devem ser dígitos");
            }
        }
        return true;
    }

    static boolean verificarLetrasDiferentes(String placa) {
        char letra1 = placa.charAt(0);
        char letra2 = placa.charAt(1);
        char letra3 = placa.charAt(2);

        if (letra1 == letra2 || letra1 == letra3 || letra2 == letra3) {
            throw new IllegalArgumentException("Recusado: as letras devem ser diferentes entre si");
        }

        return true;
    }

    static boolean verificarSomaDigitos(String placa) {
        int soma = 0;

        for (int i = 4; i < 8; i++) {
            char caractere = placa.charAt(i);

            int digito = Character.getNumericValue(caractere);

            soma += digito;
        }

        if (soma <= 10) {
            throw new IllegalArgumentException("Recusado: a soma dos dígitos deve ser maior do que 10");
        }

        return true;
    }
}