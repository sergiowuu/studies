package poo.modificadoresAcesso;

public class Visitante {
    private String nome;
    private String cpf;
    private boolean verificado = false;

    public String criarVisitante(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        return "Visitante criado com sucesso!";
    }

    public String consultarVisitante() {
        return "Nome: " + this.nome + ", CPF: " + this.cpf + ", Verificado: " + this.verificado;
    }

    public String verificarVisitante() {
        this.verificado = true;
        return "Visitante verificado com sucesso!";
    }
}
