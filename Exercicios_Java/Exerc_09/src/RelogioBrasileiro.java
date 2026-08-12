public class RelogioBrasileiro extends Relogio {


    public RelogioBrasileiro(int hora, int minuto, int segundo) {
        super(hora, minuto, segundo);
        //TODO Auto-generated constructor stub
    }


    @Override
    public void converterHorario(Relogio relogio) {
        this.segundo = relogio.getSegundo();
        this.minuto = relogio.getMinuto();
        switch (relogio) {
            case RelogioAmericano relogioAmericano -> this.hora = (relogioAmericano.getPeriodoIndicador().equals("PM"))?
                                relogioAmericano.getHora() + 12 :
                                relogioAmericano.getHora();

            case RelogioBrasileiro relogiobrasileiro -> this.hora = relogiobrasileiro.getHora();                    

        }
        
    }
}
