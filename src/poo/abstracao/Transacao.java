package poo.abstracao;

public abstract class Transacao {
    protected String identificador;
    protected double valor;
    protected String tipoTransacao;
    protected String data;
    protected double saldo;

    public Transacao(String identificador, double saldo) {
        this.identificador = identificador;
        this.saldo = saldo;
    }

    public abstract void processarTransacao(double valor, String tipoTransacao, String data);

    public void exibirDetalhes() {
        System.out.println("Identificador: " + identificador);
        System.out.println("Valor: " + valor);
        System.out.println("Tipo de Transação: " + tipoTransacao);
        System.out.println("Saldo: " + saldo);
        System.out.println("Data: " + data);
    }
}
