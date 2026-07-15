package generics.tipos_curinga.delimitado;



import generics.tipos_curinga.delimitado.model.entities.Circle_coringa;
import generics.tipos_curinga.delimitado.model.entities.Rectangle_curinga;

import java.util.ArrayList;
import java.util.List;

public class Curinga_delimitado {
    /*
     * =========================================================================
     * GENERICS - TIPOS CURINGA DELIMITADOS (Bounded Wildcards)
     * =========================================================================
     *
     * Um tipo curinga delimitado é um Wildcard (?) que possui uma restrição.
     *
     * Enquanto:
     *
     *      List<?>
     *
     * aceita listas de qualquer tipo,
     *
     * os tipos curinga delimitados permitem restringir quais tipos
     * serão aceitos.
     *
     * Existem duas formas:
     *
     *      ? extends Tipo
     *      ? super Tipo
     *
     * =========================================================================
     * ? extends Tipo (Limite Superior)
     * =========================================================================
     *
     * Aceita o tipo informado e qualquer uma de suas subclasses.
     *
     * Exemplo:
     *
     *      List<? extends Number>
     *
     * Aceita:
     *
     *      List<Integer>
     *      List<Double>
     *      List<Float>
     *      List<Long>
     *
     * Não aceita:
     *
     *      List<String>
     *      List<Person>
     *
     * Como não sabemos exatamente qual subtipo de Number existe na lista,
     * o Java permite apenas operações seguras de leitura.
     *
     * Podemos ler elementos:
     *
     *      Number n = list.get(0);
     *
     * Porém não podemos adicionar novos elementos:
     *
     *      list.add(10);          // Erro
     *      list.add(10.5);        // Erro
     *
     * Isso acontece porque o compilador não sabe se a lista é
     * List<Integer>, List<Double> ou outro subtipo de Number.
     *
     * =========================================================================
     * ? super Tipo (Limite Inferior)
     * =========================================================================
     *
     * Aceita o tipo informado e qualquer uma de suas superclasses.
     *
     * Exemplo:
     *
     *      List<? super Integer>
     *
     * Aceita:
     *
     *      List<Integer>
     *      List<Number>
     *      List<Object>
     *
     * Não aceita:
     *
     *      List<Double>
     *      List<String>
     *
     * Como sabemos que qualquer uma dessas listas pode armazenar
     * Integer, o Java permite adicionar elementos.
     *
     * Exemplo:
     *
     *      list.add(10);      // OK
     *
     * Porém, ao ler elementos, o compilador garante apenas Object:
     *
     *      Object obj = list.get(0);
     *
     * =========================================================================
     * RESUMO
     * =========================================================================
     *
     * <?>
     *      Aceita qualquer tipo.
     *
     * <? extends Tipo>
     *      Aceita o tipo e seus subtipos.
     *      Ideal para LEITURA.
     *
     * <? super Tipo>
     *      Aceita o tipo e seus supertipos.
     *      Ideal para ESCRITA (add).
     *
     * =========================================================================
     */

    public static void main(String[] args) {
        /*
         * Lista declarada com o tipo da classe base (Shape_curing).
         *
         * Como Rectangle_curinga e Circle_coringa herdam de Shape_curing,
         * ambos podem ser armazenados nessa lista.
         *
         * Exemplo:
         *
         *     Shape_curing
         *          |
         *     --------------
         *     |            |
         * Rectangle     Circle
         *
         * Portanto:
         *
         *     List<Shape_curing>
         *
         * aceita diferentes tipos de figuras.
         */
        List<Shape_curing> shapeList = new ArrayList<>();

        shapeList.add(new Rectangle_curinga(3.0, 2.0));
        shapeList.add(new Circle_coringa(2.0));


        /*
         * Lista declarada especificamente como Circle_coringa.
         *
         * Ela aceita apenas objetos Circle_coringa.
         *
         * Não seria permitido:
         *
         *     cl.add(new Rectangle_curinga(3.0, 2.0)); // Erro
         *
         * porque Rectangle_curinga também é Shape_curing,
         * mas não é Circle_coringa.
         *
         * Porém, essa lista pode ser passada para métodos
         * que recebem:
         *
         *     List<? extends Shape_curing>
         *
         * porque Circle_coringa é uma subclasse de Shape_curing.
         */
        List<Circle_coringa> cl = new ArrayList<>();
        List<Rectangle_curinga> r = new ArrayList<>();

        cl.add(new Circle_coringa(2.0));
        cl.add(new Circle_coringa(4.0));

        r.add(new Rectangle_curinga(4.00, 5.00));

        /*
         * O método totalArea recebe uma lista de qualquer tipo
         * que seja Shape_curing ou uma de suas subclasses.
         *
         * Portanto aceita:
         *
         * List<Shape_curing>
         * List<Circle_coringa>
         * List<Rectangle_curinga>
         *
         * O uso de ? extends permite trabalhar com diferentes
         * tipos de figuras mantendo a segurança de tipos.
         */

        System.out.println("Total area retangle: " + totalArea(r));
        System.out.println("Total area circle: " + totalArea(cl));
        System.out.println("Total area  shape: " + totalArea(shapeList));  // envia o (shapeList) dentro do parâmetro do  método total area


    }

    /*
     * Calcula a soma das áreas de todas as figuras da lista.
     *
     * =========================================================================
     * ENTENDENDO O PARÂMETRO:
     * =========================================================================
     *
     * List<? extends Shape_curing>
     *
     * ? extends Shape_curing significa:
     *
     * "Aceita uma lista de Shape_curing ou de qualquer classe que herde
     * de Shape_curing."
     *
     * Exemplos válidos:
     *
     *      List<Shape_curing>
     *      List<Circle>
     *      List<Rectangle>
     *
     * Como todas essas classes são Shapes, o compilador garante
     * que cada elemento possui o método area().
     *
     * Por esse motivo, podemos percorrer a lista e chamar:
     *
     *      sh.area();
     *
     * sem precisar saber qual é a figura específica
     * (círculo, retângulo, etc.).
     *
     * Neste caso, a lista é utilizada apenas para leitura,
     * por isso o uso de '? extends' é ideal.
     *
     * Ao final, o método retorna a soma das áreas de todas
     * as figuras presentes na lista.
     */
    public static double totalArea(List<? extends Shape_curing> list) {
        /*
         * Não é permitido adicionar elementos em uma lista definida como:
         *
         *     List<? extends Shape_curing>
         *
         * porque o tipo exato da lista é desconhecido.
         *
         * Ela poderia ser:
         *
         *     List<Circle_coringa>
         *     List<Rectangle_curinga>
         *     List<Shape_curing>
         *
         * Se fosse permitido adicionar um Rectangle, poderíamos
         * inserir um tipo errado dentro de uma lista de Circle.
         *
         * Por isso:
         *
         *     list.add(new Rectangle_curinga()); // ERRO
         *
         * O uso de ? extends é destinado principalmente para leitura.
         */
       // list.add(new Rectangle_curinga(5.00,2.00)); //da erro
        double sum = 0.0;

        for (Shape_curing sh : list) {
            sum += sh.area();
        }

        return sum;
    }
}
