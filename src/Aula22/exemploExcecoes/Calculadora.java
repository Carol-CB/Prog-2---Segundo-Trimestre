package Aula22.exemploExcecoes;

public class Calculadora {
    public static void main(String[] args) {
        Operacoes op = new Operacoes();
        try{
            System.out.println(op.divide(5,0));
        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
    }
}