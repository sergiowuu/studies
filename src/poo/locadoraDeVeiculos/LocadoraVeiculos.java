package poo.locadoraDeVeiculos;

import java.time.LocalDate;

import poo.locadoraDeVeiculos.aluguel.Aluguel;
import poo.locadoraDeVeiculos.aluguel.TaxaFixa;
import poo.locadoraDeVeiculos.aluguel.TaxaProporcional;
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
        frota.adicionarVeiculo(new Sedan("Toyota", "Corolla", "2022", "ABC1235", true, StatusVeiculo.DISPONIVEL));
        frota.adicionarVeiculo(new Suv("Jeep", "Compass", "2023", "XYZ5678", true, StatusVeiculo.DISPONIVEL));
        frota.adicionarVeiculo(new Van("Fiat", "Ducato", "2020", "QAW0987", false, StatusVeiculo.EM_MANUTENCAO));
        frota.adicionarVeiculo(new Moto("Honda", "CB 300F Twister", "2024", "OVO6790", true, StatusVeiculo.DISPONIVEL));

        System.out.println("Disponíveis: " + frota.contarDisponiveis());
        System.out.println("Alugados: " + frota.contarAlugados());
        System.out.println("Em manutenção: " + frota.contarEmManutencao());

        Cliente cliente = new Cliente("Maria", "Silva", "15/03/1990", "12345678900", TipoCliente.FIDELIDADE);
        Cliente cliente2 = new Cliente("João", "Souza", "22/07/1985", "98765432100", TipoCliente.PREMIUM);
        Cliente cliente3 = new Cliente("Ana", "Costa", "10/12/1995", "45678912300", TipoCliente.COMUM);

        TaxaFixa taxaFixa = new TaxaFixa(100);
        TaxaProporcional taxaProporcional = new TaxaProporcional(0.2);

        // Refatorando para lidar com Optional
        Veiculo veiculo = frota.buscarPorPlaca("ABC1234")
            .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado: ABC1234"));

        Aluguel aluguel = new Aluguel(cliente, veiculo, LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 5), taxaFixa);

        Veiculo veiculo2 = frota.buscarPorPlaca("XYZ5678")
            .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado: XYZ5678"));

        Aluguel aluguel2 = new Aluguel(cliente2, veiculo2, LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 3), taxaProporcional);

        Veiculo veiculo3 = frota.buscarPorPlaca("OVO6790")
            .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado: OVO6790"));
            
        Aluguel aluguel3 = new Aluguel(cliente3, veiculo3, LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 2), taxaFixa);

        Veiculo veiculo4 = frota.buscarPorPlaca("ABC1235")
            .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado: ABC1235"));

        System.out.println("Disponíveis: " + frota.contarDisponiveis());
        System.out.println("Alugados: " + frota.contarAlugados());
        System.out.println("Em manutenção: " + frota.contarEmManutencao());

        aluguel.devolver(true);
        System.out.println("Valor total do aluguel de " + cliente.getNome() + ": R$" + aluguel.calcularValorTotal());
        aluguel2.devolver(false);
        System.out.println("Valor total do aluguel de " + cliente.getNome() + ": R$" + aluguel2.calcularValorTotal());
        aluguel3.devolver(false);
        System.out.println("Valor total do aluguel de " + cliente.getNome() + ": R$" + aluguel3.calcularValorTotal());

        System.out.println("Disponíveis: " + frota.contarDisponiveis());
        System.out.println("Alugados: " + frota.contarAlugados());
        System.out.println("Em manutenção: " + frota.contarEmManutencao());


        Aluguel aluguelTaxaFixa = new Aluguel(cliente, veiculo, LocalDate.of(2026, 9, 10), LocalDate.of(2026, 9, 13), taxaFixa);
        Aluguel aluguelTaxaPropocional = new Aluguel(cliente, veiculo4, LocalDate.of(2026, 9, 10), LocalDate.of(2026, 9, 13), taxaProporcional);

        aluguelTaxaFixa.devolver(false);
        aluguelTaxaPropocional.devolver(false);

        System.out.println("Valor total do aluguel de " + cliente.getNome() + ": R$" + aluguelTaxaFixa.calcularValorTotal());
        System.out.println("Valor total do aluguel de " + cliente.getNome() + ": R$" + aluguelTaxaPropocional.calcularValorTotal());
    }
}
