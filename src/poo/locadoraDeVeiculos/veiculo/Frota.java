package poo.locadoraDeVeiculos.veiculo;

import java.util.Optional;

public class Frota {
    private Veiculo[] veiculos;
    private int quantidade; // Quantidade de veiculos cadastrados

    public Frota(int capacidade){
        this.veiculos = new Veiculo[capacidade];
        this.quantidade = 0;
    }

    public void adicionarVeiculo(Veiculo veiculo){
        for (Veiculo v : veiculos){
            if (v != null && v.getPlaca().equals(veiculo.getPlaca())){
                System.out.println("Veículo com a mesma placa já cadastrado.");
                return;
            }
        }
        if (quantidade < veiculos.length){
            veiculos[quantidade] = veiculo;
            quantidade++;
            System.out.println("Veículo adicionado com sucesso.");
        } else {
            System.out.println("Capacidade máxima da frota atingida.");
        }
    }

    // Refatorando para utilizar Optional
    public Optional<Veiculo> buscarPorPlaca(String placa){
        for (Veiculo v : veiculos){
            if (v != null && v.getPlaca().equals(placa)){
                return Optional.of(v);
            }
        }
        return Optional.empty();
    }

    public int contarDisponiveis(){
        int count = 0;
        for (Veiculo v : veiculos){
            if (v != null && v.getStatusVeiculo() == StatusVeiculo.DISPONIVEL){
                count++;
            }
        }
        return count;
    }

    public int contarAlugados(){
        int count = 0;
        for (Veiculo v : veiculos){
            if (v != null && v.getStatusVeiculo() == StatusVeiculo.ALUGADO){
                count++;
            }
        }
        return count;
    }

    public int contarEmManutencao(){
        int count = 0;
        for (Veiculo v : veiculos){
            if (v != null && v.getStatusVeiculo() == StatusVeiculo.EM_MANUTENCAO){
                count++;
            }
        }
        return count;
    }
}