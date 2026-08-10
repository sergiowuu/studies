public class Casting {
    public static void main(String[] args){

        String precoTexto = "99.99";

        double preco = Double.parseDouble(precoTexto);

        double precoComDesconto = preco * 0.9;
        System.out.println("Preço com desconto: " + precoComDesconto);
        System.out.println("Preço original: " + preco);
    }
}
