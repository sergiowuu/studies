package poo.records;

public record Coordenada (double x, double y){
    private static final double latitudeMaxima = 90;
    private static final double longitudeMaxima = 180;

    public Coordenada {
        if (x < -longitudeMaxima || x > longitudeMaxima) {
            throw new IllegalArgumentException("Longitude deve ser entre -180 e 180");
        }

        if (y < -latitudeMaxima || y > latitudeMaxima) {
            throw new IllegalArgumentException("Latidude deve ser entre -90 e 90");
        }
    }

    public double calcularDistancia(Coordenada outraCoordenada) {
        return Math.sqrt(Math.pow(x - outraCoordenada.x, 2) + Math.pow(y - outraCoordenada.y,2));
    }
}
