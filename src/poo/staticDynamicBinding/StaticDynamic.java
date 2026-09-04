package poo.staticDynamicBinding;

// Código de herança reutilizado para o tópico de Static e Dynamic Binding

public class StaticDynamic {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Wilson", "123", 2000.00);
        System.out.println("Salário do funcionário: " + funcionario.calcularSalario());

        Vendedor vendedor = new Vendedor("Maria", "456", 2500.00, 1000.00);
        System.out.println("Salário do vendedor: " + vendedor.calcularSalario());

        VelhaGuarda velhaGuarda = new VelhaGuarda("João", "789", 3000.00, 5);
        System.out.println("Salário da velha guarda: " + velhaGuarda.calcularSalario());

        Operador operador = new Operador("Ana", "321", 1800.00);
        System.out.println("Salário do operador: " + operador.calcularSalario());
    
        System.out.println("--------------------------");
        System.out.println("Static e Dynamic Binding");
        System.out.println("--------------------------");

        Funcionario f;

        f = new Vendedor("kleber", "999", 2500, 3000);
        System.out.println(f.calcularSalario());
        f = new VelhaGuarda("Marquinhos", "27", 5000, 15);
        System.out.println(f.calcularSalario());

        /**
         * O cenário acima acontece pois `f` é declarado como tipo `Funcionario`,
         * mas o objeto em memória criado pelo `new` é do tipo `Vendedor` no
         * primeiro caso e `VelhaGuarda` no segundo. Como o método `calcularSalario()`
         * não é static, final ou private, o Java não consegue identificar qual versão
         * do método executar apenas "olhando" o código, ele precisa ter conhecimento
         * do objeto em memória da variável `f` para saber qual versão de fato executar.
         */
    }
}