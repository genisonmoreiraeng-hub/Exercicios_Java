public class App {

    public static void main(String[] args) throws Exception {


       Carro meuCarro = new Carro();

        // 1. Testando ligar o carro
        meuCarro.ligar();

        String plusorminus = "acelerar";
        int cambio = 1;
        int speed = 21;
        meuCarro.Velocity(plusorminus,cambio,speed);
 /*
        // 3. Colocando na primeira marcha e acelerando
        meuCarro.trocarMarcha(1);
        while (meuCarro.verificarVelocidade()!=21) {
            meuCarro.acelerar(); // Velocidade 1
        }

        meuCarro.trocarMarcha(2);
        while (meuCarro.verificarVelocidade()!=41) {
            meuCarro.acelerar(); // Velocidade 1
        }

        meuCarro.trocarMarcha(3);
        while (meuCarro.verificarVelocidade()!=61) {
            meuCarro.acelerar(); // Velocidade 1
        }
        meuCarro.trocarMarcha(4);
        while (meuCarro.verificarVelocidade()!=81) {
            meuCarro.acelerar(); // Velocidade 1
        }
        meuCarro.trocarMarcha(5);
        while (meuCarro.verificarVelocidade()!=101) {
            meuCarro.acelerar(); // Velocidade 1
        }
        meuCarro.trocarMarcha(6);
        while (meuCarro.verificarVelocidade()!=120) {
            meuCarro.acelerar(); // Velocidade 1
        }
*/
        // 4. Testando virar
        meuCarro.virar("Direita");
        // 5. Tentando pular marcha (deve falhar - regra não permite pular)
        meuCarro.trocarMarcha(3); 
        // 6. Trocando de marcha corretamente
        meuCarro.trocarMarcha(2);        
        // 7. Testando limites de velocidade
        System.out.println("Velocidade atual: " + meuCarro.verificarVelocidade() + " km/h");        
        // 8. Testando desligar
        meuCarro.desligar(); // Deve falhar (velocidade > 0)        
        // Parando o carro para desligar
        meuCarro.diminuirVelocidade();
        meuCarro.diminuirVelocidade();
        meuCarro.trocarMarcha(0);
        meuCarro.desligar(); // Agora deve funcionar
    }
}
