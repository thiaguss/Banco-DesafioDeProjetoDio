package banco;

public abstract class Conta implements IConta{
    protected static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(Double valor) {
        if (saldo > 0){
            saldo -= valor;
        } else System.out.println("Saldo Insuficiente");
    }

    @Override
    public void depositar(Double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(Double valor, IConta contaDestino) {
        if (saldo > 0){ sacar(valor);
        contaDestino.depositar(valor);
        }else System.out.println("Saldo Insuficiente");
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("saldo: %.2f", this.saldo));
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

}
