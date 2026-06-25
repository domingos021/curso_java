package ExerciciosArray;

import java.util.Locale;
import java.util.Scanner;

public class AbaixoMediaVetApp {

    public static void main(String[] args) {
        AbaixoMediaVet vet = new AbaixoMediaVet();
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos elementos vai ter o vetor? ");
        int N = sc.nextInt();

        double[] vetor = new double[N];

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite um numero: ");
            vetor[i] = sc.nextDouble();
        }

        // O método calcula, mostra a média e nos devolve o vetor filtrado
        double[] resultado = vet.abaixoMedia(vetor);

        // Imprime os elementos do vetor retornado
        System.out.println("ELEMENTOS ABAIXO DA MEDIA:");
        for (int i = 0; i < resultado.length; i++) {
            System.out.printf("%.1f%n", resultado[i]);
        }

        sc.close();
    }
}


    /*
    [ Classe AbaixoMediaVetApp (main) ]               [ Classe AbaixoMediaVet ]
                    |                                             |
                    | 1. Lê os dados do teclado                   |
                    |                                             |
                    | 2. Executa a linha:                         |
                    |    vet.abaixoMedia(vetor) ----------------> | (O main "pausa" e passa o controle)
                    |                                             | 3. Calcula a soma e a média
                    |                                             |
                    |                                             | 4. IMPRIME A MÉDIA NO CONSOLE!
                    |                                             |    (System.out.printf... roda aqui)
                    |                                             |
                    |                                             | 5. Filtra e cria o novo vetor
                    |                                             |
                    |    <--------------------------------------- | 6. Dá o 'return resultado;'
                    |                                             | (O método termina e devolve o controle)
                    | 7. Recebe o vetor filtrado                  |
                    |    na variável 'resultado'                  |
                    |                                             |
                    | 8. IMPRIME OS ELEMENTOS                     |
                    |    ABAIXO DA MÉDIA                          |
                    v                                             v
     */

