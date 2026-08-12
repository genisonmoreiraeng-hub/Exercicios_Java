public class RelogioAmericano extends Relogio{
    public String getPeriodoIndicador() {
        return periodoIndicador;
    }

    public void setAfterMeioDia(){
        this.periodoIndicador = "PM";
    }
    public void setBeforeMeioDia(){
        this.periodoIndicador = "AM";
    }


    private String periodoIndicador;



    public void setHora(int hora) {
        setBeforeMeioDia();
        if ((hora > 12) && (hora<=23)){
            this.hora = hora - 12;
            setAfterMeioDia();
        }else if (hora >= 24){
            this.hora = 0;
        }else {
            this.hora = hora;
        }
        
    }

    public RelogioAmericano(int hora, int minuto, int segundo) {
        super(hora, minuto, segundo);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void converterHorario(Relogio relogio) {
        // TODO Auto-generated method stub
        
    }
}    