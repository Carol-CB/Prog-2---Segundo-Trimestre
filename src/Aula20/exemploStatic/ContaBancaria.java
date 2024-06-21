package Aula20.exemploStatic;
import java.util.Random;
public class ContaBancaria {
    String titular;
    String identificador;
    String senha;
    float saldo;

    static String nomeBanco;
    ContaBancaria(String titular, String senha, float deposito){
        this.titular = titular;
        this.senha = senha;
        saldo = deposito;
        geraIdentificador();
    }

    void depositar(float valor){
        saldo = saldo + valor;
    }

    void geraIdentificador(){
        Random aleatorio = new Random();
        String identificador ="";
        for(int i=0;i<4; i++){
            identificador+=(char)aleatorio.nextInt(65, 90);
        }
        identificador+=aleatorio.nextInt(1000, 2000);
        this.identificador = identificador;
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
