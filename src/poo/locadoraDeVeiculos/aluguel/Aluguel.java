package poo.locadoraDeVeiculos.aluguel;

import java.time.LocalDate;

import poo.locadoraDeVeiculos.cliente.Cliente;
import poo.locadoraDeVeiculos.veiculo.StatusVeiculo;
import poo.locadoraDeVeiculos.veiculo.Veiculo;

public class Aluguel {
    private static final double TAXA_TANQUE_VAZIO = 100;

    private final Cliente cliente;
    private final Veiculo veiculo;
    private final LocalDate dataInicio;
    private final LocalDate dataFim;

    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim){
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        veiculo.alugar(); 
    }

    public double calcularValorTotal(){
        long diasAluguel = dataFim.toEpochDay() - dataInicio.toEpochDay() + 1;
        double valorDiaria = veiculo.calcularValorDiaria();
        double valorTotal = diasAluguel * valorDiaria;

        if(!veiculo.isTanqueCheio()){
            valorTotal += TAXA_TANQUE_VAZIO;
        }

        double desconto = cliente.getTipoCliente().getDescontoPorcentagem();
        valorTotal -= valorTotal * desconto;

        return valorTotal;
    }

    public void devolver(boolean tanqueCheio){
        veiculo.setTanqueCheio(tanqueCheio);
        if(!tanqueCheio){
            veiculo.setStatusVeiculo(StatusVeiculo.EM_MANUTENCAO);
        } else {
            veiculo.setStatusVeiculo(StatusVeiculo.DISPONIVEL);
        }
    }
}