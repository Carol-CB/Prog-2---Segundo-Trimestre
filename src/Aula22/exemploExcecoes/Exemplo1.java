package Aula22.exemploExcecoes;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Exemplo1 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        try {
            System.out.println("Digite um número: ");
            int n1 = ler.nextInt();
            System.out.println("Digite outro número: ");
            int n2 = ler.nextInt();
            int resultado = n1 / n2;
            System.out.println(resultado);
        }
        catch (InputMismatchException erro){
            System.out.println("N1 e N2 precisam ser números.");
        }
        catch (ArithmeticException erro){
            System.out.println("Não é possível dividir por 0.");
        }
    }
}
