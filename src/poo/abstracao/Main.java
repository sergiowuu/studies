package poo.abstracao;

public class Main {
    public static void main(String[] args){
        Cartao cartao = new Cartao("123", "123456", "Sérgio", 10000.00);

        cartao.processarTransacao(10, "débito","2026-01-01");
        cartao.exibirDetalhes();

        cartao.processarTransacao(20, "crédito", "2026-01-02");
        cartao.exibirDetalhes();

        Boleto boleto = new Boleto("456", 100,"12345678901234567890", "2026-01-01");
        boleto.processarTransacao(30, "boleto", "2026-01-02");
        boleto.exibirDetalhes();

        Boleto boleto2 = new Boleto("789", 100,"09876543210987654321", "2026-01-01");
        boleto2.processarTransacao(40, "boleto", "2025-12-31");
        boleto2.exibirDetalhes();

        // Transacao transacao = new Transacao("000", 1000); // Nào é possível instanciar uma classe abstrata
    }   
}
