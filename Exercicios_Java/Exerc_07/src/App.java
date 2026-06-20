public class App {
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
}
