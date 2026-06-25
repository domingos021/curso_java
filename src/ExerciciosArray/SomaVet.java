package ExerciciosArray;
public class SomaVet {

    /**
     * Recebe dois vetores e retorna um novo vetor com a soma correspondente.
     */
    public double[] somarVetores(double[] vetA, double[] vetB) {
        int N = vetA.length;
        double[] vetC = new double[N]; // VetC e definido com o mesmo tamanho do vetA

        for (int i = 0; i < N; i++) {
            vetC[i] = vetA[i] + vetB[i]; //nesse ele não pega os resultado da 1ª-posição para somar com 2º, a soma acontece de forma independente de acordo com i indice
        }

        return vetC;
    }
}

/*
1ª-14
2ª- 18
3º-13
 */
