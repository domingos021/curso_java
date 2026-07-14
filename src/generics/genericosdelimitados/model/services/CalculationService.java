package generics.genericosdelimitados.model.services;

import java.util.List;

/**
 * Serviço genérico para a realização de cálculos e análises sobre coleções.
 */
public class CalculationService {

    /**
     * Encontra e retorna o maior elemento de uma lista.
     * * =========================================================================
     * ENTENDENDO A ASSINATURA DO MÉTODO:
     * =========================================================================
     * * 1. <T extends Comparable<T>>
     * -> <T extends Comparable<T>>
     * -> Diz que o tipo genérico T deve ser um subtipo de Comparable<T>.
     * -> Na prática, exige que T implemente a interface Comparable<T>.
     * -> IMPORTANTE: 'Comparable' é uma INTERFACE NATIVA DO JAVA (java.lang.Comparable).
     * -> Graças a essa restrição, o compilador garante que qualquer objeto 'T'
     * que entrar aqui terá o método '.compareTo()' disponível para uso.
     * -> Classes nativas (String, Integer, Double) funcionam de imediato porque
     * já implementam essa interface. Suas classes personalizadas (Product, Person)
     * precisam implementá-la para serem aceitas aqui.
     * * 2. T (Retorno do método)
     * -> O método retorna um objeto do tipo genérico (T), ou seja, o retorno será
     * exatamente do mesmo tipo dos elementos que estão dentro da lista.
     * * 3. (List<T> list)
     * -> Como parâmetro, o método aceita uma lista contendo elementos de qualquer
     * tipo de dados (T), desde que respeitem a regra do Comparable.
     * * =========================================================================
     */
    public static <T extends Comparable<T>> T max(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("List can't be empty");
        }

        // T max -> Variável temporária genérica para guardar o maior elemento encontrado.
        // Começa assumindo que o 1º elemento (índice 0) é o maior.
        T max = list.get(0);

        // T item -> Cada elemento iterado dentro do laço será do tipo genérico T.
        for (T item : list) {

            // Compara cada 'item' da lista com o 'max' atual.
            // O método compareTo() retorna:
            //   > 0 : Se 'item' for maior que 'max'
            //  == 0 : Se forem iguais
            //   < 0 : Se 'item' for menor que 'max'
            if (item.compareTo(max) > 0) {
                max = item; // Se for maior que 0, atualiza o 'max' com o valor do 'item' atual.
            }
        }

        return max; // Retorna o valor máximo encontrado, que é do tipo genérico (T).
    }
}


/*
 * =========================================================================
 * DOCUMENTAÇÃO DE ESTUDOS: GENERICS & COMPARABLE
 * =========================================================================
 *
 * Este guia explica as duas abordagens da interface Comparable, o papel
 * da interface nativa do Java em comparação com a nossa personalizada,
 * e desmistifica o uso de 'extends' e 'implements' no universo do Generics.
 *
 * =========================================================================
 * 1. INTERFACE NATIVA (Java) vs. INTERFACE PERSONALIZADA (Criada por nós)
 * =========================================================================
 *
 * Embora o código de ambas seja idêntico, o compilador do Java as enxerga
 * de maneiras completamente diferentes por causa de seus "pacotes" (packages).
 *
 * -------------------------------------------------------------------------
 * Abordagem A: Interface Nativa (java.lang.Comparable)
 * -------------------------------------------------------------------------
 * - É a interface padrão que já vem embutida no coração do ecossistema Java.
 * - Classes padrão (String, Integer, Double, etc.) já a implementam "de fábrica".
 * - VANTAGEM: Interoperabilidade universal. Qualquer recurso nativo do Java,
 * como "Collections.sort(lista)" ou estruturas como "TreeSet", exige
 * obrigatoriamente que seus objetos implementem esta interface nativa.
 *
 * -------------------------------------------------------------------------
 * Abordagem B: Interface Personalizada (Criada para fins de estudo)
 * -------------------------------------------------------------------------
 * - É a interface que criamos dentro de nossa própria estrutura de pastas
 * (ex: interfaces.interface_comparable.model.Comparable).
 * - VANTAGEM: Excelente exercício acadêmico para entender como os contratos
 * funcionam e desmistificar a linguagem, provando que não há "mágica".
 * - DESVANTAGEM: Isolamento total. O compilador do Java não sabe que ela é
 * "prima" da dele. Se sua classe Product herdar da SUA interface, ela NÃO
 * poderá ser ordenada usando o método pronto "Collections.sort()".
 *
 * -------------------------------------------------------------------------
 * TABELA DE COMPARAÇÃO PRÁTICA:
 * -------------------------------------------------------------------------
 * Recurso                               | Com a do Java | Com a Sua
 * -------------------------------------|---------------|-----------
 * Comparar suas próprias classes       |      SIM      |    SIM
 * Seu método CalculationService.max()  |      SIM      |    SIM (1)
 * Ordenar com Collections.sort()       |      SIM      |    NÃO
 * Usar com Integer, String, Double     |      SIM      |    NÃO (2)
 *
 * (1) Desde que seu CalculationService importe a sua interface personalizada.
 * (2) Porque as classes do Java não implementam a sua interface personalizada.
 *
 * =========================================================================
 * 2. A GRANDE CONFUSÃO SINTÁTICA: 'implements' vs. 'extends'
 * =========================================================================
 *
 * Por que usamos "implements" na assinatura de nossas classes, mas dentro do
 * Generics escrevemos "<T extends Comparable>" mesmo sabendo que Comparable
 * é uma interface?
 *
 * -------------------------------------------------------------------------
 * Regra 1: Na estrutura física da Classe (Programação Orientada a Objetos)
 * -------------------------------------------------------------------------
 * O Java é rígido e segue a regra padrão de herança:
 * - 'extends'    => Usado exclusivamente para herdar de outra CLASSE.
 * - 'implements' => Usado exclusivamente para implementar contratos de INTERFACES.
 *
 * Exemplo:
 * public class Product implements Comparable<Product> { ... }
 * ^^^^^^^^^^
 * (Usa 'implements' porque Comparable é uma interface)
 *
 * -------------------------------------------------------------------------
 * Regra 2: Na declaração do Generics (Tipos Delimitados / Bounded Types)
 * -------------------------------------------------------------------------
 * No contexto de Generics, os criadores do Java decidiram simplificar a
 * sintaxe. Para evitar criar novas palavras-chave na linguagem, padronizaram
 * que a palavra-chave 'extends' significa "é um subtipo de", servindo tanto
 * para classes quanto para interfaces.
 *
 * Exemplo:
 * public static <T extends Comparable<T>> T max(List<T> list)
 * ^^^^^^^
 * (Usa 'extends' mesmo sabendo que Comparable é uma interface!)
 *
 * -------------------------------------------------------------------------
 * POR QUE FIZERAM ISSO? (Vantagem Técnica)
 * -------------------------------------------------------------------------
 * 1. Simplicidade: Menos palavras reservadas para o compilador processar.
 * 2. Tipos de Interseção (Múltiplas restrições): Caso você precise que 'T'
 * seja herdeiro de uma classe (ex: Person) E também implemente uma
 * interface (ex: Comparable), a sintaxe unificada com 'extends' resolve
 * tudo de forma elegante usando o caractere '&':
 *
 * <T extends Person & Comparable<T>>
 *
 * Se tivessem mantido a distinção 'extends'/'implements' dentro dos
 * parâmetros genéricos, a linha acima seria extremamente confusa de ler
 * e processar.
 *
 * =========================================================================
 * RESUMO PARA FIXAÇÃO:
 * =========================================================================
 * No mundo das CLASSES físicas:
 * [Classe]  ---- implements ---->  [Interface]
 * [Classe]  ----  extends   ---->  [Outra Classe]
 *
 * No mundo dos GENERICS (Filtros de tipo <T>):
 * [T extends Interface]  ==>  "Qualquer classe que implemente esta interface"
 * [T extends Classe]     ==>  "Qualquer classe que herde desta classe"
 * =========================================================================
 */

