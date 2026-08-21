package poo.classesObjetos;

public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro();
        livro1.titulo = "O Senhor dos Anéis";
        livro1.autor = "J.R.R. Tolkien";
        livro1.anoPublicacao = 1954;
        livro1.disponivel = true;

        Livro livro2 = new Livro();
        livro2.titulo = "1984";
        livro2.autor = "George Orwell";
        livro2.anoPublicacao = 1949;
        livro2.disponivel = false;

        System.out.println("Livro 1:");
        System.out.println("Título: " + livro1.titulo);
        System.out.println("Autor: " + livro1.autor);
        System.out.println("Ano de Publicação: " + livro1.anoPublicacao);
        System.out.println("Disponível: " + livro1.disponivel);

        System.out.println("\nLivro 2:");
        System.out.println("Título: " + livro2.titulo);
        System.out.println("Autor: " + livro2.autor);
        System.out.println("Ano de Publicação: " + livro2.anoPublicacao);
        System.out.println("Disponível: " + livro2.disponivel);

    }
}
