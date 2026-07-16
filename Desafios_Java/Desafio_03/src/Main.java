import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int saldoInicial = Integer.parseInt(scanner.nextLine());
        Conta conta = new Conta(saldoInicial);

        while (true) {
            String comando = scanner.nextLine().trim();
            if (comando.equals("fim")) break;

            String[] partes = comando.split(" ");
            String operacao = partes[0];
            int valor = Integer.parseInt(partes[1]);

            if (operacao.equals("depositar")) {
                conta.depositar(valor);
            } else if (operacao.equals("sacar")) {
                conta.sacar(valor);
            }
        }

        System.out.println(conta.getSaldo());
        scanner.close();
      
    }
}