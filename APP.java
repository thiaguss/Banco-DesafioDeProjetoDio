import banco.Cliente;
import banco.Conta;
import banco.ContaCorrente;
import banco.ContaPoupanca;

public class APP {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        cliente.setNome("thiago");

        Conta cc = new ContaCorrente(cliente);
        Conta cc1 = new ContaPoupanca(cliente);

        cc.imprimirExtrato();
        cc.depositar(200.0);
        cc.imprimirExtrato();

        cc1.imprimirExtrato();

        cc.transferir(150.0,cc1);
        cc.imprimirExtrato();

        cc1.imprimirExtrato();

    }
}
