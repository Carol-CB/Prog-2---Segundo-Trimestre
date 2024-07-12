package Aula23.ArquivoObjeto;
import java.io.*;
import java.util.Scanner;
public class EscreverObjeto {
    public static void main(String[] args) {
        File caminho = new File("C:/Users/carol/Documents/aula23_tarde");

        if(caminho.exists()){
            System.out.println("A pasta existe.");
        }
        else{
            caminho.mkdirs();
            System.out.println("Caminho criado!");
        }
        File arquivo = new File(caminho,"pessoas.db");
        System.out.println(arquivo.getAbsolutePath());
        try{
            ObjectOutputStream arquivoObj = new ObjectOutputStream(new FileOutputStream(arquivo.getAbsolutePath()));
            Pessoa[] lista = new Pessoa[10];
            Scanner ler = new Scanner(System.in);
            String opc;
            int cont =0;
            do{
                System.out.println("Lendo informações da pessoa "+(cont+1));
                System.out.println("Qual o nome?");
                String nome =ler.next();
                System.out.println("Qual o sobrenome?");
                String sobrenome =ler.next();
                lista[cont] = new Pessoa();
                lista[cont].setSobrenome(sobrenome);
                lista[cont].setNome(nome);
                System.out.print("Tem mais pessoas? ");
                opc =ler.next().toLowerCase();
                cont++;
            }while(opc.equals("s"));
            arquivoObj.writeObject(lista);
            arquivoObj.close();
        }
        catch(IOException e){
            System.out.println("Erro ao criar o arquivo.");
        }
    }
}
