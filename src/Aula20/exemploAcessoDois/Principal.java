package Aula20.exemploAcessoDois;

import Aula20.exemploAcesso.Pessoa;

public class Principal {
    public static void main(String[] args){
        Pessoa p1 = new Pessoa();
        p1.sobrenome = "Silva";
        //p1.nome = "Silva"; não funciona pela permissão
    }
}
