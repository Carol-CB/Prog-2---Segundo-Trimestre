package Aula20.exemploAcessoTres;


public class Principal {
    public static void main(String[] args){
        ContaBancaria c1 = new ContaBancaria("Ana", "123", 10);
        System.out.println("Conta cadastrada com ID: "+c1.getIdentificador());
        ContaBancaria c2 = new ContaBancaria("Zé", "321", 100);
        System.out.println("Conta cadastrada com ID: "+c2.getIdentificador());

        c1.depositar(100);
        c1.sacar(10);
        System.out.println(c1.verificar());
    }
}
