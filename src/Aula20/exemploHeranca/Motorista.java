package Aula20.exemploHeranca;

public class Motorista extends Funcionario{
    private String cnh;
    public String getCnh() {
        return cnh;
    }
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public Motorista(String nome, String sobrenome, int matricula){
        super(nome, sobrenome, matricula);
    }
}
