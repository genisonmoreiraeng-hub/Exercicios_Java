/*
Escreva um código onde controlamos as funções de um carro, ele deve ter as seguintes funções:
Ligar o carro;
Desligar o carro;
Acelerar;
diminuir velocidade;
virar para esquerda/direita
verificar velocidade;
trocar a marcha
Siga as seguintes regras na implementação

Quando o carro for criado ele deve começar desligado, em ponto morto e com sua velocidade em 0
O carro desligado não pode realizar nenhuma função;
Quando o carro for acelerado ele deve incrementar 1km em sua velocidade (pode chegar no máximo a 120km);
Quando diminuir a velocidade do carro ele deve decrementar 1 km de sua velocidade (pode chegar no minimo a 0km);
o carro deve possuir 6 marchas, não deve ser permitido pular uma marcha no carro;
A velocidade do carro deve respeitar os seguintes limites para cada velocidade
se o carro estiver na marcha 0 (ponto morto) ele não pode acelerar
se estiver na 1ª marcha sua velocidade pode estar entre 0km e 20km
se estiver na 2ª marcha sua velocidade pode estar entre 21km e 40km
se estiver na 3ª marcha sua velocidade pode estar entre 41km e 60km
se estiver na 4ª marcha sua velocidade pode estar entre 61km e 80km
se estiver na 5ª marcha sua velocidade pode estar entre 81km e 100km
se estiver na 6ª marcha sua velocidade pode estar entre 101km e 120km
O carro podera ser desligado se estiver em ponto morto (marcha 0) e sua velocidade em 0 km
O carro só pode virar para esquerda/direita se sua velocidade for de no mínimi 1km e no máximo 40km;


*/

public class Carro {

    private boolean ligado;
    private int velocidade;
    private int marcha;

    //################ Sets e Gets ##################
    public boolean getLigado() {
        return ligado;
    }
    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
    public int getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }    
    public int getMarcha() {
        return marcha;
    }
    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }
    //############# Contructors ######################
    public Carro(boolean ligado, int velocidade, int marcha) {
        this.ligado = ligado;
        this.velocidade = velocidade;
        this.marcha = marcha;
    }

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0;
    }
    //############# Metodos ###########################
    public void ligar(){
        if (!this.ligado) {
            this.ligado = true;
            System.out.println("Carro ligado.");
        }
    }
    public void desligar(){

        if (this.ligado && this.marcha == 0 && this.velocidade != 0){

          while ((verificarVelocidade()!=0) ){
                diminuirVelocidade();
            } 

        }

        if (this.ligado && this.marcha == 0 && this.velocidade == 0) {
            this.ligado = false;
            System.out.println("Carro desligado.");
        } else {
            System.out.println("Não é possível desligar: o carro deve estar em ponto morto e parado.");
        }
    }
    public void acelerar(){
        if (!this.ligado){
            System.out.println("Carro desligado.");
            return;
        } 
        
        // Regra: Não acelera em ponto morto
        if (marcha == 0) {
            System.out.println("Coloque uma marcha para acelerar.");
            return;
        }


        // Regra: Máximo 120km
        if (this.velocidade < 120) {
            this.velocidade++;
            System.out.println("Velocidade: " + this.velocidade + "km/h");
        }
    }
    public void diminuirVelocidade(){
        if (!this.ligado) {
            System.out.println("Carro desligado.");
            return;
        } 
        if (this.velocidade > 0) {
            this.velocidade--;
            System.out.println("Velocidade: " + this.velocidade + "km/h");
        }
    
    }
    public void virar(String direcao){
        if (!this.ligado) {
            System.out.println("Carro desligado.");
            return;
        } 

        if (this.velocidade >= 1 && this.velocidade <= 40) {
            System.out.println("Virando para " + direcao);
        } else {
            System.out.println("Velocidade incompatível para realizar manobra.");
        }        
    }

    public void trocarMarcha(int novaMarcha){
        if (!this.ligado) {
            System.out.println("Carro desligado.");
            return;
        } 

        // Regra: Não pular marchas (deve ser +1 ou -1)
        if (Math.abs(novaMarcha - this.marcha) != 1 && !(marcha == 0 && novaMarcha == 1)) {
            System.out.println("Você não pode pular marchas!");
            return;
        }

        if (validarVelocidadeParaMarcha(novaMarcha)) {
            this.marcha = novaMarcha;
            System.out.println("Marcha trocada para: " + this.marcha);
        } else {
            System.out.println("Erro: Velocidade incompatível com a marcha desejada.");
        }
        this.marcha = novaMarcha;
    
    }

    public boolean voltaValidacaoVelocidade(){
        //##############################################

        if (validarVelocidadeParaMarcha(marcha)) {            
            return true;
        } else {
            System.out.println("Erro: Velocidade incompatível com a marcha desejada.");
            
        }
        //#################################################
        return false;

      
    }


    private boolean validarVelocidadeParaMarcha(int m) {
        return switch (m) {
            case 0 -> true;
            case 1 -> this.velocidade >= 0 && this.velocidade <= 20;
            case 2 -> this.velocidade >= 21 && this.velocidade <= 40;
            case 3 -> this.velocidade >= 41 && this.velocidade <= 60;
            case 4 -> this.velocidade >= 61 && this.velocidade <= 80;
            case 5 -> this.velocidade >= 81 && this.velocidade <= 100;
            case 6 -> this.velocidade >= 101 && this.velocidade <= 120;
            default -> false;
        };
    }


    public int verificarVelocidade(){
       
        return this.velocidade;
    }



}
