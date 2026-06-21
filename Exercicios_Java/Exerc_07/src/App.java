import java.util.Scanner;

public class App {


    private final static MaquinaBanho mquina = new MaquinaBanho();
    private final static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
       var option = -1;
        ;
        do{
            System.out.println("##### Esolha a Opcão #####");
            System.out.println("1 - Dar banho no pet ");
            System.out.println("2 - Abastecer com água ");
            System.out.println("3 - Abastecer com shampoo ");
            System.out.println("4 - verificar nivel de água ");
            System.out.println("5 - verificar nivel de shampoo ");
            System.out.println("6 - verificar se tem pet no banho ");
            System.out.println("7 - colocar pet na maquina ");
            System.out.println("8 - retirar pet da máquina ");
            System.out.println("9 - limpar maquina ");
            System.out.println("0 - Sair");
            System.out.println("##########################");
            option = scanner.nextInt();
            

            switch (option) {
                //case 1 -> meuCarro.ligar();
                case 2 -> AbasteceAgua();
                case 3 -> AbasteceShampoo();  
                case 4 -> QualNivelAgua();
                case 5 -> QualNivelShampoo();
                case 6 -> VerificaSeTemPet();
                case 7 -> ColocaTotoNaMaquina();
                //case 8 -> "XXXXXXXXX";
                //case 9 -> "XXXXXXXXX";
                case 0 -> System.exit(option =0);             
                default -> System.out.println(" Operação Invalida ");
                    
            }

        }while (option !=0);

        

    //System.out.println("2 - Desliga o Carro ");

    }
    private static void ColocaTotoNaMaquina() {
        System.out.println("Qual é o Nome do toto ? ");
        var animal = scanner.nextLine(); // Comentar essa parte 
        var pet = new Pet(animal);
        
        mquina.colocarPet(pet);
    }
    private static boolean VerificaSeTemPet() {
        if (mquina.temPet()){
            System.out.println("A Maquina esta Ocupada ");
            
        }else {
            System.out.println("A Maquina esta Livre ");
            
        }   
        return false;
    }
    private static int QualNivelShampoo() {
        System.out.println("A Maquina esta com " + mquina.verificarNivelShampoo() + " Litros De Shampoo") ;
        return 0;
    }
    private static int QualNivelAgua() {        
        System.out.println("A Maquina esta com " + mquina.verificarNivelAgua()+ " Litros de Agua") ;
        return 0;
    }
    private static void AbasteceShampoo() {
        if (mquina.verificarNivelShampoo()!=10){
            mquina.abastecerShampoo();
        }
        System.out.println("A Maquina esta com Shampoo no Maximo " + mquina.verificarNivelShampoo() +" Litros");
    }
    private static void AbasteceAgua() {

       if(mquina.verificarNivelAgua()!=30) {
            mquina.abastecerAgua();                   
        }
        System.out.println("A Maquina esta com Agua no Maximo " + mquina.verificarNivelAgua()+" Litros");
    }
}
