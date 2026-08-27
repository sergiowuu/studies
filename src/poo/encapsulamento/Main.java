package poo.encapsulamento;

public class Main {
    public static void main(String[] args) {
        CarrinhoCompras carrinho = new CarrinhoCompras();
        carrinho.adicionarProduto(10.0);
        carrinho.adicionarProduto(20.0);
        carrinho.adicionarProduto(30.0);
        carrinho.adicionarProduto(40.0);
        carrinho.adicionarProduto(50.0);
        System.out.println("Total do carrinho: " + carrinho.getTotal());

        carrinho.esvaziarCarrinho();
        System.out.println("Total do carrinho após esvaziar: " + carrinho.getTotal());
    }
}
