package datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class Participante {
    private final String nome;
    private final ZoneId fuso;
    private final LocalDate dataNascimento;

    public Participante(String nome, ZoneId fuso, LocalDate dataNascimento) {
        this.nome = nome;
        this.fuso = fuso;
        this.dataNascimento = dataNascimento;
    }

    public Period idadeEm(LocalDate data) {
        if (dataNascimento.isAfter(data)) {
            throw new IllegalArgumentException(nome + " ainda não terá nascido em " + data + ".");
        }
        return Period.between(dataNascimento, data);
    }

    public String getNome() {
        return nome;
    }

    public ZoneId getFuso() {
        return fuso;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
