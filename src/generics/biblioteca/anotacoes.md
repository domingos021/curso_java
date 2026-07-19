/*
* ============================================================
* BIBLIOTECA DE REFERÊNCIA: LIST vs SET
* ============================================================
*
* Este código serve como material de consulta completo sobre
* as estruturas List e Set, com exemplos práticos e executáveis.
*
* Autor: Assistente de Programação
* Versão: 1.1 (Completa e Corrigida)
  */

package generics.biblioteca;

import java.util.*;

public class ListVsSetBiblioteca {

    public static void main(String[] args) {
        demonstrarList();
        demonstrarSet();
        compararPerformance();
        casosDeUsoPraticos();
        resumoFinal();
    }

    // ============================================================
    // DEMONSTRAÇÃO COMPLETA DE LIST
    // ============================================================

    public static void demonstrarList() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("📋 OPERAÇÕES COMPLETAS COM LIST");
        System.out.println("=".repeat(60));

        /*
         * 1. CRIAÇÃO DE LISTAS
         *
         * Uma List é uma coleção ORDENADA e INDEXADA.
         * Mantém a sequência exata de inserção dos elementos.
         * Permite acesso direto por posição (índice).
         */
        System.out.println("\n📝 1. CRIAÇÃO DE LISTAS:");

        /*
         * ArrayList:
         * - Melhor para acesso aleatório (get por índice) - O(1)
         * - Pior para inserções/remoções no meio - O(n)
         * - Baseado em array redimensionável internamente
         */
        List<String> frutas = new ArrayList<>();
        frutas.add("maçã");
        frutas.add("banana");
        frutas.add("laranja");
        System.out.println("   ArrayList: " + frutas);

        /*
         * LinkedList:
         * - Melhor para inserções/remoções no início/meio - O(1)
         * - Pior para acesso aleatório - O(n)
         * - Implementa também a interface Deque (fila dupla)
         * - Cada elemento tem referência para o próximo e anterior
         */
        List<String> tarefas = new LinkedList<>();
        tarefas.add("Estudar Java");
        tarefas.add("Fazer exercícios");
        tarefas.add("Revisar código");
        System.out.println("   LinkedList: " + tarefas);

        /*
         * Arrays.asList():
         * CUIDADO: A lista retornada tem tamanho fixo! Não pode adicionar/remover.
         * Use new ArrayList<>(Arrays.asList(...)) para ter uma lista mutável.
         */
        List<Integer> numeros = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("   Lista a partir de array: " + numeros);

        /*
         * List.of() - Java 9+
         * Cria uma lista IMUTÁVEL (qualquer alteração lança UnsupportedOperationException)
         */
        List<String> cores = List.of("vermelho", "azul", "verde");
        System.out.println("   List.of() (imutável): " + cores);

        // ============================================================
        // 2. ADICIONAR ELEMENTOS
        // ============================================================
        System.out.println("\n➕ 2. ADICIONAR ELEMENTOS:");

        frutas.add("uva");
        System.out.println("   add('uva') [Final]: " + frutas);

        frutas.add(1, "morango");
        System.out.println("   add(1, 'morango') [Índice]: " + frutas);

        frutas.addAll(Arrays.asList("abacaxi", "manga"));
        System.out.println("   addAll(['abacaxi', 'manga']): " + frutas);

        List<String> citricas = Arrays.asList("limão", "tangerina");
        frutas.addAll(2, citricas);
        System.out.println("   addAll(2, cítricas): " + frutas);

        // ============================================================
        // 3. ACESSAR ELEMENTOS
        // ============================================================
        System.out.println("\n🔍 3. ACESSAR ELEMENTOS:");

        System.out.println("   get(0): " + numeros.get(0) + "  (primeiro elemento)");
        System.out.println("   get(2): " + numeros.get(2) + "  (terceiro elemento)");

        /*
         * subList(início, fim) - Retorna uma VISÃO parcial da lista.
         * Alterações na subList afetam a lista original! O índice 'fim' é exclusivo.
         */
        List<Integer> subLista = numeros.subList(1, 4);
        System.out.println("   subList(1, 4): " + subLista + " (índices 1, 2, 3)");

        List<String> nomes = new ArrayList<>(Arrays.asList("Ana", "Carlos", "Ana", "Bia", "Ana"));
        System.out.println("\n   Lista de nomes: " + nomes);
        System.out.println("   indexOf('Ana'): " + nomes.indexOf("Ana") + " (primeira ocorrência)");
        System.out.println("   lastIndexOf('Ana'): " + nomes.lastIndexOf("Ana") + " (última ocorrência)");

        // ============================================================
        // 4. REMOVER ELEMENTOS
        // ============================================================
        System.out.println("\n➖ 4. REMOVER ELEMENTOS:");

        frutas = new ArrayList<>(Arrays.asList("maçã", "morango", "laranja", "uva"));
        System.out.println("   Antes: " + frutas);
        String removida = frutas.remove(2);
        System.out.println("   remove(2): removeu '" + removida + "' -> " + frutas);

        /*
         * remove(objeto) remove apenas a PRIMEIRA ocorrência e retorna boolean.
         */
        List<String> animais = new ArrayList<>(Arrays.asList("gato", "cachorro", "gato"));
        animais.remove("gato");
        System.out.println("   remove('gato') [Objeto]: " + animais);

        /*
         * removeAll: Remove todos os elementos contidos na outra coleção (Interseção)
         */
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 2, 3));
        nums.removeAll(Arrays.asList(2, 3));
        System.out.println("   removeAll([2, 3]): " + nums);

        List<String> temp = new ArrayList<>(Arrays.asList("a", "b", "c"));
        temp.clear();
        System.out.println("   clear(): " + temp + " (vazia)");

        // ============================================================
        // 5. VERIFICAR ELEMENTOS
        // ============================================================
        System.out.println("\n✓ 5. VERIFICAÇÕES:");
        System.out.println("   contains('maçã'): " + frutas.contains("maçã"));
        System.out.println("   isEmpty(): " + frutas.isEmpty());
        System.out.println("   size(): " + frutas.size());

        // ============================================================
        // 6. ORDENAÇÃO
        // ============================================================
        System.out.println("\n📊 6. ORDENAÇÃO:");
        List<Integer> desordenada = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9));
        Collections.sort(desordenada);
        System.out.println("   sort() natural: " + desordenada);

        List<String> palavras = new ArrayList<>(Arrays.asList("banana", "a", "casa"));
        Collections.sort(palavras, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("   sort() personalizado (tamanho): " + palavras);

        // ============================================================
        // 7. ITERAÇÃO
        // ============================================================
        System.out.println("\n🔄 7. ITERAÇÃO:");
        System.out.print("   for-each: ");
        for (String fruta : frutas) { System.out.print(fruta + " "); }
        System.out.println();

        /*
         * Iterator: Única forma segura de remover elementos durante a iteração
         * para evitar ConcurrentModificationException.
         */
        Iterator<String> it = frutas.iterator();
        while (it.hasNext()) {
            if (it.next().equals("maçã")) { it.remove(); }
        }
        System.out.println("   Lista após remoção via Iterator: " + frutas);
    }

    // ============================================================
    // DEMONSTRAÇÃO COMPLETA DE SET
    // ============================================================

    public static void demonstrarSet() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🔧 OPERAÇÕES COMPLETAS COM SET");
        System.out.println("=".repeat(60));

        /*
         * 1. CRIAÇÃO DE SETS
         * Um Set NÃO permite elementos duplicados. Baseado no conceito de Conjunto.
         */
        System.out.println("\n📝 1. CRIAÇÃO DE SETS:");

        // HashSet: Rápido O(1), mas não garante nenhuma ordem. Permite um null.
        Set<String> frutasHashSet = new HashSet<>();
        frutasHashSet.add("maçã");
        frutasHashSet.add("banana");
        frutasHashSet.add("laranja");
        System.out.println("   HashSet (sem ordem): " + frutasHashSet);

        // LinkedHashSet: Mantém a ordem de inserção dos elementos.
        Set<String> frutasLinked = new LinkedHashSet<>();
        frutasLinked.add("maçã");
        frutasLinked.add("banana");
        frutasLinked.add("laranja");
        System.out.println("   LinkedHashSet (ordem de inserção): " + frutasLinked);

        // TreeSet: Mantém os elementos na ordem natural (alfabética/crescente) - O(log n). Não aceita null.
        Set<Integer> numerosTree = new TreeSet<>(Arrays.asList(5, 2, 8, 1));
        System.out.println("   TreeSet (ordem natural ordenada): " + numerosTree);

        // ============================================================
        // 2. COMPORTAMENTO DE DUPLICATAS
        // ============================================================
        System.out.println("\n➕ 2. COMPORTAMENTO COM DUPLICATAS:");

        Set<String> exemploSet = new HashSet<>();
        System.out.println("   add('maçã'): " + exemploSet.add("maçã") + " -> " + exemploSet);
        System.out.println("   add('banana'): " + exemploSet.add("banana") + " -> " + exemploSet);
        /*
         * Se tentar adicionar repetido, retorna FALSE e rejeita silenciosamente.
         */
        System.out.println("   add('maçã') repetido: " + exemploSet.add("maçã") + " -> " + exemploSet);

        // Operação de União usando addAll (elimina repetidos automaticamente)
        Set<Integer> uniao = new HashSet<>(Arrays.asList(1, 2, 3));
        uniao.addAll(Arrays.asList(3, 4, 5));
        System.out.println("   União via addAll([3, 4, 5]): " + uniao);
    }

    // ============================================================
    // COMPARATIVO DE PERFORMANCE
    // ============================================================

    public static void compararPerformance() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("⚡ COMPARATIVO DE PERFORMANCE (BIG O)");
        System.out.println("=".repeat(60));

        /*
         * Aqui entendemos o impacto de escolher a estrutura errada.
         * O Set brilha em checar existência (contains), a List brilha em pegar por índice (get).
         */
        System.out.println("\n| Operação          | ArrayList | LinkedList | HashSet  | TreeSet   |");
        System.out.println("|-------------------|-----------|------------|----------|-----------|");
        System.out.println("| Buscar por Índice | O(1)      | O(n)       | Não tem  | Não tem   |");
        System.out.println("| Buscar por Valor  | O(n)      | O(n)       | O(1)     | O(log n)  |");
        System.out.println("| Inserir no Final  | O(1) Amort| O(1)       | O(1)     | O(log n)  |");
        System.out.println("| Remover por Valor | O(n)      | O(n)       | O(1)     | O(log n)  |");
    }

    // ============================================================
    // CASOS DE USO PRÁTICOS
    // ============================================================

    public static void casosDeUsoPraticos() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("💼 CASOS DE USO REAIS");
        System.out.println("=".repeat(60));

        // Caso List: Histórico de Navegação ou Timeline (A ordem importa, duplicatas importam)
        System.out.println("\n🎬 Caso LIST (Timeline de ações):");
        List<String> historicoAcoes = new ArrayList<>();
        historicoAcoes.add("Login efetuado");
        historicoAcoes.add("Clicou no produto A");
        historicoAcoes.add("Clicou no produto A"); // repetição válida
        historicoAcoes.add("Logout efetuado");
        System.out.println("   Histórico preservado na ordem: " + historicoAcoes);

        // Caso Set: Filtrar CPFs ou Ids únicos de uma requisição (Duplicatas não podem existir)
        System.out.println("\n🔒 Caso SET (Garantia de registros únicos):");
        List<String> cpfsRecebidos do Servidor = Arrays.asList("111", "222", "111", "333", "222");
        Set<String> cpfsValidados = new HashSet<>(cpfsRecebidos do Servidor);
        System.out.println("   Bruto recebido: " + cpfsRecebidos do Servidor);
        System.out.println("   Filtrado automaticamente via Set: " + cpfsValidados);
    }

    // ============================================================
    // RESUMO FINAL
    // ============================================================

    public static void resumoFinal() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🏁 RESUMO FINAL: QUANDO USAR O QUE?");
        System.out.println("=".repeat(60));

        System.out.println("\n💡 Use LIST se:");
        System.out.println("   1. A ordem de inserção dos elementos precisa ser mantida.");
        System.out.println("   2. Você precisa acessar os dados usando índices numéricos (ex: get(4)).");
        System.out.println("   3. Elementos duplicados são permitidos e fazem sentido para o negócio.");

        System.out.println("\n💡 Use SET se:");
        System.out.println("   1. Elementos duplicados forem estritamente proibidos.");
        System.out.println("   2. A ordem das informações não importar (ou se você quiser ordem natural via TreeSet).");
        System.out.println("   3. Você precisar fazer muitas buscas por valor (.contains()). Ele é infinitamente mais veloz.");
        System.out.println();
    }
}