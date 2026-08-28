package poo.finalKeyword;

public class Bilhete {
    private static int totalBilhetes = 0;
    private final int codigo;
    private final String nomeEvento;
    private double preco;

    private static final double taxaServico = 2.00;

    public Bilhete(String nomeEvento) {
        this.codigo = totalBilhetes++;
        this.nomeEvento = nomeEvento;
    }

    // public Bilhete(){} // Falha de compilação devido código ser final

    public String consultarBilhete(){
        return "Código do bilhete: " + codigo + ", Nome do evento: " + nomeEvento + ", Preço: " + preco;
    }

    public String getNomeEvento(){
        return nomeEvento;
    }

    public double getPreco(){
        return preco;
    }

    // O compilador nem deixa criar um setter para codigo, pois ele é final
    // public void setCodigo(int codigo){
    //     this.codigo = codigo;
    // }

    // O mesmo que acontece com setCodigo, acontece aqui
    // public void setTaxaServico(double taxaServico){
    //     this.taxaServico = taxaServico;
    // }

    public void setPreco(double preco){
        if(preco <= 0){
            System.out.println("Preço não pode ser zero ou negativo");
        } else {
            this.preco = preco + taxaServico;
        }
    }

    public static int getTotalBilhetes(){
        return totalBilhetes;
    }
}
