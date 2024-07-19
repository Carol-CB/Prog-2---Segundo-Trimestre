package Aula24;

import java.io.Serializable;
import java.util.Random;

public class Conta implements Serializable {
    private String titular;
    private String identificador;
    private String senha;
    protected float saldo;

    public Conta(String titular, String senha) {
        this.titular = titular;
        this.senha = senha;
        geraIdentificador();
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void depositar(float valor) {
        saldo += valor;
    }

    private void geraIdentificador() {
        StringBuilder id = new StringBuilder();
        Random aleatorio = new Random();
        for (int i = 0; i < 4; i++) {
            id.append((char) aleatorio.nextInt(65, 90));
        }
        id.append(aleatorio.nextInt(1000, 2000));
        identificador = id.toString();
    }

    public boolean validaAcesso(String identificador, String senha) {
        return this.identificador.equals(identificador) && this.senha.equals(senha);
    }
}