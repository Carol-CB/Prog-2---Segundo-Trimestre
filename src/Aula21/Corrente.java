package Aula21;

public class Corrente extends Conta{
    public float getLimite() {
        return limite;
    }

    private float limite;

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public Corrente(String titular, String senha, float limite){
        super(titular, senha);
        this.limite = limite;
    }

    public boolean sacar(float valor){
        if (valor <= saldo+limite) {
            saldo = saldo - valor;
            return true;
        }
        return false;
    }

    public String verificar(){
        if(saldo>=0){
            return String.format("Saldo: R$%.2f\n Limite: R$%.2f", saldo, limite);
        }
        else {
            return String.format("Saldo: R$%.2f\n Limite: R$%.2f", saldo, limite + saldo);
        }
    }
}
