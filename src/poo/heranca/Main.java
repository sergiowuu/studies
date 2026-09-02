package poo.heranca;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Wilson", "123", 2000.00);
        System.out.println("Salário do funcionário: " + funcionario.calcularSalario());

        Vendedor vendedor = new Vendedor("Maria", "456", 2500.00, 1000.00);
        System.out.println("Salário do vendedor: " + vendedor.calcularSalario());

        VelhaGuarda velhaGuarda = new VelhaGuarda("João", "789", 3000.00, 5);
        System.out.println("Salário da velha guarda: " + velhaGuarda.calcularSalario());

        Operador operador = new Operador("Ana", "321", 1800.00);
        System.out.println("Salário do operador: " + operador.calcularSalario());
    }
}