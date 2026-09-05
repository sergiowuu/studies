package poo.records;

public class Record {
    public static void main(String[] args) {
        Coordenada coordenada1 = new Coordenada(10,90);
        Coordenada coordenada2 = new Coordenada(-90,25.6);

        System.out.printf("Distancia da coordenada %s até %s : %s \n", coordenada1, coordenada2, coordenada1.calcularDistancia(coordenada2));

        System.out.printf("Distancia da coordenada %s até %s : %s", coordenada2, coordenada1, coordenada2.calcularDistancia(coordenada1));

        // coordenada1.x = 10; // Acusa o erro "The field Coordenada.x is not visible", pois não tem acesso
    }
}
