package poo.finalKeyword;

public class Main {
    public static void main(String[] args){
        Bilhete bilhete1 = new Bilhete("Evento 1");
        Bilhete bilhete2 = new Bilhete("Evento 2");
        Bilhete bilhete3 = new Bilhete("Evento 3");
    
        bilhete1.setPreco(1);
        bilhete2.setPreco(2);
        bilhete3.setPreco(3);

        System.out.println(bilhete1.consultarBilhete());
        System.out.println(bilhete2.consultarBilhete());
        System.out.println(bilhete3.consultarBilhete());

        System.out.println("Total de bilhetes: " + Bilhete.getTotalBilhetes());

        // Se por acaso houvesse um método para setar um novo valor, ele falharia
        // bilhete1.setCodigo(1);

        // Outro exemplo de falha ao tentar setar um valor em um atributo final
        // bilhete1.setTaxaServico(1000000.00);
    }
}
