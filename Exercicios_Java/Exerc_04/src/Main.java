import java.util.Scanner;
/*
Escreva um código onde o usuário informa um número inicial, 
posteriormente irá informar outros N números, a execução do 
código irá continuar até que o número informado dividido pelo 
primeiro número tenha resto diferente de 0 na divisão, números 
menores que o primeiro número devem ser ignorados

*/
public class Main {        
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o Primeiro Numero: ");
        int NumeroInicial = scanner.nextInt();

        boolean result = false;
        
        while (result == false){
            System.out.print("Digite um Numero : ");
            int NumeroFinal = scanner.nextInt();

            // Logica para garantir que o numero digitado seja maior que o primeiro
            if (NumeroFinal<NumeroInicial) {
                System.out.print("Digite um numero Maior que o primeiro: \n");
                continue;
            }

            var ValorResult = NumeroFinal % NumeroInicial;
            result = NumeroFinal % NumeroInicial != 0;
            System.out.println( NumeroFinal + " % " + NumeroInicial + " = " + ValorResult);

        }      
         
    }
}