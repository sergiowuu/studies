package poo.sobrecarga;

public class Main {
    public static void main(String[] args){
        Frete frete1 = new Frete("Santos", "Sergio", "Mario", false);

        frete1.calcularFrete(0); // Erro
        frete1.calcularFrete(10);
        System.out.println("Frete apenas com peso: " + frete1.informacoesFrete()); // Valor = 15

        frete1.calcularFrete(10, 11);
        System.out.println("Frete com peso e distancia: " + frete1.informacoesFrete()); // Valor = 25

        frete1.calcularFrete(10, 10, 10);
        System.out.println("Frete com peso, distancia e quantidade: " + frete1.informacoesFrete()); // Valor = 30

        Frete frete2 = new Frete("São Paulo", "Donald", "Wilson", true);

        frete2.calcularFrete(5);
        System.out.println("Frete apenas com peso: " + frete2.informacoesFrete()); // Valor = 10

        frete2.calcularFrete(10, -1); // Erro
        frete2.calcularFrete(3, 4);
        System.out.println("Frete com peso e distância: " + frete2.informacoesFrete()); // 13.200...

        frete2.calcularFrete(10, 10, 10);
        System.out.println("Frete com peso, distancia e quantidade: " + frete2.informacoesFrete()); // Valor = 24

    }
}
