import java.util.Scanner;
/*
Escreva um código onde o usuário informa um número inicial, 
posteriormente irá informar outros N números, a execução do 
código irá continuar até que o número informado dividido pelo 
primeiro número tenha resto diferente de 0 na divisão, números 
menores que o primeiro número devem ser ignorados

*/
public class Main {
        
    public static float imcCalc(float a, float b) {
        return b/(a*a);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite sua Altura(sem ponto) e Peso");
        float Altura = scanner.nextInt();
        float Peso = scanner.nextInt();

        float result = imcCalc(Altura/100, Peso);

        if (result <= 18.5 ){
            System.out.println("Abaixo do peso");
        }else if (result >= 18.6 && result <= 24.9 ){
            System.out.println("Peso ideal");
        }else if (result >= 25.0 && result <= 29.9 ){
            System.out.println("Levemente acima do peso");
        }else if (result >= 30.0 && result <= 34.9 ){
            System.out.println("Obesidade Grau I");
        }else if (result >= 35.0 && result <= 39.9 ){
            System.out.println("Obesidade Grau II (Severa)");
        }else{
            System.out.println("Obesidade III (Mórbida)");
        }

        scanner.close();
    }
}