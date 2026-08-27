package poo.encapsulamento;

public class CarrinhoCompras {
    private double[] precos;
    private double total;

    public CarrinhoCompras() {
        esvaziarCarrinho();
    }

    public void adicionarProduto(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo ou zero.");
        }

        for (int i = 0; i < precos.length; i++) {
            if (precos[i] == 0) {
                precos[i] = preco;
                break;
            }
        }
    }

    public void esvaziarCarrinho() {
        this.precos = new double[5];
        this.total = 0;
    }

    public double[] getPrecos() {
        return precos.clone();
    }

    public double getTotal() {
        double soma = 0;
        for (double preco : precos) {
            soma += preco;
        }
        this.total = soma;
        return total;
    }
}
