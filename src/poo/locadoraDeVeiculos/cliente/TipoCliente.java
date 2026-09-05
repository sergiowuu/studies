package poo.locadoraDeVeiculos.cliente;

public enum TipoCliente {
    COMUM(0),
    FIDELIDADE(0.05),
    PREMIUM(0.1);

    private final double descontoPorcentagem;

    TipoCliente(double descontoPorcentagem) {
        this.descontoPorcentagem = descontoPorcentagem;
    }

    public double getDescontoPorcentagem() {
        return descontoPorcentagem;
    }
}
