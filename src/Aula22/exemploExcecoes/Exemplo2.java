package Aula22.exemploExcecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exemplo2 {
    static Scanner ler = new Scanner(System.in);
    public static int leNumero(String mensagem){
        boolean correto = false;
        int numero=0;
        do{
            try{
                System.out.println(mensagem);
                numero = ler.nextInt();
                correto = true;
            }
            catch (InputMismatchException erro) {
                System.out.println("O valor deve ser numérico");
                ler.next();
                correto = false;
            }
        }while(!correto);
        return numero;
    }

    public static void main(String[] args) {
        int n1 = leNumero("Digite um número: ");
        int n2 = leNumero("Digite outro número: ");
    }
}
