package Aula20.exemploHeranca;

public class Engenheiro extends Funcionario{
    private String crea;
    public String getCrea() {
        return crea;
    }
    public void setCrea(String crea) {
        this.crea = crea;
    }

    public Engenheiro(String nome, String sobrenome, int matricula, String crea){
        super(nome, sobrenome, matricula);
        this.crea = crea;
    }
}
