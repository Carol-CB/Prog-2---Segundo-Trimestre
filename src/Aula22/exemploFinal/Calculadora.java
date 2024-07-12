package Aula22.exemploFinal;

public class Calculadora {
    public static void main(String[] args){
        Operacoes op = new Operacoes();
        //não pode ser alterado o valor do atributo pq ele é final
        //op.valor = 100
        System.out.println(Operacoes.PI);
    }
}
