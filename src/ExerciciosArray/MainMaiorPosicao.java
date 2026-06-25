package ExerciciosArray;

import java.util.Locale;
import java.util.Scanner;

public class MainMaiorPosicao {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int n = sc.nextInt();

        // Criação do objeto gerenciador passando a quantidade segura
        MaiorPosicao maiorPosicao = new MaiorPosicao(n);

        // FOR DE INTERAÇÃO: Coleta os números do teclado e manda para a classe popular
        for (int i = 0; i < maiorPosicao.getTamanho(); i++) {
            System.out.print("Digite um numero: ");
            double number = sc.nextDouble();

            // Entrega o dado bruto e o índice para o objeto gerenciar
            maiorPosicao.adicionarNumero(i, number);
        }

        System.out.println();

        // EXIBIÇÃO: O Main delega o processamento para os métodos inteligentes e apenas mostra os resultados
        System.out.printf("MAIOR VALOR = %.1f%n", maiorPosicao.encontrarMaiorValor());
        System.out.printf("POSICAO DO MAIOR VALOR = %d%n", maiorPosicao.encontrarPosicaoMaior());

        sc.close();
    }
}