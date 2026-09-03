package poo.abstracao;

public class Boleto extends Transacao {
    private String codigoBarras;
    private String dataVencimento;
    static final double TAXA_POR_ATRASO = 0.05;

    public Boleto(String identificador, double saldo, String codigoBarras, String dataVencimento) {
        super(identificador, saldo);
        this.codigoBarras = codigoBarras;
        this.dataVencimento = dataVencimento;
    }
    
    @Override
    public void processarTransacao(double valor, String tipoTransacao, String data) {
        int dataTransacao = Integer.parseInt(data.replace("-", ""));
        int dataVenc = Integer.parseInt(dataVencimento.replace("-", ""));
        int diasAtraso = dataTransacao - dataVenc;

        double multa = 0;
        if (dataTransacao > dataVenc) {
            System.out.println("Processando transação de boleto ATRASADO com código de barras " + codigoBarras);
            multa = diasAtraso * TAXA_POR_ATRASO;
        } else {
            System.out.println("Processando transação de boleto com código de barras " + codigoBarras);
        }

        this.data = data;
        this.valor = valor;
        this.tipoTransacao = "boleto";
        this.saldo -= valor + multa;
    }
}
