// Classe Conta com saldo encapsulado
class Conta {
    private int saldo;

    public Conta(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(int valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public void sacar(int valor) {
                
        if (valor <= saldo) {
            saldo -= valor;
        }
    }

    public int getSaldo() {
        return saldo;
    }
}
