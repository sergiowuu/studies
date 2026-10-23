package datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

/**
 * Sistema de agendamento de reuniões online que recebe de um organizador um texto com
 * a data e hora da reunião no formato brasileiro (dia/mês/ano e hora:minuto). O programa deve:
 * - rejeitar com uma mensagem clara qualquer texto fora do formato esperado sem derrubar o programa;
 * - rejeitar reuniões marcadas para um momento que já passou;
 * - mostrar o horario dessa mesma reunião para dois particiantes em fusos diferentes (um em Nova York/EUA
 * e outro na Pequim/China), no mesmo formato de texto;
 * Informar quanto tempo falta até a reunião a partir de "agora" em dias, horas e minutos;
 * Dado o dia de nascimento de um participantes, informar a idade deles em anos, meses e dias no dia da reunião
 */
public class AgendamentoReuniao {
    private static final ZoneId FUSO_ORGANIZADOR = ZoneId.of("America/Sao_Paulo");
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter
            .ofPattern("dd/MM/uuuu")
            .withResolverStyle(ResolverStyle.STRICT);

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            Reuniao reuniao = lerReuniao(scan);

            Participante[] participantes = {
                    new Participante("Participante de Nova York", ZoneId.of("America/New_York"),
                            lerDataNascimento(scan, "Nova York")),
                    new Participante("Participante de Pequim", ZoneId.of("Asia/Shanghai"),
                            lerDataNascimento(scan, "Pequim"))
            };

            // "Agora" obtido só no momento da exibição, já que o organizador pode ter demorado nas entradas
            ZonedDateTime agora = ZonedDateTime.now(FUSO_ORGANIZADOR);

            System.out.println();
            System.out.println("=== Reunião agendada ===");
            System.out.println("Horário do organizador (São Paulo): " + reuniao.horarioEm(FUSO_ORGANIZADOR));
            System.out.println("Tempo até a reunião: " + reuniao.descreverTempoRestante(agora));

            for (Participante participante : participantes) {
                System.out.println();
                System.out.println(participante.getNome());
                System.out.println("  Horário local: " + reuniao.horarioEm(participante.getFuso()));
                try {
                    Period idade = participante.idadeEm(reuniao.dataEm(participante.getFuso()));
                    System.out.println("  Idade no dia da reunião: " + idade.getYears() + " ano(s), "
                            + idade.getMonths() + " mês(es) e " + idade.getDays() + " dia(s)");
                } catch (IllegalArgumentException e) {
                    System.out.println("  " + e.getMessage());
                }
            }
        }
    }

    private static Reuniao lerReuniao(Scanner scan) {
        while (true) {
            System.out.print("Data e hora da reunião (dd/MM/aaaa HH:mm): ");
            String texto = scan.nextLine();
            try {
                // now() depois do nextLine(): valida contra o momento em que o texto foi digitado
                return Reuniao.agendar(texto, FUSO_ORGANIZADOR, ZonedDateTime.now(FUSO_ORGANIZADOR));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static LocalDate lerDataNascimento(Scanner scan, String cidade) {
        while (true) {
            System.out.print("Data de nascimento do participante de " + cidade + " (dd/MM/aaaa): ");
            String texto = scan.nextLine().trim();
            try {
                return LocalDate.parse(texto, FORMATO_DATA);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida: \"" + texto + "\". Use o formato dd/MM/aaaa.");
            }
        }
    }
}
