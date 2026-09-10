package poo.locadoraDeVeiculos.aluguel;

import java.time.LocalDate;

import poo.locadoraDeVeiculos.cliente.Cliente;
import poo.locadoraDeVeiculos.veiculo.StatusVeiculo;
import poo.locadoraDeVeiculos.veiculo.Veiculo;

public class Aluguel {

    private final Cliente cliente;
    private final Veiculo veiculo;
    private final LocalDate dataInicio;
    private final LocalDate dataFim;
    private boolean tanqueCheioNaDevolucao;
    private final CalculadoraTaxa calculadoraTaxa;

    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim, CalculadoraTaxa calculadoraTaxa){
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.tanqueCheioNaDevolucao = true;
        this.calculadoraTaxa = calculadoraTaxa;
        veiculo.alugar();
    }

    public double calcularValorTotal(){
        long diasAluguel = dataFim.toEpochDay() - dataInicio.toEpochDay() + 1;
        double valorDiaria = veiculo.calcularValorDiaria();
        double valorTotal = diasAluguel * valorDiaria;

        if(!this.tanqueCheioNaDevolucao){ 
            valorTotal += calculadoraTaxa.calcularTaxa(valorTotal);
        }

        double desconto = cliente.getTipoCliente().getDescontoPorcentagem();
        valorTotal -= valorTotal * desconto;

        return valorTotal;
    }

    public void devolver(boolean tanqueCheio){
        this.tanqueCheioNaDevolucao = tanqueCheio; 
        veiculo.setTanqueCheio(tanqueCheio);
        if(!tanqueCheio){
            veiculo.setStatusVeiculo(StatusVeiculo.EM_MANUTENCAO);
        } else {
            veiculo.setStatusVeiculo(StatusVeiculo.DISPONIVEL);
        }
    }
}