package lambdaExpression;

public class Lambda {
    public static void main(String[] args){
        Send sendEmail = (message) -> System.out.printf("Mensagem enviada usando email: %s \n", message);
        sendEmail.send("Hello World! via email");

        Send sendSMS = (message) -> System.out.printf("Mensagem enviada usando SMS: %s \n", message);
        sendSMS.send("Hello World! via SMS");

        sendMessage(m -> System.out.printf("Mensagem enviada usando push: %s \n", m), "Hello World! via push");
    }

    public static void sendMessage(Send send, String message){
        send.send(message);
    }
}
