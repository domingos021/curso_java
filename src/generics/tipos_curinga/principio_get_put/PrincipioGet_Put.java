package generics.tipos_curinga.principio_get_put;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class PrincipioGet_Put {

    /*
     * =========================================================================
     * PRINCÍPIO GET / PUT (PECS)
     * =========================================================================
     *
     * O princípio Get/Put define quando utilizar:
     *
     *      ? extends Tipo
     *      ? super Tipo
     *
     * Ele pode ser resumido pela regra:
     *
     *      Producer Extends
     *      Consumer Super
     *
     * ou simplesmente:
     *
     *      PECS
     *
     * =========================================================================
     * GET (Producer -> ? extends)
     * =========================================================================
     *
     * Utilize '? extends' quando o objetivo principal for
     * LER (get) elementos da coleção.
     *
     * Exemplo:
     *
     *      List<? extends Shape>
     *
     * O método pode receber:
     *
     *      List<Shape>
     *      List<Circle>
     *      List<Rectangle>
     *
     * Como todos os elementos são pelo menos um Shape,
     * podemos fazer:
     *
     *      Shape sh = list.get(0);
     *      sh.area();
     *
     * Porém NÃO podemos adicionar elementos:
     *
     *      list.add(new Circle());     // Erro
     *      list.add(new Rectangle());  // Erro
     *
     * Isso acontece porque o compilador não conhece o tipo
     * exato da lista.
     *
     * =========================================================================
     * PUT (Consumer -> ? super)
     * =========================================================================
     *
     * Utilize '? super' quando o objetivo principal for
     * ADICIONAR (put) elementos na coleção.
     *
     * Exemplo:
     *
     *      List<? super Integer>
     *
     * O método pode receber:
     *
     *      List<Integer>
     *      List<Number>
     *      List<Object>
     *
     * Como todas essas listas podem armazenar Integer,
     * podemos fazer:
     *
     *      list.add(10);          // OK
     *      list.add(20);          // OK
     *
     * Entretanto, ao ler elementos:
     *
     *      Object obj = list.get(0);
     *
     * O compilador só garante Object,
     * pois não sabe qual é a superclasse real da lista.
     *
     * =========================================================================
     * RESUMO
     * =========================================================================
     *
     * ? extends
     *      ✔ Ler (GET)
     *      ✘ Adicionar (PUT)
     *
     * ? super
     *      ✔ Adicionar (PUT)
     *      ✘ Ler como tipo específico (apenas Object)
     *
     * =========================================================================
     * REGRA PARA MEMORIZAR
     * =========================================================================
     *
     * Producer -> Extends
     * Consumer -> Super
     *
     * Se a coleção PRODUZ dados para você ler:
     *
     *      ? extends
     *
     * Se a coleção CONSOME dados que você adiciona:
     *
     *      ? super
     *
     * =========================================================================
     */

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);


        List<Integer> myInts = Arrays.asList(1,2,3,4);
        List<Double> myDoubles = Arrays.asList(3.4,6.28);
        List<Object> myObjs = new ArrayList<>();

        //=============== Lista de inteiros =================
        copy(myInts,myObjs);
        printList(myObjs); //imprime

        //================= lista de Double ============
        copy(myDoubles,myObjs);
        printList(myObjs);//imprime
    }

    /*
     * Lista de origem (Source) ->List<? extends  Number> source (covariaça)
     *
     * List<? extends Number>
     *
     * Representa uma lista de algum tipo que é Number
     * ou uma de suas subclasses.
     *
     * Exemplos:
     *     List<Integer>
     *     List<Double>
     *     List<Float>
     *
     * Como não sabemos o tipo exato da lista,
     * ela é ideal para leitura (GET).
     */


    /*
     * Lista de destino (Target) ->List<? super Number> target (contravariança)
     *
     * List<? super Number>
     *
     * Representa uma lista de Number ou de qualquer
     * uma de suas superclasses.
     *
     * Exemplos:
     *     List<Number>
     *     List<Object>
     *
     * Como sabemos que essas listas podem armazenar
     * objetos Number, elas são ideais para escrita (PUT).
     */

    //===========================================================================================
    /*
     * Copia todos os elementos de uma lista de origem (source)
     * para uma lista de destino (target).
     *
     * =========================================================================
     * List<? extends Number> source
     * =========================================================================
     *
     * A lista de origem utiliza '? extends Number' porque
     * seu objetivo é apenas PRODUZIR (GET) elementos.
     *
     * Ela pode ser:
     *
     *     List<Integer>
     *     List<Double>
     *     List<Float>
     *     List<Number>
     *
     * Como todos esses tipos são Number ou subclasses,
     * podemos fazer:
     *
     *     Number number = source.get(i);
     *
     * Porém não podemos adicionar elementos na lista source.
     *
     * =========================================================================
     * List<? super Number> target
     * =========================================================================
     *
     * A lista de destino utiliza '? super Number' porque
     * seu objetivo é CONSUMIR (PUT) elementos.
     *
     * Ela pode ser:
     *
     *     List<Number>
     *     List<Object>
     *
     * Como essas listas aceitam objetos Number,
     * podemos adicionar:
     *
     *     target.add(number);
     *
     * =========================================================================
     * PRINCÍPIO GET / PUT (PECS)
     * =========================================================================
     *
     * Source (Producer)  -> ? extends Number
     * Target (Consumer)  -> ? super Number
     *
     * Ou seja:
     *
     *     GET  -> extends
     *     PUT  -> super
     */
    public static void copy(List<? extends Number> source,
                            List<? super Number> target) {

        for (Number number : source) {
            target.add(number);
        }
    }

    //método para imprimir a lista
    //List<?> => lista de qualquer tipo

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }



}
