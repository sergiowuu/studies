package poo.staticKeyword;

public class Pedido {
    private static int totalPedidos = 0;
    private int idPedido;
    private String descricao;

    public Pedido(String descricao){
        this.descricao = descricao;
        totalPedidos++;
        this.idPedido = totalPedidos;
    }

    public String descricaoPedido() {
        return "ID: " + idPedido + ", Descrição: " + descricao;
    }

    public static int getTotalPedidos() {
        return totalPedidos;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
