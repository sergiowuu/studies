package poo.locadoraDeVeiculos.veiculo;

public abstract class Veiculo {
    private String marca;
    private String modelo;
    private String ano;
    private final String placa;
    private boolean tanqueCheio;
    private StatusVeiculo statusVeiculo;
    protected  static final double TAXA_LOCADORA = 1.05;

    public Veiculo (String marca, String modelo, String ano, String placa, boolean tanqueCheio, StatusVeiculo statusVeiculo) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.tanqueCheio = tanqueCheio;
        this.statusVeiculo = statusVeiculo;
    }

    public String alugar(){
        if(this.statusVeiculo != StatusVeiculo.DISPONIVEL){
            throw new IllegalArgumentException("O veículo está em " + this.statusVeiculo + " por isso não pode ser alugado. Tente novamente quando o veículo estiver disponível.");
        } else if (!this.tanqueCheio){
            throw new IllegalArgumentException("O veículo deve estar com tanque cheio para que possa estar como disponível.");
        }

        this.statusVeiculo = StatusVeiculo.ALUGADO;
        return "Veiculo da placa " + this.placa + " alugado com sucesso.";
    }

    public abstract double calcularValorDiaria();

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public boolean isTanqueCheio() {
        return tanqueCheio;
    }

    public void setTanqueCheio(boolean tanqueCheio) {
        this.tanqueCheio = tanqueCheio;
    }

    public StatusVeiculo getStatusVeiculo() {
        return statusVeiculo;
    }

    public void setStatusVeiculo(StatusVeiculo statusVeiculo) {
        this.statusVeiculo = statusVeiculo;
    }
}
