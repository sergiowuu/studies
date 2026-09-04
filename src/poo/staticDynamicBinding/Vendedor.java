package poo.staticDynamicBinding;

public class Vendedor extends Funcionario {
    private double comissao;

    public Vendedor(String nome, String identificador, double salario, double vendasRealizadas) {
        super(nome, identificador, salario);
        this.comissao = vendasRealizadas * 0.1;
    }

    @Override
    public double calcularSalario() {
        return salario + comissao;
    }
    
}
