package Aula20.exemploStatic;

import java.sql.SQLOutput;

public class Principal {
    public static void main(String[] args){
        ContaBancaria c1 = new ContaBancaria("Ana", "123", 10);
        System.out.println("Conta cadastrada com ID: "+c1.identificador);
        ContaBancaria c2 = new ContaBancaria("Zé", "321", 100);
        System.out.println("Conta cadastrada com ID: "+c2.identificador);

        c1.nomeBanco="Banco Cimol";
        System.out.println("Nome do banco c1 "+c1.nomeBanco);
        System.out.println("Nome do banco c2 "+c2.nomeBanco);

        ContaBancaria.nomeBanco = "Teste";
        System.out.println("Nome do banco c1 "+c1.nomeBanco);
        System.out.println("Nome do banco c2 "+c2.nomeBanco);
    }
}
