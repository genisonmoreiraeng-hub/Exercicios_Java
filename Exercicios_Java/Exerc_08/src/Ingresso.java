public class Ingresso {

    // Atributos comuns a todos os tipos de ingresso
    protected double valor;
    protected String nomeFilme;
    protected boolean dublado;

    // #### Contrutor #############
    public Ingresso(double valor, String nomeFilme, boolean dublado) {
        this.valor = valor;
        this.nomeFilme = nomeFilme;
        this.dublado = dublado;
    }
    public Ingresso() {

    }

    // ####Gets and Stes ##########
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getNomeFilme() {
        return nomeFilme;
    }
    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }
    public boolean isDublado() {
        return dublado;
    }
    public void setDublado(boolean dublado) {
        this.dublado = dublado;
    }

    public  double calcularValorReal(){

        return this.valor;

    }




}
