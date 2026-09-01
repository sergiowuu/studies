package poo.Sobrecarga;

public class Frete {
    private String origem;
    private double valor;
    private String remetente;
    private String destinatario;
    private boolean premium = false;

    public Frete (String origem, String remetente, String destinatario, boolean premium){
        this.origem = origem;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.premium = premium;
    }

    private double calcularValorBase(double peso, double distancia){
        double valorDistancia = 0;
        if (distancia >= 10){
            valorDistancia = 10;
        } else if (distancia > 0 && distancia < 10){
            valorDistancia = 5;
        } else {
            valorDistancia = 0;
        }
        return 10 + (peso * 0.5) + valorDistancia;
    }

    public double calcularFrete(double peso){
        if(peso <= 0){
            System.out.println("Peso não pode ser 0 ou negativo");
            return 0;
        }

        this.valor = descontoPremium(calcularValorBase(peso, 0));
        return valor;
    }

    public double calcularFrete(double peso, double distancia){
        if(peso <= 0 || distancia <= 0){
            System.out.println("Peso ou distância não podem ser 0 ou negativo");
            return 0;
        }

        this.valor = descontoPremium(calcularValorBase(peso, distancia));
        return valor;
    }

    public double calcularFrete(double peso, double distancia, int quantidade){
        if(peso <= 0 || distancia <= 0 || quantidade <= 0){
            System.out.println("Os parâmetros não podem ser 0 ou negativo");
            return 0;
        }

        double valorQuantidade = quantidade * 0.5;
        this.valor = descontoPremium(calcularValorBase(peso, distancia) + valorQuantidade);
        return valor;
    }

    private double descontoPremium(double valor){
        double valorPosDesconto = valor;
        
        if(premium){
            valorPosDesconto = valor * 0.8;
        }

        return valorPosDesconto;
    }

    public String informacoesFrete(){
        String informacoes = "Origem: " + origem + "; Valor: " + valor + "; Remetente: " + remetente + "; Destinatario: " + destinatario;
        return informacoes;
    }

    public String getOrigem(){
        return origem;
    }

    public double getValor(){
        return valor;
    }

    public String getRemetente(){
        return remetente;
    }

    public String getDestinatario(){
        return destinatario;
    }
    
    public boolean isPremium(){
        return premium;
    }

}
