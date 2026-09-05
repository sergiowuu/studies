package poo.locadoraDeVeiculos.cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {
    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private final String cpf;
    private TipoCliente tipoCliente;

    private static final DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Cliente (String nome, String sobrenome, String dataNascimento, String cpf, TipoCliente tipoCliente){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = LocalDate.parse(dataNascimento, formatoData);
        this.cpf = cpf;
        this.tipoCliente = tipoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento.format(formatoData);
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = LocalDate.parse(dataNascimento, formatoData);
    }

    public String getCpf() {
        return cpf;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
}
