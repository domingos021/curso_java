package progracaofuncional_lambda.apps;

import java.util.*;
import java.util.stream.Stream;

/*
 * ============================================================
 * STREAM (Java 8+)
 * ============================================================
 *
 * Stream é uma sequência de elementos obtida de uma fonte de dados
 * que oferece suporte a operações agregadas (como filter, map,
 * reduce, sorted, etc.).
 *
 * Fontes de dados:
 * - Collections (List, Set, Map...)
 * - Arrays
 * - Funções de geração ou iteração (Stream.iterate, Stream.generate)
 * - Recursos de Entrada/Saída (I/O), como arquivos
 *
 * ============================================================
 * CARACTERÍSTICAS
 * ============================================================
 *
 * • Declarativa       : Foco no "O QUE" fazer, não no "COMO".
 * • Parallel-friendly : Fácil transição para processamento paralelo via .parallelStream().
 * • Sem Side-Effects  : Evita mutação de variáveis externas durante o pipeline.
 * • Lazy Evaluation   : Avaliação sob demanda (só executa ao chamar operação terminal).
 * • Single Use        : Uma Stream só pode ser consumida UMA única vez.
 *
 * ============================================================
 * PIPELINE (Fluxo de processamento)
 * ============================================================
 *
 * Fonte de dados ──► .stream() ──► Operações Intermediárias ──► Operação Terminal
 */
public class ProgramStream {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        // Fontes de Dados (Listas base)
        List<Integer> listStream = Arrays.asList(3, 4, 5, 10);
        List<String> listStream02 = Arrays.asList("Maria", "Domingos", "João", "Ana");

        try (Scanner sc = new Scanner(System.in)) {

            // ============================================================
            // 1. STREAM DE INTEIROS (Transformação simples)
            // ============================================================
            System.out.println("--- 1. Stream de Inteiros (x * 10) ---");
            Stream<Integer> st1 = listStream.stream()
                    .map(x -> x * 10);

            // Operação terminal toArray()
            System.out.println(Arrays.toString(st1.toArray()));


            // ============================================================
            // 2. STREAM DE STRINGS (Method Reference & forEach)
            // ============================================================
            System.out.println("\n--- 2. Stream de Strings (toUpperCase) ---");
            Stream<String> st2 = listStream02.stream()
                    .map(String::toUpperCase);

            // Operação terminal forEach()
            st2.forEach(System.out::println);


            // ============================================================
            // 3. GENERATIONS & ITERATION (Stream.iterate)
            // ============================================================
            System.out.println("\n--- 3. Sequência Matemática (Multiplos de 4) ---");
            Stream<Integer> sitr = Stream.iterate(1, x -> x + 1)
                    .limit(10)
                    .map(x -> x * 4);

            System.out.println(Arrays.toString(sitr.toArray()));

            System.out.println("\n--- 4. Números Pares ---");
            Stream<Integer> st3 = Stream.iterate(0, y -> y + 2);
            System.out.println(Arrays.toString(st3.limit(10).toArray()));


            // ============================================================
            // 4. FIBONACCI COM STREAM (Algoritmo Avançado)
            // ============================================================
            System.out.println("\n--- 5. Sequência de Fibonacci (20 primeiros) ---");
            Stream<Long> fibonacci = Stream.iterate(
                            new Long[]{0L, 1L},
                            p -> new Long[]{p[1], p[0] + p[1]}
                    )
                    .map(p -> p[0]);

            System.out.println(Arrays.toString(fibonacci.limit(20).toArray()));


            // ============================================================
            // 5. DEMONSTRAÇÃO COMPLETA: PIPELINE COMPLETO (Filter, Map, Reduce, toList)
            // ============================================================
            System.out.println("\n--- 6. Pipeline Completo: Filtrar Nomes > 3 letras, Ordenar e Coletar ---");

            // Exemplo moderno usando toList() do Java 16+
            List<String> nomesFiltrados = listStream02.stream()
                    .filter(nome -> nome.length() > 3) // Operação Intermediária 1
                    .map(String::toUpperCase)          // Operação Intermediária 2
                    .sorted()                          // Operação Intermediária 3
                    .toList();                         // Operação Terminal (Java 16+)

            System.out.println("Nomes processados: " + nomesFiltrados);


            System.out.println("\n--- 7. Operação Terminal: REDUCE (Soma de Elementos) ---");
            // Reduce: pega o valor inicial (0) e acumula somando elemento por elemento
            int somaTotal = listStream.stream()
                    .reduce(0, Integer::sum);

            System.out.println("Soma de " + listStream + " = " + somaTotal);

        } catch (Exception e) {
            System.out.println("Erro durante execução: " + e.getMessage());
        }
    }
}