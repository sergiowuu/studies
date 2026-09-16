package Collections.GenericCollections;

public class Resultado<T> {
    private T valor;
    private boolean sucesso;
    private String mensagemErro;

    private Resultado(T valor, boolean sucesso, String mensagemErro) {
        this.valor = valor;
        this.sucesso = sucesso;
        this.mensagemErro = mensagemErro;
    }

    public static <T> Resultado<T> sucesso(T valor) {
        return new Resultado<>(valor, true, null);
    }

    public static <T> Resultado<T> falha(String mensagemErro) {
        return new Resultado<>(null, false, mensagemErro);
    }

    public boolean foiSucesso() {
        return sucesso;
    }

    public T obterValor() {
        if (!sucesso) {
            throw new IllegalStateException("Não é possível obter valor: operação falhou");
        }
        return valor;
    }

    public String obterErro() {
        if (sucesso) {
            throw new IllegalStateException("Não é possível obter erro: operação teve sucesso");
        }
        return mensagemErro;
    }
}
