package poo.enums;

public class Funcionario {
    private String nome;
    private String identificador;
    private double salario;
    private double multiplicador;
    private TipoFuncionario tipoFuncionario;


    public Funcionario(String nome, String identificador, double salario, TipoFuncionario tipoFuncionario) {
        this.nome = nome;
        this.identificador = identificador;
        this.salario = salario;
        this.tipoFuncionario = tipoFuncionario;
    }

    public double calcularSalario(){
        switch (this.tipoFuncionario) {
            case OPERADOR:
                return salario;
            case VENDEDOR:
                double comissao = multiplicador * TipoFuncionario.VENDEDOR.getBonus();
                return salario + comissao;
            case VELHAGUARDA:
                double bonusPorTempoDeServico = multiplicador * TipoFuncionario.VELHAGUARDA.getBonus();
                return salario + bonusPorTempoDeServico;
            default:
                return 0;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setMultiplicador(double multiplicador) {
        if(this.tipoFuncionario == TipoFuncionario.OPERADOR) {
            System.out.println("O tipo funcionario OPERADOR não pode possuir um multiplicador, pois não recebe bonus");
        } else {
            this.multiplicador = multiplicador;
        }
    }
}
