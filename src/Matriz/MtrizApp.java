package Matriz;

import java.util.Locale;
import java.util.Scanner;

public class MtrizApp {
    public static void main(String[] args) {

        /*
        ===================================================================================================
           ANALOGIA DO PRÉDIO DE APARTAMENTOS: ENTENDENDO MATRIZES DE UMA VEZ POR TODAS
        ===================================================================================================
        Se tentarmos entender matrizes olhando apenas para a sintaxe, a mente dá um nó.
        Para clarear, pense em uma MATRIZ como um PRÉDIO DE APARTAMENTOS.

        - Um VETOR é uma rua com casas térreas (você só precisa de UMA informação para achar a casa: o número).
        - Uma MATRIZ é um prédio (você precisa OBRIGATORIAMENTE de DUAS informações: o Andar e o Apartamento).

        O computador está fazendo exatamente a mesma coisa que você faria limpando as janelas desse prédio:

           1. O 'i' escolhe o ANDAR (A Linha da Matriz).
           2. O 'j' visita cada APARTAMENTO daquele andar (A Coluna da Matriz).

        Quando o 'j' chega ao fim (ou seja, você limpou todos os apartamentos daquele andar), o loop
        de dentro "quebra". O código então volta para o loop do 'i', o 'i' aumenta (você sobe de andar)
        e o 'j' nasce de novo valendo 0 para limpar o próximo andar do início.

        ---------------------------------------------------------------------------------------------------
        MAPA VISUAL DO PRÉDIO NA MEMÓRIA:
        ---------------------------------------------------------------------------------------------------
                           A p a r t a m e n t o s  ( Colunas 'j' )
                           Ap. 0          Ap. 1          Ap. 2
                       ┌──────────────┬──────────────┬──────────────┐
          ANDAR 2 (i=2)│  mat[2][0]   │  mat[2][1]   │  mat[2][2]   │  <-- j varia de 0 a 2 aqui
                       ├──────────────┼──────────────┼──────────────┤
          ANDAR 1 (i=1)│  mat[1][0]   │  mat[1][1]   │  mat[1][2]   │  <-- j varia de 0 a 2 aqui
                       ├──────────────┼──────────────┼──────────────┤
          ANDAR 0 (i=0)│  mat[0][0]   │  mat[0][1]   │  mat[0][2]   │  <-- j varia de 0 a 2 aqui
                       └──────────────┴──────────────┴──────────────┘
        ===================================================================================================
        */

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas Linhas da matriz?: ");
        int linha = sc.nextInt();

        System.out.print("Quantas colunas da matriz?: ");
        int colunas = sc.nextInt();

        // Matriz bidimensional (Tabela alocada na memória Heap)
        int[][] mat = new int[linha][colunas];

        System.out.println("\n--- Digite os valores da matriz ---");

        /*
        ===================================================================================================
           RASTREIO DO FLUXOGRAMA DOS LOOPS ANINHADOS
        ===================================================================================================
        O loop de dentro ('j') roda TODAS as vezes dele para cada ÚNICA vez que o loop de fora ('i') roda.
        Multiplicação de Eixos: 3 iterações de 'i' × 3 iterações de 'j' = 9 execuções totais (Matriz 3x3).
        ===================================================================================================
        */
        for (int i = 0; i < linha; i++) {       // <── Aqui você escolhe o ANDAR (i)
            for (int j = 0; j < colunas; j++) { // <── Aqui você caminha pelos APARTAMENTOS (j)
                System.out.printf("Elemento [%d][%d]: ", i, j);
                mat[i][j] = sc.nextInt();       // Aqui faz a leitura e guarda na coordenada/apartamento exato
            }
        }

        // --- Lógica para exibir a matriz na tela em formato de grade ---
        // --- Lógica para exibir a matriz na tela em formato de grade ---
        System.out.println("\n--- Matriz Digitada ---");
        for (int i = 0; i < linha; i++) {

            // mat[i].length: Descobre dinamicamente o tamanho exato da linha atual (andar)
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + "   "); // Imprime os apartamentos lado a lado no mesmo andar
            }

            System.out.println(); // Quebra a linha do console ao terminar o andar para descer ao próximo andar
        }

        /*
        ===================================================================================================
           LÓGICA DE FILTRAGEM: CONTADOR DE NÚMEROS NEGATIVOS
        ===================================================================================================
        Aqui reaplicamos os dois laços aninhados para vistoriar cada posição da matriz.
        A estrutura condicional 'if (mat[i][j] < 0)' analisa o valor armazenado na coordenada atual.
        Se o valor for negativo, incrementamos o nosso acumulador ('count++').
        ===================================================================================================
        */
        int count = 0;
        for (int i = 0; i < mat.length; i++) {//linha
            for (int j = 0; j < mat.length; j++) { //coluna
                if (mat[i][j] < 0) {
                    count++;
                }
            }
        }

        System.out.println();
        if (count == 0) {
            System.out.println("Sem números negativos");
        } else {
            System.out.println("Quantidade de negativos: " + count);
        }

        /*
        ===================================================================================================
           TRAVA DE SEGURANÇA: VALIDAÇÃO DE MATRIZ QUADRADA E DIAGONAL PRINCIPAL
        ===================================================================================================
        A diagonal principal é um conceito puramente matemático de matrizes QUADRADAS (NxN), onde
        a regra dita que o índice da Linha deve ser IGUAL ao índice da Coluna (i == j).

        O 'if (linha == colunas)' funciona como um escudo (Código Defensivo):
        - Se SIM (Quadrada): O sistema roda o laço linear 'mat[i][i]' com segurança total.
        - Se NÃO (Retangular): O bloco 'else' intercepta a execução, impedindo que o Java estoure
          um erro de 'ArrayIndexOutOfBoundsException' caso tentássemos acessar coordenadas inválidas.
        ===================================================================================================
        */
        if (linha == colunas) {
            System.out.println("\nDiagonal Principal:");
            for (int i = 0; i < linha; i++) {
                System.out.print(mat[i][i] + " ");
            }
            System.out.println();
        } else {
            System.out.println(
                    "\nA matriz não é quadrada. Não existe diagonal principal completa."
            );
        }

        sc.close();
    }
}