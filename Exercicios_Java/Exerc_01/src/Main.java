import java.util.Scanner;
/*
Escreva um código onde o usuário entra com um número e seja gerada a tabuada de 1 até 10 desse número;
*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a Tabuada que deseja imprimir");
        int NumeroTabuada = scanner.nextInt();
        System.out.println(" ");
        System.out.println(" Inicio ");

        for (int i = 1 ; i <= 10 ; i++){
            System.out.println(NumeroTabuada*i);
        }
        scanner.close();
    }
}
