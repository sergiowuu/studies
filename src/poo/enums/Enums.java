package poo.enums;

public class Enums {
    public static void main(String[] args) {
        Funcionario operador = new Funcionario("Joelma", "123", 2500, TipoFuncionario.OPERADOR);
        operador.setMultiplicador(999);
        System.out.printf("Salario de operador: R$ %s \n", operador.calcularSalario());

        Funcionario vendedor = new Funcionario("Kevin", "234", 5000, TipoFuncionario.VENDEDOR);
        vendedor.setMultiplicador(5);
        System.out.printf("Salario de vendedor: R$ %s \n", vendedor.calcularSalario());

        Funcionario velhaGuarda = new Funcionario("Bruno", "345", 7000, TipoFuncionario.VELHAGUARDA);
        velhaGuarda.setMultiplicador(10.5);
        System.out.printf("Salario da velha guarda: R$ %s ", velhaGuarda.calcularSalario());
    }
}
