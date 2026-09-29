package exercLogicaProg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Enunciado:
 * Um campeonato tem N times, e cada partida gera um resultado (vitória vale 3 pontos, empate
 * 1, derrota 0). Dada uma lista de resultados de um único time, calcule seus pontos totais, o maior
 * número de vitórias consecutivas e o aproveitamento em porcentagem.
 */
public class PlacarCampeonato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> resultados = new ArrayList<>();

        int pontosTotais = 0;
        int vitoriasConsecutivas = 0;
        int maiorSequenciaVitorias = 0;

        int opcao = 0;

        while (opcao != 8) {
            System.out.println("Selecione a opção desejada: ");
            System.out.println("1. Marcar vitória");
            System.out.println("2. Marcar empate");
            System.out.println("3. Marcar derrota");
            System.out.println("4. Listar resultados");
            System.out.println("5. Calcular total de pontos");
            System.out.println("6. Maior sequencia de vitoria");
            System.out.println("7. Aproveitamento em %");
            System.out.println("8. sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Marcar vitoria
                    resultados.add("V");
                    pontosTotais += 3;
                    vitoriasConsecutivas++;
                    if (vitoriasConsecutivas > maiorSequenciaVitorias) {
                        maiorSequenciaVitorias = vitoriasConsecutivas;
                    }
                    break;

                case 2: // Marcar empate
                    resultados.add("E");
                    pontosTotais++;
                    vitoriasConsecutivas = 0;
                    break;

                case 3: // Marcar derrota
                    resultados.add("D");
                    vitoriasConsecutivas = 0;
                    break;

                case 4: // Listar resultados
                    for (String resultado : resultados) {
                        System.out.println(resultado);
                    }
                    break;

                case 5: // Calcular total de pontos
                    System.out.printf("Total de pontos: %s\n", pontosTotais);
                    break;

                case 6: // Maior sequencia de vitorias
                    System.out.printf("Maior sequencia de vitoria: %s\n", maiorSequenciaVitorias);
                    break;

                case 7: // Aproveitamento em %
                    if (resultados.size() == 0) {
                        System.out.println("Nenhuma partida registrada.");
                    } else {
                        double aproveitamento = ((double) pontosTotais / (resultados.size() * 3)) * 100;
                        System.out.printf("Aproveitamento: %.2f\n", aproveitamento);
                    }
                    break;

                case 8:
                    System.out.println("Saindo...");
                    break;
            
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }
}
