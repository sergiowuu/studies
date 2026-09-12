package poo.locadoraDeVeiculos.aluguel;

import java.io.FileWriter;
import java.io.IOException;
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

    public void salvarRegistro(String caminhoArquivo){
        try (FileWriter writer = new FileWriter(caminhoArquivo, true)){
            String conteudo = String.format(
                "Nome: %s %s, CPF: %s\nVeículo alugado: %s %s %s %s\nValor total do aluguel: R$ %s\n\n", 
                this.cliente.getNome(), 
                this.cliente.getSobrenome(),
                this.cliente.getCpf(),
                this.veiculo.getMarca(),
                this.veiculo.getModelo(),
                this.veiculo.getAno(),
                this.veiculo.getPlaca(),
                calcularValorTotal()
            );
            writer.write(conteudo);
        } catch (IOException e) {
            System.out.printf("Erro ao escrever no arquivo: %s \n", e.getMessage());
        }
    }
}