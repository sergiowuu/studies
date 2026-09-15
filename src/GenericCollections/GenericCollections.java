package GenericCollections;

public class GenericCollections {
    public static void main(String[] args) {
        Resultado<Integer> divisao1 = dividir(10, 2);
        exibirResultado(divisao1);

        Resultado<Integer> divisao2 = dividir(10, 0);
        exibirResultado(divisao2);

        Resultado<String> nome1 = validarNomeUsuario("sergio");
        exibirResultado(nome1);

        Resultado<String> nome2 = validarNomeUsuario("ab");
        exibirResultado(nome2);
    }

    private static Resultado<Integer> dividir(int a, int b) {
        if (b == 0) {
            return Resultado.falha("Divisão por zero não permitida");
        }
        return Resultado.sucesso(a / b);
    }

    private static Resultado<String> validarNomeUsuario(String nome) {
        if (nome == null || nome.length() < 3) {
            return Resultado.falha("Nome de usuário inválido: mínimo de 3 caracteres");
        }
        return Resultado.sucesso(nome);
    }

    private static <T> void exibirResultado(Resultado<T> resultado) {
        if (resultado.foiSucesso()) {
            System.out.println("Sucesso: " + resultado.obterValor());
        } else {
            System.out.println("Erro: " + resultado.obterErro());
        }
    }
}
