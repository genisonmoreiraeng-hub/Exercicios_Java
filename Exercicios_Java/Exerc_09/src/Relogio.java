public abstract class Relogio {

    protected int hora;
    protected int minuto;
    protected int segundo;

    //##### Gets and Sets ##########
    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora >= 24){
            hora = 24;
        }
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (segundo >= 60){
            segundo = 59;
        }
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (segundo >= 60){
            segundo = 59;
        }
        this.segundo = segundo;
    }

    // ######## Contructor ###########
    public Relogio(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public abstract void converterHorario(Relogio relogio);

}
