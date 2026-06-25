package Listas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainListas {

    public static void main(String[] args) {

        /*
        ===============================================================================
        LISTAS (LIST) EM JAVA
        ===============================================================================

        O QUE É UMA LISTA?

        Uma lista é uma coleção dinâmica de elementos.

        Diferente dos vetores (arrays), seu tamanho pode aumentar
        ou diminuir durante a execução do programa.

        ARRAY:
        int[] numeros = new int[10];

        LISTA:
        List<Integer> numeros = new ArrayList<>();

        ===============================================================================
        DECLARAÇÃO DA LISTA
        ===============================================================================

        List<String> nomes = new ArrayList<>();

        List
        → Interface que define o comportamento de uma lista.

        String
        → Tipo dos elementos armazenados.

        nomes
        → Variável que referencia a lista.

        ArrayList
        → Implementação mais comum da interface List.

        ===============================================================================
        */

        // Criação da lista
        List<String> nomes = new ArrayList<>();

        /*
        ===============================================================================
        ADICIONANDO ELEMENTOS
        ===============================================================================
        */

        nomes.add("Marcelo");
        nomes.add(" Maria");
        nomes.add("Alexandre");
        nomes.add("Tiago");
        nomes.add("Marcelo");
        nomes.add(" Maria");
        nomes.add("Alexandre");
        nomes.add("Tiago");
        nomes.add("Mariana");
        nomes.add("Miguel");
        nomes.add("Pedro");
        nomes.add("Marta");
        nomes.add("Lucas");
        nomes.add("Matheus");
        nomes.add("Fernanda");
        nomes.add("Juliana");
        nomes.add("Murilo");
        nomes.add("Ricardo Amaral");
        nomes.add("Monica");
        nomes.add("Gabriel");
        nomes.add("Michele");
        nomes.add("Rafael Domingos");
        nomes.add("Mateus");
        nomes.add("Patricia");

        /*
        ===============================================================================
        SOBRECARGA DO MÉTODO add()
        ===============================================================================

        add(element)
        → Adiciona no final da lista.

        add(index, element)
        → Adiciona em uma posição específica.

        Ao inserir em uma posição,
        os elementos posteriores são deslocados.
        ===============================================================================
        */

        nomes.add(2, "Domingos Dinis");

        /*
        ===============================================================================
        EXIBIÇÃO 1 - SYSTEM.OUT.PRINTLN()
        ===============================================================================

        Forma mais rápida de visualizar a lista.

        Muito utilizada para:
        ✓ Testes rápidos
        ✓ Depuração (Debug)

        Exemplo:

        System.out.println(nomes);

        Resultado:

        [1ª Nome: Marcelo, 2ª Nome: Maria, Domingos Dinis,
         3ª Nome: Alexandre, 4ª Nome: Tiago]
        ===============================================================================
        */

        System.out.println("\n=== EXIBIÇÃO COM PRINTLN ===");
        System.out.println(nomes);

        /*
        ===============================================================================
        EXIBIÇÃO 2 - FOR-EACH
        ===============================================================================

        Percorre todos os elementos da lista.

        Leitura:

        "Para cada String chamada nome dentro da lista nomes"

        Estrutura:

        for (String nome : nomes) {
            ...
        }

        Quando utilizar?

        ✓ Apenas ler elementos.
        ✓ Exibir informações.
        ✓ Relatórios.
        ✓ Código mais limpo.
        ===============================================================================
        */

        System.out.println("\n=== EXIBIÇÃO COM FOR-EACH ===");

        for (String nome : nomes) {
            System.out.println(nome);
        }

        /*
        ===============================================================================
        EXIBIÇÃO 3 - FOR TRADICIONAL
        ===============================================================================

        Permite acessar o índice da lista.

        Quando utilizar?

        ✓ Preciso da posição.
        ✓ Preciso alterar elementos.
        ✓ Algoritmos.
        ✓ Ordenação.
        ===============================================================================
        */

        System.out.println("\n=== EXIBIÇÃO COM FOR TRADICIONAL ===");

        for (int i = 0; i < nomes.size(); i++) {

            System.out.println(
                    "Posição " + i +
                            " → " + nomes.get(i)
            );
        }

        /*
        ===============================================================================
        TAMANHO DA LISTA
        ===============================================================================

        size()
        → Retorna a quantidade de elementos.

        Vetor:
        vetor.length

        Lista:
        lista.size()
        ===============================================================================
        */

        System.out.println("\nQuantidade de elementos:");
        System.out.println(nomes.size());

        /*
        ===============================================================================
        REMOVENDO ELEMENTOS
        ===============================================================================

        remove(index)
        → Remove pela posição.

        remove(element)
        → Remove pelo valor.

        Exemplo:

        nomes.remove("Domingos Dinis");
        ===============================================================================
        */

        nomes.remove("Domingos Dinis");

        System.out.println("\n=== LISTA APÓS REMOÇÃO ===");
        System.out.println(nomes);

        //removendo pelaposição
        /*
        //nomes.remove(0);
        nomes.removeFirst(); //promeiro
        nomes.removeLast();
        */
         //Remover pelo predicado, ou seja nomes que começam com certa letra
        /*
          Expressão lambda
          Para cada elemento da lista chamado nome.
          Pega o primeiro caractere da String.

          algo parecido com
          for (String nome : nomes) {

            if (nome.charAt(0) == 'M') {
                // remove
            }

        }
          /*

         nomes.removeIf(removerCaracter -> removerCaracter.trim().charAt(0) == 'M');
         retorna true/false



        Entra na lista nomes e remove todos os elementos
        cujo primeiro caractere seja a letra 'M'.

        removeIf()
        → Percorre a lista e remove os elementos que atendem
          à condição especificada.

        trim()
        → Remove espaços no início e no final da String.

        charAt(0)
        → Retorna o primeiro caractere da String.

        == 'M'
        → Verifica se o primeiro caractere é igual à letra M.
        */




        System.out.println("---------remover elemento pelo predicado -----");
        nomes.removeIf(removecaracter -> removecaracter.trim().charAt(0) == 'A');
        System.out.println(nomes);

        /*
        ===============================================================================
        WRAPPER CLASSES
        ===============================================================================

        Listas não aceitam tipos primitivos.

        INCORRETO:

        List<int> numeros;

        CORRETO:

        List<Integer> numeros;

        TIPO PRIMITIVO      WRAPPER
        ----------------------------------------------------
        int                 Integer
        double              Double
        char                Character
        boolean             Boolean
        long                Long
        float               Float
        byte                Byte
        short               Short

        ===============================================================================
        RESUMO
        ===============================================================================

        add()
        → Adiciona elemento.

        add(index, element)
        → Adiciona em posição específica.

        remove()
        → Remove elemento.

        get()
        → Obtém elemento.

        size()
        → Retorna quantidade.

        for-each
        → Percorrer elementos.

        for tradicional
        → Trabalhar com posições.

        System.out.println(lista)
        → Exibição rápida.

        ===============================================================================
        */

        System.out.println("---------encontrar a posição do elemento -----");
        System.out.println("index of Alexandre: " + nomes.indexOf("Alexandre"));
        //não existe na lista
        System.out.println("index of Mateus: " + nomes.indexOf("Mateus"));

        System.out.println("---------Deixar na lista somente nomes que começam com um caractere -----");
        nomes.removeIf(removecaracter -> removecaracter.trim().charAt(0) == 'M');

        //declar uma nova lista que vai filtrar a lista anterior e retornar o resultado requerido

        List<String> resultado = nomes.stream()
                .filter(nome -> nome.trim().charAt(0) == 'R')
                .collect(Collectors.toList());

        System.out.println(resultado);

        System.out.println("---------primeiro elemento que começa com R -----");
        String nome1 = nomes.stream().filter(nome -> nome.trim().charAt(0) == 'J').findFirst().orElse(null);
        System.out.println(nome1);

    }
}