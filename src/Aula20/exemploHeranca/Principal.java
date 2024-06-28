package Aula20.exemploHeranca;
public class Principal {
    public static void main(String[] args) {
        Motorista m1 = new Motorista("João", "Silva", 123);
        /*Motorista m1 = new Motorista();
        m1.setNome("João");
        m1.setSobrenome("Silva");
        m1.setMatricula(123);*/
        m1.setSalario(1200);
        m1.setCnh("27382634");
        System.out.println("Nome do motorista: "+m1.getNome()+" "+m1.getSobrenome());
        System.out.println("Recebe "+String.format("%.2f",m1.getSalario()));

        Engenheiro e1 = new Engenheiro("Zé", "Sousa", 321, "223322324");
        /*Engenheiro e1 = new Engenheiro();
        e1.setNome("Zé");
        e1.setSobrenome("Sousa");
        e1.setMatricula(321);*/
        e1.setSalario(2500);
        e1.setCrea("235262");
        System.out.println("Nome do engenheiro: "+e1.getNome()+" "+e1.getSobrenome());
        System.out.println("Recebe "+String.format("%.2f",e1.getSalario()));
    }
}