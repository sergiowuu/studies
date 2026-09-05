package poo.locadoraDeVeiculos.veiculo;

public class Moto extends Veiculo{
    private static final double DIARIA_BASE = 35.0;
    private static final double TAXA_MOTO = 0.6;

    public Moto(String marca, String modelo, String ano, String placa, boolean tanqueCheio, StatusVeiculo statusVeiculo){
        super(marca, modelo, ano, placa, tanqueCheio, statusVeiculo);
    }

    @Override 
    public double calcularValorDiaria(){
        return DIARIA_BASE * TAXA_LOCADORA * TAXA_MOTO;
    }
    
}
