package poo.locadoraveiculos.aluguel;

public class TaxaProporcional implements CalculadoraTaxa{
    private final double percentual;

    public TaxaProporcional (double percentual){
        this.percentual = percentual;
    }

    @Override
    public double calcularTaxa(double aluguel){
        return aluguel * percentual;
    }
}
