import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            
            // Leitura dos valores de entrada
            String saldoInput = scanner.nextLine();
            String saqueInput = scanner.nextLine();

            int saldo = Integer.parseInt(saldoInput.trim());
            int valorSaque = Integer.parseInt(saqueInput.trim());

            if (valorSaque <= 0) {
                System.out.println("Valor invalido");
                return;
                
            }

            // Dica: Use uma estrutura condicional para validar o valor do saque antes de prosseguir

            // Verifica se há saldo suficiente para o saque
            if (valorSaque > saldo) {
                System.out.println("Saldo insuficiente");
                return;
            }
            
            // Saque realizado com sucesso
            System.out.println(saldo - valorSaque);

        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida");

            
        }
        
    }
    
}