package ExerciciosListas;

public class Funcionario {


    // Atributos privados (Encapsulamento)
    private Integer id;
    private String nome;
    private Double salario;


    // Construtor
    public Funcionario(Integer id, String nome, Double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    // Getters e Setters (Apenas o necessário)
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getSalario() {
        return salario;
    }

    // Método solicitado para alterar o salário de forma controlada
    public void aumentarSalario(double percentual) {
        this.salario += this.salario * percentual / 100.0;
    }

    // Facilitador para imprimir os dados do funcionário
    @Override
    public String toString() {
        return id + ", " + nome + ", " + String.format("%.2f", salario);
    }
}
