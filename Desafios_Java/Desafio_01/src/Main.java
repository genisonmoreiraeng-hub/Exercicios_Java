import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int saldo = scanner.nextInt();
        int valorTransacao = scanner.nextInt();

        if (saldo >= valorTransacao) {
            System.out.println("Transacao aprovada");
        } else {
            System.out.println("Saldo insuficiente");
        }

        scanner.close();
    }
}

