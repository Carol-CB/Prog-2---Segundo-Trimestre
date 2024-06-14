package Aula1;

public class ContaBancaria {
    String titular;
    String identificador;
    String senha;
    float saldo;

    void depositar(float valor){
        saldo = saldo + valor;
    }

    boolean sacar(float valor){
        if (valor <= saldo) {
            saldo = saldo - valor;
            return true;
        }
        return false;
    }

    String verificar(){
        return String.format("Saldo: R$%.2f", saldo);
    }

    boolean validar(String identificador, String senha){
        return this.identificador.equals(identificador) && this.senha.equals(senha);
    }
}
