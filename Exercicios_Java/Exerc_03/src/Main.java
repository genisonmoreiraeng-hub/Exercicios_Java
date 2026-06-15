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