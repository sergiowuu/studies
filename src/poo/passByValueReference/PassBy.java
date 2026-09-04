package poo.passByValueReference;

public class PassBy {
    public static void main(String[] args){
        Relatorio relatorio = new Relatorio();

        relatorio.setNome("Relatorio 1");
        relatorio.setSaldo(10);
        System.out.println("Saldo inicial: " + relatorio.getSaldo());

        zerarSaldo(relatorio);
        System.out.println("Saldo após zerar a primeira vez: " + relatorio.getSaldo());

        relatorio.setSaldo(20);
        System.out.println("Setando outro valor para saldd: " + relatorio.getSaldo());

        zerarSaldoErrado(relatorio);
        System.out.println("Saldo após zerar errado: " + relatorio.getSaldo());
    }

    static void zerarSaldo(Relatorio relatorio){
        relatorio.setSaldo(0);
    }

    static void zerarSaldoErrado(Relatorio relatorio){
        relatorio = new Relatorio();
        relatorio.setSaldo(0);
    }
}
