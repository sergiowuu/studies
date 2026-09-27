package Collections.Stacks;

public class Main {
    public static void main(String[] args) {
        String[] expressoes = {
            "(a+(b*c))",
            "((a+b))",
            "a+b",
            "(a)",
            "((()))",
            "(a+b)*(c-d)",
            "a+b)*c(",
            ")",
            "a)b",
            "(a+(b*c)",
            "((a+b)",
            "(",
            "(a+b))(c",
            "())(",
            "",
            "abc",
            "(",
            ")"
        };

        for(String expressao : expressoes){
            Validador validador = new Validador();
            System.out.println("\"" + expressao + "\" -> " + validador.ehBalanceado(expressao));
        }
    }
}
