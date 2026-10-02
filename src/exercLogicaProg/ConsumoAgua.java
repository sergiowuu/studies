package exercLogicaProg;

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
    private static final double TARIFA_BASE = 10; // 0 a 10
    private static final double TARIFA_MEDIANA = TARIFA_BASE * 1.2; // 11 a 20
    private static final double TARIFA_CARA = TARIFA_BASE * 1.5; // > 20

    public static void main(String[] args) {

        Map<String, Double> leituras = new HashMap<>();
        Map<String, Double> valorPorMes = new HashMap<>();

        double valorAnual = 0;
        String mesMaiorValor = "";
        double maiorValor = 0;

        for (int i = 1; i <= 12; i++) {
            int min = 5;
            int max = 30;

            double consumo = Math.round((min + (max - min) * Math.random()) * 100.0) / 100.0; // Duas casas decimais

            leituras.put("Mes " + i, consumo);
        }

        for (Map.Entry<String, Double> leitura : leituras.entrySet()) {
            String mes = leitura.getKey();
            Double consumo = leitura.getValue();

            double valorMensal = calcularValorMes(consumo);

            valorPorMes.put(mes, valorMensal);

            valorAnual += valorMensal;

            if (maiorValor < valorMensal) {
                maiorValor = valorMensal;
                mesMaiorValor = mes;
            }
        }

        double mediaAnual = valorAnual / 12;
        int mesesAcimaMedia = 0;

        for (Double valor : valorPorMes.values()) {
            if (valor > mediaAnual) {
                mesesAcimaMedia++;
            }
        }

        System.out.println("---------- Resultados ----------");

        System.out.println("Valor anual: " + Math.round(valorAnual * 100.0) / 100.0);
        System.out.println("Mes de maior valor: " + mesMaiorValor + " -> " + maiorValor);
        System.out.println("Média anual: " + mediaAnual);
        System.out.println("Meses acima da média anual: " + mesesAcimaMedia);
    }

    static double calcularValorMes(double consumo) {
        double valorMensal = 0;

        if (consumo <= 10) {
            valorMensal = TARIFA_BASE;
        } else if (consumo <= 20) {
            valorMensal = Math.round((TARIFA_BASE + (consumo - 10) * TARIFA_MEDIANA) * 100.0) / 100.0;
        } else {
            valorMensal = Math.round((TARIFA_BASE + 10 * TARIFA_MEDIANA + (consumo - 20) * TARIFA_CARA) * 100.0)
                    / 100.0;
        }

        return valorMensal;
    }
}
