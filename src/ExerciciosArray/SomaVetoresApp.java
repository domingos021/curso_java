package ExerciciosArray;

import java.util.Locale;
import java.util.Scanner;

public class SomaVetoresApp {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Instancia a classe de processamento
        SomaVet somaVet = new SomaVet();

        System.out.print("Quantos valores vai ter cada vetor? ");
        int N = sc.nextInt();

        double[] vetA = new double[N]; //n=> define o tamanho do vetor
        double[] vetB = new double[N];

        System.out.println("Digite os valores do vetor A:");
        //o laço percorre enquano o indice for menor que o tamanho do vetorA
        // se o tamanho for 5, o laço vai exigir a incerção de 5 valor para cada espaço no vetor
        for (int i = 0; i < vetA.length; i++) {
            vetA[i] = sc.nextDouble();
        }

        System.out.println("Digite os valores do vetor B:");
        for (int i = 0; i < vetB.length; i++) {
            vetB[i] = sc.nextDouble();
        }

        // O Main delega o processamento para a classe responsável
        /*
         1ª-o metodo (somarVetores) dentro da class Somavet recebe os valores do vetA e vetB via parametro
         2ª- processa o calculo
         3- e devolve o resultado para o vetC
         */
        double[] vetC = somaVet.somarVetores(vetA, vetB);

        // Exibe o resultado
        System.out.println("VETOR RESULTANTE:");
      /*
        1º - O método somarVetores recebe os vetores A e B por parâmetro.

        2º - O método cria um novo vetor C.

        3º - O método soma os elementos de mesma posição dos vetores A e B.

        4º - O vetor C é retornado para o Main.

        5º - O Main recebe esse retorno e armazena em vetC.
      */
        for (int i = 0; i < vetC.length; i++) {
            System.out.println(vetC[i]);
        }

        sc.close();
    }
}

    /*
    MAIN
     │
             │ envia vetA e vetB
     ▼
    somarVetores(vetA, vetB)
     │
             │ cria vetC
     │ soma os elementos
     ▼
    retorna vetC
     │
             ▼
    MAIN recebe o retorno

     */
