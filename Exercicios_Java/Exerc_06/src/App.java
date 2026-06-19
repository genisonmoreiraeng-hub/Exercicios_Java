import java.util.Scanner;

public class App {

    /* (Scanner, Ojeto meuCarro e variavel marcha) foram declarados fora da Main 
        como static para poder acessar de qualquer lugar do programa principal
    */
    private final static Scanner scanner = new Scanner(System.in);
    private final static Carro meuCarro = new Carro();
    static int marcha;

    public static void main(String[] args) throws Exception {
        var option = -1;

        do{
            System.out.println("##### Esolha a Opcão #####");
            System.out.println("1 - Liga o Carro ");
            System.out.println("2 - Desliga o Carro ");
            System.out.println("3 - Acelera ");
            System.out.println("4 - Desacelera ");
            System.out.println("5 - Muda de Direção ");
            System.out.println("6 - Muda a MArcha ");
            System.out.println("7 - Verifica a Velocidade");
            System.out.println("0 - Sair");
            System.out.println("##########################");
            option = scanner.nextInt();
            

            switch (option) {
                case 1 -> meuCarro.ligar();
                case 2 -> meuCarro.desligar();
                case 3 -> SpeedPlus();  
                case 4 -> SpeedMinus();
                case 5 -> TurnTheCorner();
                case 6 -> ChangeCambio(marcha);
                case 7 -> VerifyVelocity();
                case 0 -> System.exit(option =0);             
                default -> System.out.println(" Operação Invalida ");
                    
            }

        }while (option !=0);

    }

    private static void ChangeCambio(int marcha) {
        System.out.println("Digite a MArcha");
        marcha = scanner.nextInt();
        meuCarro.trocarMarcha(marcha);
    }

    private static int VerifyVelocity() {

        System.out.println("A Velocidade é " + meuCarro.verificarVelocidade()+"km");
        return 0;
    }

    private static void TurnTheCorner() {
        System.out.println("Digite a Direção");
        String direcao = scanner.next();
        meuCarro.virar(direcao);
    }

    private static void SpeedMinus() {
        System.out.println("##########################\n");
        System.out.print("Velocidade esta : " +meuCarro.verificarVelocidade()+"km_h\n");
        System.out.print("A MArcha esta : " + meuCarro.getMarcha());
        System.out.println("\n##########################");
        System.out.println("Digite até a Km/h");
        int km = scanner.nextInt();
        while (meuCarro.verificarVelocidade()!=km) {
            meuCarro.diminuirVelocidade(); 
        }

    }

    private static void SpeedPlus() {
        System.out.println("##########################\n");
        System.out.print("Velocidade esta : " + meuCarro.verificarVelocidade()+"km_h\n");
        System.out.print("A MArcha esta : " +meuCarro.getMarcha());
        System.out.println("\n##########################");
        System.out.println("Digite até a Km/h");
        int km = scanner.nextInt();

        if (meuCarro.voltaValidacaoVelocidade() && (meuCarro.getMarcha() !=0)){    

            while ((meuCarro.verificarVelocidade()!=km)&&(meuCarro.voltaValidacaoVelocidade()) ){
                meuCarro.acelerar(); 
            }              

        }else if (meuCarro.getMarcha() ==0){

            System.out.println("Coloque uma marcha para acelerar.");

        }else{
            System.out.println("Corriga a Marcha");

        }       
    }
}
