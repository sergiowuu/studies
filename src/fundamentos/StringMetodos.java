package fundamentos;

public class StringMetodos {
    public static void main(String[] args) {
        String emailDigitado = "  Sergio@Email.COM  ";
        String emailHigienizado = emailDigitado.trim().toLowerCase();
        System.out.println("Email original: " + emailDigitado);
        System.out.println("Email higienizado: " + emailHigienizado);
    }
}
