package poo.enums;

public enum TipoFuncionario {
    OPERADOR(0),
    VENDEDOR(0.1),
    VELHAGUARDA(500);

    private final double bonus;

    TipoFuncionario(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
}
