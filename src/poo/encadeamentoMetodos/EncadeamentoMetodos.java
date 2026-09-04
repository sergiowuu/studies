package poo.encadeamentoMetodos;

public class EncadeamentoMetodos {
    public static void main(String[] args){
        Usuario usuario = new Usuario();
        usuario.setNome("Wilson")
                .setSobrenome("Junior")
                .setEmail("wilsinho@gmail.com")
                .setIdade(21);

        System.out.println(usuario.exibirInformacoes());
    }
}
