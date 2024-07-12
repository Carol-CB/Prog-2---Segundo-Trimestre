package Aula22.exemploPolimorfismo;

public class Aluno extends Pessoa{
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    private String matricula;

    @Override
    public String obterDados(){
        return "Nome: "+getNome()+" Sobrenome: "+getSobrenome()+" Matrícula: "+matricula;
    }

    @Override
    public String toString(){
        return "Nome: "+getNome()+" Sobrenome: "+getSobrenome()+" Matrícula: "+matricula;
    }
}
