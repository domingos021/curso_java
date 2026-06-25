package ExerciciosArray;

public class MaiorPosicao {

    private final double[] numeros;

    // CONSTRUTOR: Define o tamanho do vetor com barreira de segurança
    public MaiorPosicao(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.numeros = new double[quantidade];
    }

    // MÉTODO PARA POPULAR: Guarda o número bruto lido pelo Main na gaveta correta
    public void adicionarNumero(int indice, double numero) {
        this.numeros[indice] = numero;
    }

    // GETTER DE CONTROLE: Permite ao Main conhecer o limite do laço da tela
    public int getTamanho() {
        return this.numeros.length;
    }

    // MÉTODO DE PROCESSAMENTO: Encontra o maior valor guardado no vetor
    public double encontrarMaiorValor() {
        double maiorValor = numeros[0]; // Começa assumindo que a posição 0 é a maior

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maiorValor) {
                maiorValor = numeros[i]; // Atualiza o maior valor encontrado
            }
        }
        return maiorValor;
    }

    // MÉTODO DE PROCESSAMENTO: Encontra o índice (posição) do maior valor
    public int encontrarPosicaoMaior() {

        double maiorValor = numeros[0];
        int posicaoMaior = 0; // Começa assumindo que o maior está na gaveta 0

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maiorValor) {
                maiorValor = numeros[i];
                posicaoMaior = i; // Guarda o número da gaveta onde o campeão foi encontrado
            }
        }
        return posicaoMaior; // Retorna o índice (0, 1, 2...)
    }
}


  /*
       1ª Parte: Inicialização     3ª Parte: Incremento
             ┌───────┐                ┌───┐
        for (int i = 0; i < maior.getMaior(); i++)
                        └──────────────────┘
                      2ª Parte: Condição de Parada
        */
