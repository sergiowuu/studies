package fundamentos;

public class Array {

    public static String classificarNota(int nota) {
        if (nota >= 7) {
            return "Aprovado";
        } else if (nota >= 5 && nota < 7) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    public static void main(String[] args) {
        int[] notas = {1, 3, 5, 7, 9, 10};

        int aprovados = 0;

        for (int nota : notas) {
            String resultado = classificarNota(nota);

            if (resultado.equals("Aprovado")) {
                aprovados++;
            }
            System.out.println("Nota: " + nota + " - Resultado: " + resultado);
        }
        System.out.println("Número de aprovados: " + aprovados);
    }
}
