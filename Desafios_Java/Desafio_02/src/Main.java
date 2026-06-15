import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String nome = scanner.next();
        String tipoConta = scanner.next();

        if (tipoConta.equals("corrente") || tipoConta.equals("poupanca") || tipoConta.equals("investimento")) {

            System.out.println("Bem-vindo(a), " + nome + " ! Sua conta " + tipoConta + " esta pronta para uso.");
        } else {
            System.out.println("Tipo de conta invalido.");
        }

        scanner.close();
    }
}
