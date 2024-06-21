package Aula20.exemploAcessoTres;
import java.util.Random;

public class ContaBancaria {
    private String titular;
    private String identificador;
    private String senha;
    private float saldo;
    static String nomeBanco;
    ContaBancaria(String titular, String senha, float deposito){
        this.titular = titular;
        this.senha = senha;
        saldo = deposito;
        geraIdentificador();
    }

    public String getTitular(){
        return titular;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setTitular(String titular){
        this.titular = titular;    }

    public void depositar(float valor){
        saldo = saldo + valor;
    }

    private void geraIdentificador(){
        Random aleatorio = new Random();
        String identificador ="";
        for(int i=0;i<4; i++){
            identificador+=(char)aleatorio.nextInt(65, 90);
        }
        identificador+=aleatorio.nextInt(1000, 2000);
        this.identificador = identificador;
    }

    public String getIdentificador(){
        return identificador;
    }

    public boolean sacar(float valor){
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
