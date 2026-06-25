package ExerciciosArray;

import java.util.Locale;
import java.util.Scanner;

/*
    Faça um programa que leia um número inteiro positivo N (máximo = 10)
     e depois N números inteiros e armazene-os em um vetor.
     Em seguida, mostrar na tela todos os números negativos lidos.
 */
public class Main01 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int N = sc.nextInt();

        int tentativas = 0;
        while ((N <= 0 || N > 10) && (tentativas < 2)) {
            System.out.println(" Digite um numero entre 1 e 10 ");
            N = sc.nextInt();
            tentativas++;
        }

        if (N <= 0 || N > 10) {
            System.out.println("Sistema encerrado por excesso de tentativas");
        } else {
            int[] vetor = new int[N];
            for (int i = 0; i < vetor.length; i++) {
                System.out.print("Digite um numero: ");
                vetor[i] = sc.nextInt();
                System.out.printf("Posição [%d] recebe:[%d]%n", i, vetor[i]);
            }

            System.out.println("\nNUMEROS NEGATIVOS/POSITIVOS:");
            //numeros negativos
            //percorre o vetor inteiro
            for (int i = 0; i < vetor.length; i++) {
                //seleciona apenas os indices ou as posições que contem números negativos
                // forem encontrados
                if (vetor[i] < 0) {
                    //exibe eles
                    System.out.printf(
                            "Negativo: %d%n", vetor[i]
                    );
                } else {
                    System.out.printf(
                            "Positivo: %d%n", vetor[i]
                    );
                }
            }

        }
        sc.close();
    }
}