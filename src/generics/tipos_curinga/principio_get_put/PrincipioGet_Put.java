package generics.tipos_curinga.principio_get_put;

import java.util.ArrayList;
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

        // Lista de Number
        List<Object> objList = new ArrayList<>();
        objList.add("Dinis");
        objList.add("Aline");

        /*
         * =========================================================================
         * CONTRAVARIÂNCIA (Contravariance)
         * =========================================================================
         *
         * List<? super Integer>
         *
         * Aceita uma lista de Integer ou de qualquer uma de suas superclasses.
         *
         * Neste exemplo:
         *
         *      Integer
         *          ▲
         *          │
         *       Number
         *          ▲
         *          │
         *        Object
         *
         * Como Number é superclasse de Integer,
         * podemos fazer:
         */

        /*
         * ? super Number significa:
         *
         * Aceita uma referência para uma lista cujo tipo seja
         * Number ou qualquer uma de suas superclasses.
         *
         * Exemplos válidos:
         *
         *     List<Number>
         *     List<Object>
         *
         * Exemplo inválido:
         *
         *     List<Integer> // Integer é subclasse de Number
         */
        List<? super Number> myNums = objList;

        // PUT (Adicionar) -> PERMITIDO
        myNums.add(30); //-> qualquer valor do tipo Number(ex:30) ou objetos de um super tipo de number, mas não pode acessar os objets da lista
        myNums.add(40.5);


        // pode acessar o elemento da lista e tentar guardar
        // numa variável do tipo Number os objets da lista(da erro de compilação
        //Number x = myNums.get(0);  erro

        // GET (Ler) -> Apenas Object é garantido
        Object obj = myNums.get(0);

        System.out.println(obj);

        /*
         * Isto NÃO é permitido:
         *
         * Integer x = list.get(0); // Erro
         *
         * porque o compilador não sabe se a lista real é:
         *
         *      List<Integer>
         *      List<Number>
         *      List<Object>
         *
         * Portanto, ele garante apenas Object.
         */
    }
}
