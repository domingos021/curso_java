package EnumeracaoComposicao.composicao.exercicio.entities;

public class Department {
    private String name;

    public Department() {
       //construtor padrão
    }

    //construtor com argumentos
    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
