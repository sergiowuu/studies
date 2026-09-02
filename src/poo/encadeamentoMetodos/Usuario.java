package poo.encadeamentoMetodos;

public class Usuario {
    private String nome;
    private String sobrenome;
    private String email;
    private int idade;

    public Usuario setNome(String nome){
        this.nome = nome;
        return this;
    }

    public Usuario setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
        return this;
    }

    public Usuario setEmail(String email){
        this.email = email;
        return this;
    }

    public Usuario setIdade(int idade){
        if(idade <= 0){
            System.out.println("Idade não pode ser zero ou negativa");
            return this;
        }
        this.idade = idade;
        return this;
    }

    public String exibirInformacoes(){
        return "Nome: " + this.nome + "\nSobrenome: " + this.sobrenome + "\nEmail: " + this.email + "\nIdade: " + this.idade;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

}
