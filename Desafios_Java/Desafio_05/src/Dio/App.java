package Dio;

import java.security.GeneralSecurityException;

import Dio.Facade.Facade;
import Dio.Singleton.SingletonEager;
import Dio.Singleton.SingletonLazy;
import Dio.Singleton.SingletonLazyHolder;
import Dio.strategy.Comportamento;
import Dio.strategy.ComportamentoAgressivo;
import Dio.strategy.ComportamentoDefensivo;
import Dio.strategy.ComportamentoNormal;
import Dio.strategy.Robo;

public class App {
    public static void main(String[] args) throws Exception {
        
        // ##### Singleton #####
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);

        SingletonEager Eager = SingletonEager.getInstancia();
        System.out.println(Eager);
        Eager = SingletonEager.getInstancia();
        System.out.println(Eager);

        SingletonLazyHolder lazyholder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyholder);
        lazyholder = SingletonLazyHolder.getInstancia();
        System.out.println(lazyholder);

        // ##### Strategy #####

        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento normal = new ComportamentoNormal();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();
        robo.setComportamento(normal);
        robo.mover();
        robo.mover();
        robo.setComportamento(defensivo);
        robo.mover();
        robo.mover();
        robo.mover();
        robo.setComportamento(agressivo);
        robo.mover();
        robo.mover();
        robo.mover();
        robo.mover();
        robo.mover();
        robo.mover();

        // ##### Facade #####

        Facade facade = new Facade();
        facade.migrarCliente("Genison", "12151264");



    }
}
