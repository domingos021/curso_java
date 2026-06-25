package ExerciciosArray;

public class PensionatoService {

    // LINHA 1: DECLARAÇÃO DO VETOR (Apenas cria a etiqueta/ponteiro na classe)
    // Aqui avisamos ao Java: "Existirá um vetor de RentClass chamado vector, mas ele ainda não existe na Heap".
    // Valor atual na memória: null
    private RentClass[] vector;

    // CONSTRUTOR: Criado para dar vida ao vetor na memória Heap de forma separada
    public PensionatoService() {
        // LINHA 2: INICIALIZAÇÃO  com 10 posições no VETOR (Alocação real da memória Heap)
        this.vector = new RentClass[10];
    }

    /**
     * Tenta registrar um aluguel no quarto especificado.
     * @return true se o quarto for válido e registrado, false caso contrário.
     */
    public boolean registrarAluguel(int roomNumber, String name, String email) {
        if (roomNumber <= 0 || roomNumber > 10) {
            return false; // Quarto inválido
        }

        // LINHA 1: Instancia a classe e cria o objeto na memória Heap
        RentClass rent = new RentClass(name, email);

        // LINHA 2: Guarda a referência desse objeto na posição do vetor
        this.vector[roomNumber - 1] = rent;

        //duas linhas (vetor e rentClass juntas em uma unica linha)
        // this.vector[roomNumber - 1] = new RentClass(name, email);

        return true;
    }

    /**
     * Imprime no console apenas os quartos que não estão vazios.
     */
    public void exibirQuartosOcupados() {
        System.out.println();
        System.out.println("Quartos ocupados?: ");
        for (int i = 0; i < 10; i++) {
            if (vector[i] != null) {
                System.out.println(i + " : " + vector[i]);
            }
        }
    }
}