public class ContaBancaria {

    private double Saldo;
    private double LimiteChequeEspecial;
    private double valorUtilizadoChequeEspecial;
    private static final double TAXA_CHEQUE_ESPECIAL = 0.20;    

    public ContaBancaria() {
    }

    public ContaBancaria(double saldo){
        //Saldo=saldo;
        contaBancaria(saldo);

    }

    public ContaBancaria(double saldo, double limiteChequeEspecial, double valorUtilizadoChequeEspecial) {
        Saldo = saldo;
        LimiteChequeEspecial = limiteChequeEspecial;
        this.valorUtilizadoChequeEspecial = valorUtilizadoChequeEspecial;
    }

    public void contaBancaria(double depositoInicial){
        Saldo = depositoInicial;

        if (depositoInicial <= 500.00){
            this.LimiteChequeEspecial = 50.00;

        }else{
            this.LimiteChequeEspecial = depositoInicial*0.5;
        }                
    }
    public double consultarSaldo(){ return this.Saldo; }
    public double consultarChequeEspecial(){ return this.LimiteChequeEspecial;}
    
    public void depositar(double valor){
        // Se houver uso do cheque, o depósito quita a dívida primeiro
        if (this.valorUtilizadoChequeEspecial > 0) {
            cobrarTaxaChequeEspecial();
            double valorParaQuitar = this.valorUtilizadoChequeEspecial;
            if (valor >= valorParaQuitar) {
                valor -= valorParaQuitar;
                this.valorUtilizadoChequeEspecial = 0;
                this.Saldo += valor;
            } else {
                this.valorUtilizadoChequeEspecial -= valor;
            }
        } else {
            this.Saldo += valor;
        }       
    }

    public void sacar(double valor){
        if (valor <= (this.Saldo + (this.LimiteChequeEspecial - this.valorUtilizadoChequeEspecial))) {
            if (valor <= this.Saldo) {
                this.Saldo -= valor;
            } else {
                double resto = valor - this.Saldo;
                this.Saldo = 0;
                this.valorUtilizadoChequeEspecial += resto;
            }
        } else {
            System.out.println("Saldo insuficiente!");
        }        
    }

    public void pagarBoleto(double valor){
        sacar(valor);       
    }
    public boolean usandoChequeEspecial(){
        return this.valorUtilizadoChequeEspecial > 0;
    }
    public void cobrarTaxaChequeEspecial(){
        if (usandoChequeEspecial()) {
            double taxa = this.valorUtilizadoChequeEspecial * TAXA_CHEQUE_ESPECIAL;
            this.Saldo -= taxa; // Taxa descontada do saldo disponível
        }
    }

}
