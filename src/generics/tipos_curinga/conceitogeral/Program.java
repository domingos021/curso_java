package generics.tipos_curinga.conceitogeral;


import generals_utils.utils.Leitor;
import generics.tipos_curinga.conceitogeral.model.entities.Person;

import java.util.*;

public class Program {
    /*
     * =========================================================================
     * GENERICS - TIPO CURINGA (Wildcard)
     * =========================================================================
     *
     * O tipo curinga é representado pelo símbolo '?'.
     *
     * Diferentemente de um parâmetro de tipo (T), o curinga não cria um novo
     * tipo genérico. Ele apenas indica que um determinado tipo existe, porém
     * é desconhecido ou não importa para a operação realizada.
     *
     * Exemplos:
     *
     *     List<?> list;
     *
     * A lista pode ser:
     *
     *     List<String>
     *     List<Integer>
     *     List<Product>
     *     List<Person>
     *
     * Todas são compatíveis com List<?>.
     *
     * =========================================================================
     * DIFERENÇA ENTRE T E ?
     * =========================================================================
     *
     * T (Type)
     * --------
     * Representa um tipo genérico conhecido dentro do método ou da classe.
     * O compilador sabe que todos os Ts representam exatamente o mesmo tipo.
     *
     * Exemplo:
     *
     *     public static <T> void printList(List<T> list)
     *
     * Se T for Product:
     *
     *     List<Product>
     *
     * então:
     *
     *     T -> Product
     *
     * Todo T dentro do método será Product.
     *
     * =========================================================================
     *
     * ? (Wildcard)
     * ------------
     * Representa um tipo desconhecido.
     *
     * O compilador apenas sabe que existe algum tipo,
     * mas não sabe qual é.
     *
     * Exemplo:
     *
     *     List<?>
     *
     * Pode ser:
     *
     *     List<String>
     *     List<Integer>
     *     List<Person>
     *     List<Product>
     *
     * =========================================================================
     * O QUE PODEMOS FAZER COM List<?> ?
     * =========================================================================
     *
     * Como o tipo dos elementos é desconhecido,
     * podemos apenas realizar operações seguras,
     * como:
     *
     *     - consultar o tamanho da lista;
     *     - percorrer seus elementos;
     *     - ler seus elementos como Object.
     *
     * Exemplo:
     *
     *     for (Object obj : list) {
     *         System.out.println(obj);
     *     }
     *
     * =========================================================================
     * O QUE NÃO PODEMOS FAZER?
     * =========================================================================
     *
     * Como o compilador não sabe qual é o tipo da lista,
     * ele impede adicionar novos elementos.
     *
     * Exemplo:
     *
     *     List<?> list = new ArrayList<String>();
     *
     *     list.add("Maria");      // Erro
     *     list.add(10);           // Erro
     *     list.add(new Product());// Erro
     *
     * Isso evita que um objeto de tipo incorreto seja
     * inserido na coleção.
     *
     * =========================================================================
     * RESUMO
     * =========================================================================
     *
     * <T>  -> O tipo é conhecido e será utilizado durante toda a classe
     *         ou método.
     *
     * <?>  -> O tipo existe, mas é desconhecido.
     *
     * Utilizamos Wildcards quando não precisamos saber qual é
     * o tipo exato da coleção, apenas trabalhar com ela de
     * forma genérica e segura.
     * =========================================================================
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        /*
         * List<Integer>
         * -------------
         * Criamos uma lista cujo tipo dos elementos é Integer.
         *
         * Em seguida, passamos essa lista para o método printList().
         *
         * Embora printList() receba um List<?>, isso funciona porque
         * o tipo curinga (?) aceita listas de qualquer tipo:
         *
         *      List<Integer>
         *      List<String>
         *      List<Product>
         *      List<Person>
         *
         * Ou seja, List<?> representa "uma lista de um tipo
         * desconhecido".
         */
        List<Integer>  myIntlist = Arrays.asList(1, 2, 4,  6, 8);
        printList(myIntlist);

        List<Person> myPersonList = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            int n = Leitor.lerNumeroInteiro(sc,"Quantas pessoas: ");

            for (int i = 0; i < n; i++) {
                System.out.printf("%dº pessoa: ", i + 1);
                String name = Leitor.lerTexto(sc, "Nome : ");
                int age = Leitor.lerNumeroInteiro(sc, "Idade: ");

                Person p = new Person(name, age);
                myPersonList.add(p);

            }

            printList(myPersonList);


        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }




    }
    /*
     * Método genérico utilizando um tipo curinga (Wildcard).
     *
     * List<?> significa:
     * "Aceita uma lista de qualquer tipo."
     *
     * O compilador não sabe qual é o tipo dos elementos
     * (Integer, String, Product, Person, etc.),
     * apenas sabe que todos pertencem a uma lista.
     *
     * Por esse motivo:
     *
     * ✔ Podemos percorrer a lista.
     * ✔ Podemos consultar seu tamanho.
     * ✔ Podemos ler seus elementos.
     *
     * Porém, como o tipo é desconhecido,
     * os elementos são tratados como Object.
     *
     * Também não é permitido adicionar novos elementos
     * (exceto null), pois o compilador não consegue
     * garantir a segurança de tipos.
     * *
     * *Esse metodo funciona para qualquer tipo de lista
     */
    public static void printList(List<?> list) {
        /*
         * Como o tipo da lista é desconhecido (<?>),
         * cada elemento é lido como Object.
         *
         * Isso é possível porque toda a classe em Java
         * herda, direta ou indiretamente, de Object.
         */
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}



/*
 * Arrays.asList(...)
 * ------------------
 * Cria uma lista de tamanho fixo.
 *
 * Exemplo:
 *     List<Integer> numbers = Arrays.asList(1, 2, 3);
 *
 * ✔ Permite:
 *     numbers.set(0, 10);
 *
 * ❌ Não permite:
 *     numbers.add(4);
 *     numbers.remove(0);
 *
 * ----------------------------------------------------
 *
 * ArrayList
 * ---------
 * Cria uma lista dinâmica, permitindo alterar seu tamanho
 * durante a execução do programa.
 *
 * Exemplo:
 *     List<Integer> numbers = new ArrayList<>();
 *
 * ✔ Permite:
 *     numbers.add(1);
 *     numbers.add(2);
 *     numbers.remove(0);
 *     numbers.set(0, 10);
 */
