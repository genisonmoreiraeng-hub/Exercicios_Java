/*
Escreva um código onde temos uma conta bancaria 
que possa realizar as seguintes operações:
    - Consultar saldo
    - consultar cheque especial
    - Depositar dinheiro;
    - Sacar dinheiro;
    - Pagar um boleto.
    - Verificar se a conta está usando cheque especial.

Siga as seguintes regras para implementar

A conta bancária deve ter um limite de cheque especial somado ao saldo da conta;
O o valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado na conta em sua criação;
Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00
Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado;
Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.

obs.: Esse fiz com muita ajuda de IA
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite valo Deposito Inicial");
        var FirstDeposito = scanner.nextDouble();

        // 1. Criando conta com R$ 600,00 (Limiar para 50% de cheque especial = R$ 300,00)
        ContaBancaria minhaConta = new ContaBancaria(FirstDeposito);

        System.out.println("Saldo inicial: R$ " + minhaConta.consultarSaldo());
        System.out.println("Limite de Cheque Especial: R$ " + minhaConta.consultarChequeEspecial());

        // 2. Sacando um valor maior que o saldo para usar o cheque especial
        //System.out.println("\n--- Realizando saque de R$ 750,00 ---");
        System.out.println("Digite valo Saque");
        var FirstSaque = scanner.nextDouble();
        minhaConta.sacar(FirstSaque); 
        
        System.out.println("Saldo após saque: R$ " + minhaConta.consultarSaldo());
        System.out.println("Usando cheque especial? " + (minhaConta.usandoChequeEspecial() ? "Sim" : "Não"));

        // 3. Pagando um boleto (usa a mesma lógica de saque)
        //System.out.println("\n--- Pagando boleto de R$ 50,00 ---");
        System.out.println("Digite valo Boleto");
        var FirstBoleto = scanner.nextDouble();
        minhaConta.pagarBoleto(FirstBoleto);

        // 4. Depositando para cobrir a dívida e pagar a taxa de 20%
        System.out.println("\n--- Depositando R$ 300,00 ---");
        minhaConta.depositar(300.00);
        // O sistema deve quitar o cheque especial + taxa antes de atualizar o saldo

        System.out.println("Saldo final após depósito e taxas: R$ " + minhaConta.consultarSaldo());
        System.out.println("Usando cheque especial? " + (minhaConta.usandoChequeEspecial() ? "Sim" : "Não"));
    }
}
