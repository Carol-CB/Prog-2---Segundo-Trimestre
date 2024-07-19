package Aula24;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(String titular, String senha, float depositoInicial) {
        super(titular, senha);
        depositar(depositoInicial);
    }

    public boolean sacar(float valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public String verificaSaldo() {
        return "Saldo: " + saldo;
    }
}