package poo.staticDynamicBinding;

public class Funcionario {
    protected String nome;
    protected String identificador;
    protected double salario;

    public Funcionario(String nome, String identificador, double salario) {
        this.nome = nome;
        this.identificador = identificador;
        this.salario = salario;
    }

    public double calcularSalario() {
        return salario;
    }
}
