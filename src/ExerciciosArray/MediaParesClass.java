package ExerciciosArray;


/*

   Problema "media_pares"
   Correção: https://github.com/acenelio/curso-algoritmos/blob/master/java/media_pares.java

   Fazer um programa para ler um vetor de N números inteiros. Em seguida, mostrar na tela a média
   aritmética somente dos números pares lidos, com uma casa decimal. Se nenhum número par for
   digitado, mostrar a mensagem "NENHUM NUMERO PAR"
    */

public class MediaParesClass {

    /**
     * Recebe um vetor de inteiros, calcula a média estritamente dos números pares
     * e a retorna. Se não houver números pares, retorna -1 como sinalizador.
     */
    public double calcularMediaPares(int[] vetor) {
        int vtP = vetor.length; // vtP representa o tamanho do vetor original

        int somaPares = 0;
        int qtPares = 0; // Contador para saber por quanto vamos dividir a soma

        // Um único laço é suficiente para somar e contar ao mesmo tempo
        for (int i = 0; i < vtP; i++) {

            // Verifica se o número atual é par usando o operador de resto (%) e o '=='
            if (vetor[i] % 2 == 0) {
                somaPares += vetor[i]; // Acumula o valor do número par
                qtPares++;             // Incrementa a quantidade de números pares encontrados
            }
        }

        // Se o contador terminou em 0, significa que o usuário não digitou nenhum par
        if (qtPares == 0) {
            return -1.0; // Retorna -1 para avisar o Main que não houve pares
        }

        // Se houver pares, faz o cálculo da média.
        // Usamos o de cast '(double)' para que a divisão não corte as casas decimais.
        return (double) somaPares / qtPares;
    }
}

