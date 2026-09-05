package poo.locadoraDeVeiculos;

import java.time.LocalDate;

import poo.locadoraDeVeiculos.aluguel.Aluguel;
import poo.locadoraDeVeiculos.cliente.Cliente;
import poo.locadoraDeVeiculos.cliente.TipoCliente;
import poo.locadoraDeVeiculos.veiculo.Frota;
import poo.locadoraDeVeiculos.veiculo.Moto;
import poo.locadoraDeVeiculos.veiculo.Sedan;
import poo.locadoraDeVeiculos.veiculo.StatusVeiculo;
import poo.locadoraDeVeiculos.veiculo.Suv;
import poo.locadoraDeVeiculos.veiculo.Van;
import poo.locadoraDeVeiculos.veiculo.Veiculo;

public class LocadoraVeiculos {
    public static void main(String[] args) {
        Frota frota = new Frota(10);
        frota.adicionarVeiculo(new Sedan("Toyota", "Corolla", "2022", "ABC1234", true, StatusVeiculo.DISPONIVEL));
        frota.adicionarVeiculo(new Suv("Jeep", "Compass", "2023", "XYZ5678", true, StatusVeiculo.DISPONIVEL));
        frota.adicionarVeiculo(new Van("Fiat", "Ducato", "2020", "QAW0987", false, StatusVeiculo.EM_MANUTENCAO));
        frota.adicionarVeiculo(new Moto("Honda", "CB 300F Twister", "2024", "OVO6790", true, StatusVeiculo.DISPONIVEL));

        System.out.println("Disponíveis: " + frota.contarDisponiveis());
        System.out.println("Alugados: " + frota.contarAlugados());
        System.out.println("Em manutenção: " + frota.contarEmManutencao());

        Cliente cliente = new Cliente("Maria", "Silva", "15/03/1990", "12345678900", TipoCliente.FIDELIDADE);
        Cliente cliente2 = new Cliente("João", "Souza", "22/07/1985", "98765432100", TipoCliente.PREMIUM);
        Cliente cliente3 = new Cliente("Ana", "Costa", "10/12/1995", "45678912300", TipoCliente.COMUM);

        Veiculo veiculo = frota.buscarPorPlaca("ABC1234");
        Aluguel aluguel = new Aluguel(cliente, veiculo, LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 5));
        Aluguel aluguel2 = new Aluguel(cliente2, frota.buscarPorPlaca("XYZ5678"), LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 3));
        Aluguel aluguel3 = new Aluguel(cliente3, frota.buscarPorPlaca("OVO6790"), LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 2));

        System.out.println("Disponíveis: " + frota.contarDisponiveis());
        System.out.println("Alugados: " + frota.contarAlugados());
        System.out.println("Em manutenção: " + frota.contarEmManutencao());

        aluguel.devolver(false);
        System.out.println("Valor total do aluguel de " + cliente.getNome() + ": R$" + aluguel.calcularValorTotal());
        aluguel2.devolver(true);
        System.out.println("Valor total do aluguel de " + cliente.getNome() + ": R$" + aluguel2.calcularValorTotal());
        aluguel3.devolver(false);
        System.out.println("Valor total do aluguel de " + cliente.getNome() + ": R$" + aluguel3.calcularValorTotal());

        System.out.println("Disponíveis: " + frota.contarDisponiveis());
        System.out.println("Alugados: " + frota.contarAlugados());
        System.out.println("Em manutenção: " + frota.contarEmManutencao());
    }
}
