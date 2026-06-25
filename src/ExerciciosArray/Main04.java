package ExerciciosArray;

import java.util.Locale;
import java.util.Scanner;

public class Main04 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar: ");
        int N = sc.nextInt();

        // Validação preventiva de tentativas (limite entre 1 e 10)
        int count = 0;
        while ((N <= 0 || N > 10) && (count < 2)) {
            System.out.println("Digite um numero entre 1 e 10");
            N = sc.nextInt();
            count++;
        }

        if (N <= 0 || N > 10) {
            System.out.println("Sistema encerrado por excesso de tentativas.");
        } else {
            // 1. Criação e preenchimento do vetor
            double[] vetor = new double[N];

            for (int i = 0; i < vetor.length; i++) {
                System.out.print("Digite um numero: ");
                vetor[i] = sc.nextDouble();
            }

            // 2. Lógica para encontrar o maior valor e a sua respectiva posição
            double maiorValor = vetor[0]; // Assume que o primeiro elemento é o maior
            int posicaoMaior = 0;         // Guarda o índice do maior elemento

            for (int i = 1; i < vetor.length; i++) {
                if (vetor[i] > maiorValor) {
                    maiorValor = vetor[i];
                    posicaoMaior = i; // Atualiza a posição (índice iniciando em 0)
                }
            }

            // 3. Exibição dos resultados conforme o enunciado
            System.out.printf("%nMAIOR VALOR = %.1f%n", maiorValor);
            System.out.println("POSICAO DO MAIOR VALOR = " + posicaoMaior);
        }

        sc.close();
    }
}