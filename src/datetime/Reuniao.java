package datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Reuniao {
    // STRICT rejeita datas inexistentes (ex.: 31/02); exige "uuuu" no lugar de "yyyy"
    public static final DateTimeFormatter FORMATO = DateTimeFormatter
            .ofPattern("dd/MM/uuuu HH:mm")
            .withResolverStyle(ResolverStyle.STRICT);

    private final ZonedDateTime dataHora;

    // Construtor privado: a única forma de criar uma Reuniao é pelo agendar(), que valida tudo
    private Reuniao(ZonedDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public static Reuniao agendar(String texto, ZoneId fusoOrganizador, ZonedDateTime agora) {
        LocalDateTime dataHoraLocal;
        try {
            dataHoraLocal = LocalDateTime.parse(texto.trim(), FORMATO);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    "Data/hora inválida: \"" + texto + "\". Use o formato dd/MM/aaaa HH:mm (ex.: 25/12/2026 14:30).");
        }

        ZonedDateTime dataHora = dataHoraLocal.atZone(fusoOrganizador);
        if (!dataHora.isAfter(agora)) {
            throw new IllegalArgumentException("A reunião não pode ser marcada para um momento que já passou.");
        }
        return new Reuniao(dataHora);
    }

    public String horarioEm(ZoneId fuso) {
        return dataHora.withZoneSameInstant(fuso).format(FORMATO);
    }

    public String descreverTempoRestante(ZonedDateTime agora) {
        Duration restante = Duration.between(agora, dataHora);

        long dias = restante.toDaysPart();
        int horas = restante.toHoursPart();
        int minutos = restante.toMinutesPart();

        return String.format("%d dia(s), %d hora(s) e %d minuto(s)", dias, horas, minutos);
    }

    // A data do calendário depende do fuso: 23h em São Paulo já é o dia seguinte em Pequim
    public LocalDate dataEm(ZoneId fuso) {
        return dataHora.withZoneSameInstant(fuso).toLocalDate();
    }
}
