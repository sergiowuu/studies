package poo.cicloVidaObjeto;

public class LifeCycle {
    public static void main(String[] args) {
        Livro livro1 = new Livro("O Senhor dos Anéis", 1);
        System.out.println(livro1.consultarInformacoes());

        // Não compila, pois não tem um construtor que receba apenas o título
        // Livro livro2 = new Livro("Harry Potter");
    }
}
