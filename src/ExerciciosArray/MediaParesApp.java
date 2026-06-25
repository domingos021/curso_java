package ExerciciosArray;

import java.util.Locale;
import java.util.Scanner;

public class MediaParesApp {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        MediaParesClass mpc = new MediaParesClass();

        System.out.print("Quantos elementos vai ter o vetor? ");
        int n = sc.nextInt();

        int[] vetor = new int[n];

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite um numero: ");
            vetor[i] = sc.nextInt();
        }

        // Chama o método de processamento
        double mediaResultante = mpc.calcularMediaPares(vetor);

        // O Main analisa o resultado retornado pelo método
        if (mediaResultante == -1.0) {
            System.out.println("NENHUM NUMERO PAR");
        } else {
            System.out.printf("MEDIA DOS PARES = %.1f%n", mediaResultante);
        }

        sc.close();
    }
}