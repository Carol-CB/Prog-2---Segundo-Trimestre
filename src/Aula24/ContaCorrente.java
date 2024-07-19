package Aula24;

public class ContaCorrente extends Conta {
	private float limite;

	public ContaCorrente(String titular, String senha, float limite) {
		super(titular, senha);
		this.limite = limite;
	}

	public boolean sacar(float valor) {
		if (valor <= saldo + limite) {
			saldo -= valor;
			return true;
		}
		return false;
	}

	public String verificaSaldo() {
		return "Saldo: " + saldo + "\nLimite: " + limite;
	}
}