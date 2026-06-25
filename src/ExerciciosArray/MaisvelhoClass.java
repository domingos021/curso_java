package ExerciciosArray;

public class MaisvelhoClass {
    private String[] nome;
    private int[] idade;

    // Construtor: recebe os arrays e associa aos atributos da classe
    public MaisvelhoClass(String[] nomes, int[] idades) {
        this.nome = nomes;
        setIdade(idades); // Garante que a validação de números negativos rode logo na criação
    }

    // Método para encontrar o nome da pessoa mais velha
    public String obterPessoaMaisVelha() {
        // Verifica se o vetor de idades está nulo ou se o seu tamanho é 0
        if (idade == null || idade.length == 0) {
            return "Nenhuma pessoa cadastrada.";
        }

        int maiorIdade = idade[0]; // Assume que a primeira idade é a maior inicialmente
        int indiceMaisVelho = 0;    // Guarda o índice da maior idade

        // Percorre o vetor de idade a partir da posição 1
        for (int i = 1; i < idade.length; i++) {
            // Se a idade na posição atual for maior que a 'maiorIdade' guardada
            if (idade[i] > maiorIdade) {
                maiorIdade = idade[i]; // Atualiza com o novo valor mais alto encontrado
                indiceMaisVelho = i;   // Guarda a nova posição do índice mais velho
            }
        }

        return nome[indiceMaisVelho]; // Retorna o nome que está na mesma posição do índice da maior idade
    }

    // Método focado em formatar a resposta visual para o main
    public String formatarResultado() {
        if (idade == null || idade.length == 0) {
            return "Nenhum dado para exibir.";
        }

        // Primeiro descobrimos quem é o mais velho chamando o método de lógica
        String maisVelho = obterPessoaMaisVelha();

        // Descobrimos a idade dessa pessoa para exibir no relatório
        int maiorIdade = 0;
        for (int i = 0; i < nome.length; i++) {
            // Verifica se o nome na posição 'i' é igual ao nome da pessoa mais velha
            if (nome[i].equals(maisVelho)) {
                maiorIdade = idade[i]; // Copia o valor da idade que está na mesma posição (índice)
                break; // Interrompe o laço, pois já encontrou a pessoa
            }
        }

        // Devolve o texto estruturado e elegante usando String.format
        return String.format(
                "===============================\n" +
                        "       PESSOA MAIS VELHA       \n" +
                        "===============================\n" +
                        "Nome: %s\n" +
                        "Idade: %d anos\n" +
                        "===============================",
                maisVelho,
                maiorIdade
        );
    }

    // Métodos Getters e Setters
    public String[] getNome() {
        return nome;
    }

    public int[] getIdade() {
        return idade;
    }

    public void setNome(String[] nome) {
        this.nome = nome;
    }

    // Validação, sanitização e armazenamento do vetor de idades
    public void setIdade(int[] idade) {
        for (int i = 0; i < idade.length; i++) {
            // Se o valor da idade inserido na posição atual for menor que zero (negativo)
            if (idade[i] < 0) {
                idade[i] = 0; // Substitui o valor negativo por zero (higienização de dados)
            }
        }
        this.idade = idade; // Guarda o vetor validado no atributo da classe
    }
}