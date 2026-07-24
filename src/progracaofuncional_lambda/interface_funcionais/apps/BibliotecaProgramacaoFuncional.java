package progracaofuncional_lambda.interface_funcionais.apps;

import progracaofuncional_lambda.entities.Product;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/*
====================================================================================================
                        📚 MANUAL DEFINITIVO & BIBLIOTECA DE PROGRAMAÇÃO FUNCIONAL
====================================================================================================

1. O QUE É PROGRAMAÇÃO FUNCIONAL (PF)?
----------------------------------------------------------------------------------------------------
A Programação Funcional é um paradigma DECLARATIVO. Em vez de instruir o computador sobre COMO
executar uma tarefa passo a passo (mutando variáveis, controlando ponteiros de loops e decidindo
com 'if/else'), você declara O QUE deseja obter encadeando funções puras e transformações de dados.

2. OS 4 PILARES DA PROGRAMAÇÃO FUNCIONAL:
----------------------------------------------------------------------------------------------------
• Imutabilidade: Um dado criado nunca é alterado. Em vez de modificar um objeto, você gera um NOVO
  objeto com a alteração desejada. Isso elimina bugs de concorrência/threads.
• Funções Puras (Pure Functions): Funções que não geram "efeitos colaterais" (side-effects). Para a
  mesma entrada, SEMPRE retornam exatamente a mesma saída, sem alterar o mundo externo (banco de dados,
  variáveis globais ou os próprios parâmetros recebidos).
• Transparência Referencial: Uma chamada de função pode ser substituída diretamente pelo seu valor
  resultante sem alterar o comportamento do sistema.
• Funções de Alta Ordem (Higher-Order Functions): Funções são "Cidadãs de Primeira Classe". Elas podem
  ser passadas como parâmetros para outros métodos, armazenadas em variáveis ou retornadas.

3. DIAGRAMA DE FLUXO E MENTALIDADE: IMPERATIVO vs. FUNCIONAL (PIPELINE)
----------------------------------------------------------------------------------------------------

┌──────────────────────────────────────────────────────────────────────────────────────────────────┐
│ FLUXO IMPERATIVO (Tradicional): FOCO NO "COMO"                                                   │
├──────────────────────────────────────────────────────────────────────────────────────────────────┤
│ Entrada ──► [ Loop Manual (for) ] ──► [ Decisão (if / else) ] ──► [ Mutação de Estado ] ──► Saída│
└──────────────────────────────────────────────────────────────────────────────────────────────────┘

┌──────────────────────────────────────────────────────────────────────────────────────────────────┐
│ FLUXO FUNCIONAL (Stream / Pipeline): FOCO NO "O QUE"                                             │
├──────────────────────────────────────────────────────────────────────────────────────────────────┤
│ Fonte   ──► [ .filter(Predicate) ] ──► [ .map(Function) ] ──► [ .reduce / .collect ] ──► Resultado│
│ (Dados)     (Filtra sem 'if')          (Mapeia/Transforma)    (Agrega / Reduz)             Novo  │
└──────────────────────────────────────────────────────────────────────────────────────────────────┘

4. O QUE É MAIS USADO NO MUNDO REAL / MERCADO DE TRABALHO?
----------------------------------------------------------------------------------------------------
No mercado moderno (Java 8+ até Java 21+), O MODELO HÍBRIDO É O REI:
• Orientação a Objetos (OO) é usada para ARQUITETURA e ESTRUTURA (Domain Models, Classes, Serviços,
  Injeção de Dependência, Entidades de Banco de Dados).
• Programação Funcional (PF) é usada dentro dos MÉTODOS para PROCESSAMENTO DE DADOS, REGRAS DE NEGÓCIO,
  FILTROS, TRATAMENTO DE NULOS (Optional) e PARALELISMO.

Por que o mercado prefere a PF para manipular dados?
1. Menos Bugs: Sem 'if/else' e sem mutação de estado, elimina-se o NullPointerException e Side-Effects.
2. Legibilidade e Manutenibilidade: Pipelines de Streams parecem frases legíveis em inglês.
3. Paralelismo Fácil: Trocar `.stream()` por `.parallelStream()` divide o processamento entre múltiplos
   núcleos do processador sem precisar gerenciar Threads manualmente.

====================================================================================================
*/

/**
 * Classe Guia Executável que funciona como uma Biblioteca de Estudos.
 * Demonstra a transição do modelo tradicional imperativo para o funcional puro.
 */
public class BibliotecaProgramacaoFuncional {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        // Massa de dados inicial (Base para todas as demonstrações)
        List<Product> produtos = Arrays.asList(
                new Product("Teclado Mecânico", 350.00),
                new Product("Mouse Gamer", 180.00),
                new Product("TV Smart 50\"", 2800.00),
                new Product("Tablet Samsung", 1500.00),
                new Product("Toalha de Mesa", 60.00),
                new Product("Headset HyperX", 420.00)
        );

        System.out.println("======================================================================");
        System.out.println(" 1. INTERFACES FUNCIONAIS NATIVAS (A BASE DO JAVA FUNCIONAL)");
        System.out.println("======================================================================");
        demonstrarInterfacesNativas(produtos);

        System.out.println("\n======================================================================");
        System.out.println(" 2. COMPARATIVO PROFUNDO: IMPERATIVO vs. FUNCIONAL (MERCADO REAL)");
        System.out.println("======================================================================");
        demonstrarComparativoEstrutural(produtos);

        System.out.println("\n======================================================================");
        System.out.println(" 3. ADEUS IF/ELSE E NULLPOINTER: USO DE OPTIONAL E PATTERNS");
        System.out.println("======================================================================");
        demonstrarTratamentoSemIfElse(produtos);
    }

    /**
     * SEÇÃO 1: As 4 Interfaces Funcionais Nativas do pacote {@code java.util.function}.
     * Elas substituem a necessidade de criar interfaces personalizadas.
     */
    public static void demonstrarInterfacesNativas(List<Product> produtos) {

        /*
         * A) PREDICATE<T>: T -> boolean
         * Recebe um objeto do tipo T e retorna um valor booleano.
         * Subsitui os blocos 'if' de verificação.
         */
        Predicate<Product> eProdutoCaro = p -> p.getPrice() > 1000.0;
        System.out.println("• [Predicate] O primeiro produto é caro? " + eProdutoCaro.test(produtos.get(0)));

        /*
         * B) FUNCTION<T, R>: T -> R
         * Recebe um objeto do tipo T e o transforma/mapeia em um objeto do tipo R.
         * Substitui atribuições manuais de variáveis.
         */
        Function<Product, String> extrairNomeEmMaiusculo = p -> p.getName().toUpperCase();
        System.out.println("• [Function] Nome transformado: " + extrairNomeEmMaiusculo.apply(produtos.get(0)));

        /*
         * C) CONSUMER<T>: T -> void
         * Recebe um objeto do tipo T e executa uma ação com efeito colateral (ex: imprimir, salvar),
         * sem retornar nada.
         */
        Consumer<Product> imprimirProduto = p -> System.out.println("  [Consumer] Item: " + p.getName() + " | R$ " + p.getPrice());
        imprimirProduto.accept(produtos.get(0));

        /*
         * D) SUPPLIER<T>: () -> T
         * Não recebe nenhum parâmetro e entrega/fabrica um novo objeto do tipo T.
         */
        Supplier<Product> criadorDePadrao = () -> new Product("Produto Genérico", 0.0);
        System.out.println("• [Supplier] Criado dinamicamente: " + criadorDePadrao.get().getName());
    }

    /**
     * SEÇÃO 2: Comparativo Prático.
     * Mostra o mesmo problema resolvido das duas formas, ressaltando o padrão do MUNDO REAL.
     */
    public static void demonstrarComparativoEstrutural(List<Product> produtos) {

        // PROBLEMA: Somar os preços dos produtos cujo nome começa com 'T' e aplicar um desconto de 10%.

        // ---------------------------------------------------------------------------------------------
        // FORMA 1: IMPERATIVA / TRADICIONAL
        // Problemas: Mutação da variável 'soma', controle manual de loop e 'if' explícito.
        // ---------------------------------------------------------------------------------------------
        double somaImperativa = 0.0;
        for (Product p : produtos) {
            if (p.getName().startsWith("T")) {  // Controle de fluxo explícito
                double precoComDesconto = p.getPrice() * 0.90; // Estado intermediário
                somaImperativa += precoComDesconto;            // Mutação de estado
            }
        }
        System.out.println("Soma Imperativa (Tradicional): R$ " + String.format("%.2f", somaImperativa));

        // ---------------------------------------------------------------------------------------------
        // FORMA 2: FUNCIONAL DECLARATIVA (Streams + Lambdas)
        // Vantagens: Imutável, sem 'if', sem variáveis temporárias, 100% thread-safe.
        // ---------------------------------------------------------------------------------------------
        double somaFuncional = produtos.stream()
                .filter(p -> p.getName().startsWith("T")) // Predicate: filtra os dados
                .mapToDouble(p -> p.getPrice() * 0.90)    // Function: transforma o preço com desconto
                .sum();                                   // Reduction: reduz a massa de dados a um único resultado

        System.out.println("Soma Funcional (Mundo Real)   : R$ " + String.format("%.2f", somaFuncional));
    }

    /**
     * SEÇÃO 3: Como a Programação Funcional substitui 'if/else' e previne o famoso 'NullPointerException'.
     */
    public static void demonstrarTratamentoSemIfElse(List<Product> produtos) {

        Product produtoNulo = null;

        // ---------------------------------------------------------------------------------------------
        // TRADICIONAL (Com 'if/else' e risco de NullPointerException)
        // ---------------------------------------------------------------------------------------------
        String resultadoImperativo;
        if (produtoNulo != null) {
            if (produtoNulo.getName() != null) {
                resultadoImperativo = produtoNulo.getName().toUpperCase();
            } else {
                resultadoImperativo = "NOME AUSENTE";
            }
        } else {
            resultadoImperativo = "PRODUTO INEXISTENTE";
        }
        System.out.println("Resultado com 'if/else': " + resultadoImperativo);

        // ---------------------------------------------------------------------------------------------
        // FUNCIONAL (Com Optional, sem 'if', sem 'else' e 100% seguro contra nulos)
        // ---------------------------------------------------------------------------------------------
        String resultadoFuncional = Optional.ofNullable(produtoNulo)
                .map(Product::getName)
                .map(String::toUpperCase)
                .orElse("PRODUTO INEXISTENTE (TRATADO COM OPTIONAL FUNCIONAL)");

        System.out.println("Resultado Funcional    : " + resultadoFuncional);

        // Exemplo avançado de pipeline funcional agrupando produtos por faixa de preço
        System.out.println("\n• Agrupando produtos no Mundo Real (sem nenhum if/else no código):");
        Map<Boolean, List<Product>> produtosDivisoes = produtos.stream()
                .collect(Collectors.partitioningBy(p -> p.getPrice() > 400.0));

        System.out.println("  - Caros (> 400) : " + produtosDivisoes.get(true).size() + " itens");
        System.out.println("  - Baratos (<=400): " + produtosDivisoes.get(false).size() + " itens");
    }
}