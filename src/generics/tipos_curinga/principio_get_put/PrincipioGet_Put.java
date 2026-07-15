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
        List<Integer> IntList = new ArrayList<>();
        IntList.add(1);
        IntList.add(2);

        List<? extends Number> NumberList = IntList;
        /*
         * =========================================================================
         * COVARIÂNCIA (Covariance)
         * =========================================================================
         *
         * Ocorre quando utilizamos:
         *
         *      ? extends Tipo
         *
         * A coleção pode PRODUZIR (GET) elementos para leitura,
         * porém não permite ADICIONAR (PUT) novos elementos.
         *
         * Exemplo:
         *
         *      List<? extends Shape>
         *
         * Podemos fazer:
         *
         *      Shape sh = list.get(0);   // OK
         *
         * Mas não:
         *
         *      list.add(new Circle());   // Erro
         *
         * =========================================================================
         * CONTRAVARIÂNCIA (Contravariance)
         * =========================================================================
         *
         * Ocorre quando utilizamos:
         *
         *      ? super Tipo
         *
         * A coleção pode CONSUMIR (PUT) elementos,
         * porém, ao recuperar um elemento (GET),
         * o compilador garante apenas Object.
         *
         * Exemplo:
         *
         *      List<? super Integer>
         *
         * Podemos fazer:
         *
         *      list.add(10);             // OK
         *
         * Porém:
         *
         *      Object obj = list.get(0); // OK
         *
         * Não podemos assumir:
         *
         *      Integer n = list.get(0);  // Erro
         *
         * =========================================================================
         * RESUMO
         * =========================================================================
         *
         * Covariance      -> ? extends
         *                    ✔ GET
         *                    ✘ PUT
         *
         * Contravariance  -> ? super
         *                    ✔ PUT
         *                    ✘ GET (como tipo específico)
         */
        Number x = NumberList.get(0); //pode acessar os elementos


      //  NumberList.add(20); // mas não pode adicionar nada na lista(da erro de compilação)


    }
}
