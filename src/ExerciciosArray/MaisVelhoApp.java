package ExerciciosArray;

import java.util.Locale;
import java.util.Scanner;
    /*
    Problema "mais_velho"
    Correção: https://github.com/acenelio/curso-algoritmos/blob/master/java/mais_velho.java

    Fazer um programa para ler um conjunto de nomes de pessoas e suas respectivas idades. Os nomes
    devem ser armazenados em um vetor, e as idades em um outro vetor. Depois, mostrar na tela o nome
    da pessoa mais velha.
 */
public class MaisVelhoApp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("Quantas pessoas voce vai digitar? ");
        int N = sc.nextInt();

        String[] nomes = new String[N];
        int[] idades = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.printf("Digite os dados da %dº pessoa: ",i + 1);
            System.out.println("Nome: ");
            nomes[i] = sc.next();
            System.out.println("Idade: ");
            idades[i] = sc.nextInt();
        }
        // Instancia a sua classe passando os dados

        MaisvelhoClass mv = new MaisvelhoClass(nomes,idades);


        System.out.println(mv.formatarResultado());
        sc.close();
    }
}
