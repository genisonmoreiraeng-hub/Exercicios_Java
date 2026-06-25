public class IngressoFamilia extends Ingresso {
    
    private int quantidadePessoas;

    // #### Contrutor #############
    public IngressoFamilia(double valor, String nomeFilme, boolean dublado, int quantidadePessoas) {
        super(valor, nomeFilme, dublado);
        this.quantidadePessoas = quantidadePessoas;
    }
    public IngressoFamilia() {
       
    }

    // #### Gets and Sets #############
    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }
    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    @Override
    public double calcularValorReal(){
        double total = valor * quantidadePessoas;

        if (quantidadePessoas >3 ){
            total = total * 0.95; ;
        }

        return total;

    }

}
