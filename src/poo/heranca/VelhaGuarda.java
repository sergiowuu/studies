package poo.heranca;

public class VelhaGuarda extends Funcionario {
    static final double BONUS = 500.00;
    private double bonusPorTempoDeServico;

    public VelhaGuarda(String nome, String identificador, double salario, double tempoDeServico) {
        super(nome, identificador, salario);
        this.bonusPorTempoDeServico = tempoDeServico * BONUS;
    }
    
    @Override
    public double calcularSalario() {
        return salario + bonusPorTempoDeServico;
    }
}
