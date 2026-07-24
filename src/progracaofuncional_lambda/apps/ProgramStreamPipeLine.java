package progracaofuncional_lambda.apps;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/*
 * ============================================================
 * STREAM PIPELINE (Fluxo de Processamento)
 * ============================================================
 *
 * O Pipeline de uma Stream é a sequência encadeada de operações
 * por onde os dados fluem, compostas por:
 *
 * 1. Fonte dos dados   (List, Array, Stream.iterate, etc.)
 * 2. Operações Intermediárias (filter, map, sorted, distinct, limit...)
 * 3. Operação Terminal (reduce, collect, toList, sum, forEach...)
 *
 * ============================================================
 * CONCEITOS CHAVE DO PIPELINE
 * ============================================================
 *
 * • Lazy Evaluation (Execução Preguiçosa):
 *   As operações intermediárias NÃO são executadas no momento em que
 *   são declaradas. Elas apenas montam a receita do pipeline.
 *   O processamento só roda quando a Operação Terminal é chamada.
 *
 * • Short-Circuit (Curto-Circuito):
 *   Operações como limit() e findFirst() podem interromper o pipeline
 *   assim que atingem a condição, sem precisar processar a fonte toda.
 *
 * • Imutabilidade:
 *   A fonte original de dados nunca é alterada ao longo do pipeline.
 */
public class ProgramStreamPipeLine {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        // Fonte de dados para os pipelines de testes
        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7, 2, 8);
        List<String> listNomes = Arrays.asList("Maria", "Domingos", "João", "Ana", "Marcos", "Teresa");

        try (Scanner sc = new Scanner(System.in)) {

            // ============================================================
            // 1. PIPELINE: FILTRAR, TRANSFORMAR E GERAR ARRAY
            // Fonte ──► filter ──► map ──► toArray (Terminal)
            // ============================================================
            System.out.println("--- 1. Pipeline: Pares multiplicados por 10 ---");

            Integer[] resultadoParesMultiplicados = list.stream()
                    .filter(x -> x % 2 == 0) // Intermediária: Filtra apenas os pares
                    .map(x -> x * 10)         // Intermediária: Multiplica cada um por 10
                    .toArray(Integer[]::new); // Terminal: Converte o fluxo em Array

            System.out.println(Arrays.toString(resultadoParesMultiplicados));


            // ============================================================
            // 2. PIPELINE: SOMA E REDUÇÃO (reduce)
            // Fonte ──► map ──► reduce (Terminal)
            // ============================================================
            System.out.println("\n--- 2. Pipeline: Acumulação e Soma (Reduce) ---");

            // Pega os elementos da lista e reduz a uma soma total
            int somaTotal = list.stream()
                    .reduce(0, (x, y) -> x + y); // Terminal: Acumulador (0 + elemento)

            System.out.println("Soma dos elementos " + list + " = " + somaTotal);


            // ============================================================
            // 3. PIPELINE: MULTIPLICAÇÃO COM REUTILIZAÇÃO DE REFERÊNCIA (Integer::sum)
            // Fonte ──► filter ──► reduce (Terminal)
            // ============================================================
            System.out.println("\n--- 3. Pipeline: Soma apenas dos números maiores que 4 ---");

            int somaMaioresQueQuatro = list.stream()
                    .filter(x -> x > 4)          // Intermediária: apenas números > 4
                    .reduce(0, Integer::sum);    // Terminal: soma usando Method Reference

            System.out.println("Soma dos números maiores que 4: " + somaMaioresQueQuatro);


            // ============================================================
            // 4. PIPELINE DE STRINGS: FILTRAGEM, MAPEAMENTO E COLETOR IMUTÁVEL
            // Fonte ──► filter ──► map ──► sorted ──► toList (Terminal)
            // ============================================================
            System.out.println("\n--- 4. Pipeline Completo de Nomes (Java 16+) ---");

            List<String> nomesProcessados = listNomes.stream()
                    .filter(nome -> nome.startsWith("M")) // Intermediária: que começam com 'M'
                    .map(String::toUpperCase)             // Intermediária: converte para maiúsculas
                    .sorted()                             // Intermediária: ordena alfabeticamente
                    .toList();                            // Terminal: coleta em lista imutável

            System.out.println("Nomes que começam com M organizados: " + nomesProcessados);


            // ============================================================
            // 5. PIPELINE DE CURTO-CIRCUITO (Short-Circuit)
            // Fonte ──► filter ──► limit ──► map ──► toList (Terminal)
            // ============================================================
            System.out.println("\n--- 5. Pipeline com Limitação de Fluxo (limit) ---");

            List<Integer> tresPrimeirosMaiores = list.stream()
                    .filter(x -> x > 3)   // Intermediária: Filtra > 3
                    .limit(3)             // Intermediária: Interrompe o fluxo após encontrar 3 itens
                    .map(x -> x * 2)      // Intermediária: Dobra o valor
                    .toList();            // Terminal: Coleta os dados

            System.out.println("3 primeiros maiores que 3 dobrados: " + tresPrimeirosMaiores);

        } catch (Exception e) {
            System.out.println("Erro durante execução: " + e.getMessage());
        }
    }
}

