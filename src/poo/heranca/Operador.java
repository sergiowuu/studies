package poo.heranca;

public class Operador extends Funcionario{
    public Operador(String nome, String identificador, double salario) {
        super(nome, identificador, salario);
    }

    // Não faz sentido sobrescrever o método CalcularSalario() já que não possui nenhum ajuste
}
