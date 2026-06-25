package MatrizesExercicios;

import java.util.Locale;
import java.util.Scanner;

public class matApp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o tamanho da linha: ");
        int M = sc.nextInt();

        System.out.print("Digite o tamanho da Coluna: ");
        int N = sc.nextInt();

        // Matriz bidimensional (Tabela alocada na memória Heap)
        int[][] matz = new int[M][N];

        System.out.println("\n--- Digite os valores da matriz ---");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < matz[i].length; j++) {
                System.out.printf("Posição [%d][%d]: ", i, j);
                matz[i][j] = sc.nextInt();
            }
        }

        // --- Lógica para exibir a matriz na tela em formato de grade ---
        System.out.println("\n--- Matriz Digitada ---");
        for (int i = 0; i < M; i++) {

            // mat[i].length: Descobre dinamicamente o tamanho exato da linha atual (andar)
            for (int j = 0; j < matz[i].length; j++) {
                System.out.print(matz[i][j] + "   "); // Imprime os apartamentos lado a lado no mesmo andar
            }

            // CORREÇÃO CIRÚRGICA: Quando o 'j' termina de passar por todas as colunas daquele andar,
            // nós mandamos o console pular para a linha de baixo antes que o 'i' mude para o próximo andar.
            System.out.println();
        }

        System.out.println();
        System.out.print("Digite o número X que deseja procurar na matriz: ");
        int x = sc.nextInt();

        /*
        ===================================================================================================
           LÓGICA DE NAVEGAÇÃO ESPACIAL: ENCONTRANDO OS VIZINHOS NO PRÉDIO
        ===================================================================================================
        Imagine que encontramos o número X no ANDAR 'i' e no APARTAMENTO 'j'.
        Para encontrar os vizinhos ao redor dele, basta mover as coordenadas de forma cirúrgica:

           - ESQUERDA : Mesmo andar (i), retrocede um apartamento   -> matz[i][j - 1]
           - DIREITA  : Mesmo andar (i), avança um apartamento      -> matz[i][j + 1]
           - CIMA     : Sob para o andar superior (i - 1), mesmo prumo -> matz[i - 1][j]
           - BAIXO    : Desce para o andar inferior (i + 1), mesmo prumo -> matz[i + 1][j]

        ---------------------------------------------------------------------------------------------------
        TRAVAS DE SEGURANÇA (CÓDIGO DEFENSIVO CONTRA BORDAS):
        ---------------------------------------------------------------------------------------------------
        Se o número X morar na cobertura (Andar 0), não podemos olhar para CIMA (i-1 não existe).
        Se morar no térreo, não podemos olhar para BAIXO. Se for a primeira porta, não há ESQUERDA.
        Por isso, cada 'if' abaixo garante que o Java só olhe para o vizinho se a coordenada existir!
        ===================================================================================================
        */
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < matz[i].length; j++) {

                // Encontramos uma ocorrência de X!
                if (matz[i][j] == x) {
                    System.out.println("\nOcorrência de " + x + " na posição [" + i + "][" + j + "]:");

                    // ESQUERDA: Só existe se o apartamento 'j' não for o primeiro (j > 0)
                    if (j > 0) {
                        System.out.println("Esquerda: " + matz[i][j - 1]);
                    }

                    // CIMA: Só existe se o andar 'i' não for o mais alto (i > 0)
                    if (i > 0) {
                        System.out.println("Cima: " + matz[i - 1][j]);
                    }

                    // DIREITA: Só existe se o próximo 'j' estiver dentro do limite da linha (j < colunas - 1)
                    if (j < matz[i].length - 1) {
                        System.out.println("Direita: " + matz[i][j + 1]);
                    }

                    // BAIXO: Só existe se o próximo andar 'i + 1' for menor que o total de linhas M (i < M - 1)
                    if (i < M - 1) {
                        System.out.println("Baixo: " + matz[i + 1][j]);
                    }
                }

            }
        }

        sc.close();
    }
}