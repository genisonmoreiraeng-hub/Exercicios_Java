import java.util.Scanner;
/*
Escreva um código que o usuário entre com um primeiro número, 
um segundo número maior que o primeiro e escolhe entre a opção 
par e impar, com isso o código deve informar todos os números 
pares ou ímpares (de acordo com a seleção inicial) no intervalo 
de números informados, incluindo os números informados e em 
ordem decrescente;

*/
public class Main {        
  
    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o Primeiro Numero: ");
        int NumeroInicial = scanner.nextInt();

        System.out.print("Digite o Segundo Numero: ");
        int NumeroFinal = scanner.nextInt();

        // Logica para garantir que o numero digitado seja maior que o primeiro
        while (NumeroFinal<NumeroInicial) {
            System.out.print("Tente Novamente, agora digite um numero Maior que o primeiro: ");
            NumeroFinal = scanner.nextInt();
        }
       
        String escolha; // declarando variavel fora da logica "do while"

        // Logica "do while" para garantir que o usuario Digite Impar ou Par
        do {
            System.out.print("Digite 'Impar' ou 'Par': ");
            escolha = scanner.nextLine();

        } while ((!escolha.equalsIgnoreCase("Impar") || !escolha.equalsIgnoreCase("impar")) && 
                 (!escolha.equalsIgnoreCase("Par")   || !escolha.equalsIgnoreCase("par"  )));

        
        if (escolha.equals("impar")){escolha = "Impar";} // converte para maiusculo
        if (escolha.equals("par")){escolha = "Par";}     // converte para maiusculo

        for (int i = NumeroFinal; i >= NumeroInicial ; --i){

            if (escolha.equals("Impar")){
                if (i % 2 == 1) {
                    System.out.println(i); //Só imprimi numeros Impares
                    
                } else if (i == NumeroFinal){System.out.println(NumeroFinal);// colocar numero Final mesmo se for Par na logica do Impar

                } else if (i == NumeroInicial){System.out.println(NumeroInicial);} // colocar numero inicial mesmo se for Par na logica do Impar           

                    
            }
            if (escolha.equals("Par")){
                if (i % 2 == 0) {
                    System.out.println(i); //Só imprimi numeros Pares

                } else if (i == NumeroFinal){System.out.println(NumeroFinal);// colocar numero Final mesmo se for Impar na logica do Par

                } else if (i == NumeroInicial){System.out.println(NumeroInicial);} // colocar numero inicial mesmo se for Impar na logica do Par
                
            }           
        }     
        scanner.close();       
    }
}