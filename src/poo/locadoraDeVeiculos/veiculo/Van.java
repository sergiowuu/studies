package poo.locadoraDeVeiculos.veiculo;

public class Van extends Veiculo{
    private static final double DIARIA_BASE = 60.0;
    private static final double TAXA_VAN = 0.8;

    public Van(String marca, String modelo, String ano, String placa, boolean tanqueCheio, StatusVeiculo statusVeiculo){
        super(marca, modelo, ano, placa, tanqueCheio, statusVeiculo);
    }

    @Override 
    public double calcularValorDiaria(){
        return DIARIA_BASE * TAXA_LOCADORA * TAXA_VAN;
    }
    
}
