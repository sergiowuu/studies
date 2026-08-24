package poo.cicloVidaObjeto;

public class Livro {
    private String titulo;
    private int identificador;
    private boolean disponivelEmprestimo;

    public Livro(String titulo, int identificador) {
        this.titulo = titulo;
        this.identificador = identificador;
        this.disponivelEmprestimo = true;
    }

    public String consultarInformacoes() {
        return "Título: " + this.titulo + ", Identificador: " + this.identificador + ", Disponível para empréstimo: " + this.disponivelEmprestimo;
    }
}
