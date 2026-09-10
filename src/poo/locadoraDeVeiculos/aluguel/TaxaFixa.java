package poo.locadoraDeVeiculos.aluguel;

public class TaxaFixa implements CalculadoraTaxa{
    private final double taxaFixa;
    
    public TaxaFixa(double taxaFixa) {
        this.taxaFixa = taxaFixa;
    }

    @Override
    public double calcularTaxa(double aluguel){
        return taxaFixa;
    }
}
