package poo.staticKeyword;

public class Static {
    public static void main(String[] args){
        Pedido pedido1 = new Pedido("Pedido 1");
        Pedido pedido2 = new Pedido("Pedido 2");
        Pedido pedido3 = new Pedido("Pedido 3");

        System.out.println(pedido1.descricaoPedido());
        System.out.println(pedido2.descricaoPedido());
        System.out.println(pedido3.descricaoPedido());
        System.out.println("Total de pedidos: " + Pedido.getTotalPedidos());
    }
}
