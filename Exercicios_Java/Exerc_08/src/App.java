/*
Crie uma hierarquia de classes para tratar os 
tipos de ingresso que podem ser comercializados 
em um cinema. O ingresso deve ter um valor, 
nome do filme e informar se é dublado ou legendado. 
A partir desse ingresso devem ser criados os 
tipos Meia entrada e ingresso família. Cada ingresso 
deve ter um método que retorna o seu valor real 
( baseado no valor informado na criação do ingresso) 
 para os de meia entrada o seu valor deve ser de 
 metade do valor, para os ingressos família deve-se 
 retornar o valor multiplicado pelo número de pessoas 
 e fornecer um desconto de 5% quando o número de 
 pessoas for maior que 3.
*/
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class App {

    private final static Ingresso ticket = new Ingresso();
    private final static MeiaEntrada ticketHalf = new MeiaEntrada();
    private final static IngressoFamilia ticketFamily = new IngressoFamilia();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        // Obtém o dia atual (ex: WEDNESDAY)
        DayOfWeek hoje = LocalDate.now().getDayOfWeek();
        
        // Switch para definir o valor do ingresso conforme dia da semana
        switch (hoje) {
            case WEDNESDAY:
                ticket.setValor(30.00); 
                ticketHalf.setValor(30.00);
                ticketFamily.setValor(30.00);            
                break;
            case SATURDAY, SUNDAY :
                ticket.setValor(50.00);
                ticketHalf.setValor(50.00);
                ticketFamily.setValor(50.00); 
                break;
            default : 
            ticket.setValor(40.00);
            ticketHalf.setValor(40.00);
            ticketFamily.setValor(40.00);  
        };        

        var i = "";
        int quantidadeIngressos = 0;

        var option0 = -1;        
        System.out.println("##### Esolha a Opcão de Ingresso #####");
        System.out.println("1 - Ingresso Noramal ");
        System.out.println("2 - Ingresso Meio Entreda ");
        System.out.println("3 - Ingresso Familia ");
        System.out.println("##########################");
        option0 = scanner.nextInt();

        switch (option0) {
            case 1:
                i = "ticket";
                break;
            case 2:
                i = "ticketHalf";
                break;
            case 3:
                i = "ticketFamily";
                break;                   
            default : System.out.println(" Operação Invalida ");                    
        }
            // if do ticket Normal 
            if (i=="ticket"){
                var option1 = -1;        
                System.out.println("##### Esolha a Opcão de Filme #####");
                System.out.println("1 - Treinar Dragão ");
                System.out.println("2 - O Ultimo Dragão Branco ");
                System.out.println("3 - O Dragão Perdido ");
                System.out.println("4 - O Pequeno Dragão ");
                System.out.println("5 - Grande Gafanhoto ");
                System.out.println("0 - Sair");
                System.out.println("##########################");
                option1 = scanner.nextInt();            

                switch (option1) {
                    case 1:
                        ticket.setNomeFilme("Treinar Dragrão ");
                        break;
                    case 2:
                        ticketHalf.setNomeFilme("O Ultimo Dragão Branco ");
                        break;
                    case 3:
                        ticket.setNomeFilme("O Dragão Perdido ");
                        break;
                    case 4:
                        ticket.setNomeFilme("O Pequeno Dragão ");
                        break;
                    case 5:
                        ticket.setNomeFilme("Grande Gafanhoto ");
                        break;
    
                    default : System.out.println(" Operação Invalida ");                    
                }

                var option2 = -1;        
                System.out.println("##### Esolha a Opcão de Filme #####");
                System.out.println("1 - Dublado ");
                System.out.println("2 - Legendado ");
                System.out.println("##########################");
                option2 = scanner.nextInt();            

                switch (option2) {
                    case 1:
                        ticket.setDublado(true);
                        break;
                    case 2:
                        ticket.setDublado(false);
                        break;
                    default : System.out.println(" Operação Invalida ");                    
                }
            // if do ticket Media Entrada
            }else if(i=="ticketHalf"){
                var option1 = -1;        
                System.out.println("##### Esolha a Opcão de Filme #####");
                System.out.println("1 - Treinar Dragão ");
                System.out.println("2 - O Ultimo Dragão Branco ");
                System.out.println("3 - O Dragão Perdido ");
                System.out.println("4 - O Pequeno Dragão ");
                System.out.println("5 - Grande Gafanhoto ");
                System.out.println("0 - Sair");
                System.out.println("##########################");
                option1 = scanner.nextInt();            

                switch (option1) {
                    case 1:
                        ticketHalf.setNomeFilme("Treinar Dragrão ");
                        break;
                    case 2:
                        ticketHalf.setNomeFilme("O Ultimo Dragão Branco ");
                        break;
                    case 3:
                        ticketHalf.setNomeFilme("O Dragão Perdido ");
                        break;
                    case 4:
                        ticketHalf.setNomeFilme("O Pequeno Dragão ");
                        break;
                    case 5:
                        ticketHalf.setNomeFilme("Grande Gafanhoto ");
                        break;
    
                    default : System.out.println(" Operação Invalida ");                    
                }

                var option2 = -1;        
                System.out.println("##### Esolha a Opcão de Filme #####");
                System.out.println("1 - Dublado ");
                System.out.println("2 - Legendado ");
                System.out.println("##########################");
                option2 = scanner.nextInt();            

                switch (option2) {
                    case 1:
                        ticketHalf.setDublado(true);
                        break;
                    case 2:
                        ticketHalf.setDublado(false);
                        break;
                    default : System.out.println(" Operação Invalida ");                    
                }
            // if do ticket Familia
            }else if(i=="ticketFamily"){
                var option1 = -1;        
                System.out.println("##### Esolha a Opcão de Filme #####");
                System.out.println("1 - Treinar Dragão ");
                System.out.println("2 - O Ultimo Dragão Branco ");
                System.out.println("3 - O Dragão Perdido ");
                System.out.println("4 - O Pequeno Dragão ");
                System.out.println("5 - Grande Gafanhoto ");
                System.out.println("0 - Sair");
                System.out.println("##########################");
                option1 = scanner.nextInt();            

                switch (option1) {
                    case 1:
                        ticketFamily.setNomeFilme("Treinar Dragrão ");
                        break;
                    case 2:
                        ticketFamily.setNomeFilme("O Ultimo Dragão Branco ");
                        break;
                    case 3:
                        ticketFamily.setNomeFilme("O Dragão Perdido ");
                        break;
                    case 4:
                        ticketFamily.setNomeFilme("O Pequeno Dragão ");
                        break;
                    case 5:
                        ticketFamily.setNomeFilme("Grande Gafanhoto ");
                        break;
    
                    default : System.out.println(" Operação Invalida ");                    
                }

                var option2 = -1;        
                System.out.println("##### Esolha a Opcão de Filme #####");
                System.out.println("1 - Dublado ");
                System.out.println("2 - Legendado ");
                System.out.println("##########################");
                option2 = scanner.nextInt();            

                switch (option2) {
                    case 1:
                        ticketFamily.setDublado(true);
                        break;
                    case 2:
                        ticketFamily.setDublado(false);
                        break;
                    default : System.out.println(" Operação Invalida ");                    
                }
                System.out.println("Digtie a Quantidade de Ingressos");
                quantidadeIngressos = scanner.nextInt();
                ticketFamily.setQuantidadePessoas(quantidadeIngressos);

            }   
            

            if (i=="ticket"){
                System.out.println("\n----- Dados do Ingresso -----");
                System.out.println("Filme: " + ticket.getNomeFilme());
                System.out.println("Dublado: " + ticket.isDublado());
                System.out.println("Valor total: R$ " + ticket.calcularValorReal());
            }else if (i=="ticketHalf"){
                System.out.println("\n----- Dados do Ingresso Meia -----");
                System.out.println("Filme: " + ticketHalf.getNomeFilme());
                System.out.println("Dublado: " + ticketHalf.isDublado());
                System.out.println("Valor total: R$ " + ticketHalf.calcularValorReal());
            }else if(i=="ticketFamily"){
                System.out.println("\n----- Dados do Ingresso Family -----");
                System.out.println("Filme: " + ticketFamily.getNomeFilme());
                System.out.println("Dublado: " + ticketFamily.isDublado());
                System.out.println("Quantidade de pessoas: " + ticketFamily.getQuantidadePessoas());
                double valorFamily = ticketFamily.calcularValorReal();
                System.out.printf("Valor: R$ %.2f%n", valorFamily);

            }    

    scanner.close();


    }

}
