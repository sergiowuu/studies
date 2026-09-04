package poo.packages;

import poo.heranca.Funcionario;
import poo.interfaces.Musica;

public class Packages {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("Jorge", "6767", 10000);
        System.out.println(f.calcularSalario());

        Musica m = new Musica("Dead Memories", "Slipknot");
        m.reproduzir();
    }
}
