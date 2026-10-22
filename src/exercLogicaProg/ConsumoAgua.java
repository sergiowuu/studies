package exerclogicaprog;

import java.util.HashMap;
import java.util.Map;

/**
 * Uma companhia cobra o consumo de água por faixas:
 * os primeiros 10m³ custam uma tarifa fixa,
 * de 11m³ a 20m³ cada metro cúbico adicional custa mais caro,
 * e acima de 20m³ custa mais caro ainda. Dada a lista de leituras
 * mensais de um cliente ao longo de um ano, calcule o valor
 * total pago no ano, o mês de maior gasto e quantos meses ficaram
 * acima da média anual.
 */
public class ConsumoAgua {
    private static final int MESES_NO_ANO = 12;
    private static final int CONSUMO_MIN = 5;
    private static final int CONSUMO_MAX = 30;

    private static final int LIMITE_FAIXA_1 = 10; // m³
    private static final int LIMITE_FAIXA_2 = 20; // m³

    private static final double TARIFA_BASE = 10; // 0 a LIMITE_FAIXA_1
    private static final double TARIFA_MEDIANA = TARIFA_BASE * 1.2; // LIMITE_FAIXA_1 a LIMITE_FAIXA_2
    private static final double TARIFA_CARA = TARIFA_BASE * 1.5; // > LIMITE_FAIXA_2

    public static void main(String[] args) {

        Map<String, Double> leituras = new HashMap<>();
        Map<String, Double> valorPorMes = new HashMap<>();

        double valorAnual = 0;
        String mesMaiorValor = "";
        double maiorValor = Double.NEGATIVE_INFINITY;

        for (int i = 1; i <= MESES_NO_ANO; i++) {
            double consumo = CONSUMO_MIN + (CONSUMO_MAX - CONSUMO_MIN) * Math.random();

            leituras.put("Mes " + i, consumo);
        }

        for (Map.Entry<String, Double> leitura : leituras.entrySet()) {
            String mes = leitura.getKey();
            double consumo = leitura.getValue();

            double valorMensal = calcularValorMes(consumo);

            valorPorMes.put(mes, valorMensal);

            valorAnual += valorMensal;

            if (maiorValor < valorMensal) {
                maiorValor = valorMensal;
                mesMaiorValor = mes;
            }
        }

        double mediaAnual = valorAnual / leituras.size();
        int mesesAcimaMedia = 0;

        for (double valor : valorPorMes.values()) {
            if (valor > mediaAnual) {
                mesesAcimaMedia++;
            }
        }

        System.out.println("---------- Resultados ----------");

        System.out.printf("Valor anual: %.2f%n", valorAnual);
        System.out.printf("Mes de maior valor: %s -> %.2f%n", mesMaiorValor, maiorValor);
        System.out.printf("Media anual: %.2f%n", mediaAnual);
        System.out.printf("Meses acima da media anual: %d%n", mesesAcimaMedia);
    }

    static double calcularValorMes(double consumo) {
        if (consumo <= LIMITE_FAIXA_1) {
            return TARIFA_BASE;
        }

        if (consumo <= LIMITE_FAIXA_2) {
            return TARIFA_BASE + (consumo - LIMITE_FAIXA_1) * TARIFA_MEDIANA;
        }

        return TARIFA_BASE
                + (LIMITE_FAIXA_2 - LIMITE_FAIXA_1) * TARIFA_MEDIANA
                + (consumo - LIMITE_FAIXA_2) * TARIFA_CARA;
    }
}
