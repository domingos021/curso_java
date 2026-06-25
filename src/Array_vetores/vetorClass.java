package Array_vetores;

public class vetorClass {
    private final String nome;
    private final double altura;

    // Construtor para instanciar a pessoa com nome e altura
    public vetorClass(String nome, double altura) {
        this.nome = nome;
        this.altura = altura;
    }

    // Getters para acessar os dados na hora de calcular a média
    public String getNome() {
        return nome;
    }

    public double getAltura() {
        return altura;
    }

    // Esse método serve para o Arrays.toString() imprimir bonito, e não um código estranho
    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', altura=" + altura + "}";
    }
}