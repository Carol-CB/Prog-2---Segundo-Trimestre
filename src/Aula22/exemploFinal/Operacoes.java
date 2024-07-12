package Aula22.exemploFinal;

public class Operacoes {
    //atributos com o modificador final precisam ser inicializados, caso não sejam, a inicialização deve ocorrer até o final do construtor
    final double valor;

    //para criar uma constante ela deve ser estática e final ao mesmo tempo
    //ACESSO GLOBAL -> PUBLIC
    //disponível diretamente na classe -> static
    //inalterável -> final
    public static final double PI = 3.141592653589793;
    public Operacoes(){
        valor = 10;
    }
}
