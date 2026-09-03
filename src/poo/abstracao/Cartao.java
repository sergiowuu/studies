package poo.abstracao;

public class Cartao extends Transacao {
    private String numeroCartao;
    private String titular;
    static final double TAXA_CREDITO = 0.9;

    public Cartao(String identificador, String numeroCartao, String titular, double saldo) {
        super(identificador, saldo);
        this.numeroCartao = numeroCartao;
        this.titular = titular;
    }

    @Override
    public void processarTransacao(double valor, String tipoTransacao, String data) {
        if (!tipoTransacao.equalsIgnoreCase("crédito") && !tipoTransacao.equalsIgnoreCase("débito")) {
            System.out.println("Tipo de transação inválido.");
            return;
        }

        System.out.println("Processando transação de " + tipoTransacao + " para o cartão " + numeroCartao + " do titular " + titular);

        this.data = data;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        if (tipoTransacao.equalsIgnoreCase("crédito")) {
            this.saldo -= valor * TAXA_CREDITO;
        } else {
            this.saldo -= valor;
        }
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Número do Cartão: " + numeroCartao);
        System.out.println("Titular: " + titular);
    }
}
