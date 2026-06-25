package ExerciciosArray;

import java.util.Locale;
import java.util.Scanner;

/*
   Faça um programa que leia N números reais e armazene-os
   em um vetor. Em seguida: - Imprimir todos os elementos do vetor -
    Mostrar na tela a soma e a média dos elementos do vetor
 */
public class Main02 {
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
            double[] vetor = new double[N];
            double soma = 0.0;
            for (int i = 0; i < vetor.length; i++) {
                System.out.print("Digite um numero: ");
                vetor[i] = sc.nextDouble();
                 soma += vetor[i]; // ja soma enquanto lé
                System.out.printf("Posição [%d] recebe:[%.2f]%n", i, vetor[i]);
            }

            // Adicionado %n no final para pular a linha antes de listar os números
            System.out.printf("=================NUMEROS DIGITADOS===========%n");
            for (int i = 0; i < vetor.length; i++) {
                //Listagem
                System.out.printf("%.2f%n", vetor[i]);
            }

            System.out.println("\nSOMA/MEDIA:");
            double media;
            media = soma / vetor.length; // tamanho do veto, valor de (N)
            System.out.printf("SOMA = %.2f%n", soma);
            System.out.printf("MEDIA = %.2f%n", media);

        }
        sc.close();
    }
}