public  class MeiaEntrada extends Ingresso {

   

    public MeiaEntrada(double valor, String nomeFilme, boolean dublado) {
        super(valor, nomeFilme, dublado);
        //TODO Auto-generated constructor stub
    }
    public MeiaEntrada() {
        
    }

    @Override
    public double calcularValorReal() {
        // TODO Auto-generated method stub
        return (valor / 2);
    }

   

}
