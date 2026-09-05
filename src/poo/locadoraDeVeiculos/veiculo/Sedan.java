package poo.locadoraDeVeiculos.veiculo;

public class Sedan extends Veiculo{
    private static final double DIARIA_BASE = 50.0;

    public Sedan(String marca, String modelo, String ano, String placa, boolean tanqueCheio, StatusVeiculo statusVeiculo){
        super(marca, modelo, ano, placa, tanqueCheio, statusVeiculo);
    }

    @Override 
    public double calcularValorDiaria(){
        return DIARIA_BASE * TAXA_LOCADORA;
    }
}
