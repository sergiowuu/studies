public class Condicionais {
    public static void main(String[] args) {
        int idade = 21;
        boolean temIngresso = true;

        if (idade >= 18 && temIngresso) {
            System.out.println("Entrada permitida");
        } else {
            System.out.println("Entrada negada");
        }
    }
}
