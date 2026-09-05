package poo.locadoraDeVeiculos.veiculo;

public class Suv extends Veiculo{
    private static final double DIARIA_BASE = 75.0;
    private static final double TAXA_SUV = 1.1;

    public Suv(String marca, String modelo, String ano, String placa, boolean tanqueCheio, StatusVeiculo statusVeiculo){
        super(marca, modelo, ano, placa, tanqueCheio, statusVeiculo);
    }

    @Override 
    public double calcularValorDiaria(){
        return DIARIA_BASE * TAXA_LOCADORA * TAXA_SUV;
    }
    
}
